package org.libertya.api.security;

import org.libertya.api.exception.ModelException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Parser de expresiones de filtro HTTP. No interpreta SQL general:
 * solo predicados sobre columnas conocidas y literales parametrizados.
 */
public final class SafeQueryFilter {
    public static final class Compiled {
        public final String sql;
        public final List<Object> values;
        private Compiled(String sql, List<Object> values) {
            this.sql = sql;
            this.values = Collections.unmodifiableList(new ArrayList<>(values));
        }
    }

    private static final class Token {
        final String type, text;
        Token(String type, String text) { this.type = type; this.text = text; }
    }

    private final String input;
    private final Map<String, String> columns;
    private final List<Token> tokens = new ArrayList<>();
    private final List<Object> values = new ArrayList<>();
    private int pos;

    private SafeQueryFilter(String input, Map<String, String> columns) throws ModelException {
        this.input = input;
        this.columns = columns;
        tokenize();
    }

    public static Compiled compile(String input, Map<String, String> columns) throws ModelException {
        if (input == null || input.trim().isEmpty())
            return new Compiled("1=1", Collections.emptyList());
        String normalized = input.trim();
        // Compatibilidad con filtros historicos documentados entre comillas dobles.
        // Solo se retira el par exterior; no se eliminan caracteres internos.
        if (normalized.length() >= 2 && normalized.charAt(0) == '"' &&
                normalized.charAt(normalized.length() - 1) == '"')
            normalized = normalized.substring(1, normalized.length() - 1);
        SafeQueryFilter parser = new SafeQueryFilter(normalized, columns);
        String sql = parser.expression();
        if (!parser.is("END"))
            throw new ModelException("Sintaxis de filtro no admitida");
        return new Compiled(sql, parser.values);
    }

    private void tokenize() throws ModelException {
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            if (Character.isWhitespace(c)) { i++; continue; }
            if (c == '\'') {
                StringBuilder value = new StringBuilder();
                i++;
                boolean closed = false;
                while (i < input.length()) {
                    char x = input.charAt(i++);
                    if (x == '\'') {
                        if (i < input.length() && input.charAt(i) == '\'') {
                            value.append('\''); i++;
                        } else { closed = true; break; }
                    } else { value.append(x); }
                }
                if (!closed) throw new ModelException("Literal de texto incompleto");
                tokens.add(new Token("STRING", value.toString()));
                continue;
            }
            if (Character.isLetter(c) || c == '_') {
                int start = i++;
                while (i < input.length() && (Character.isLetterOrDigit(input.charAt(i)) || input.charAt(i) == '_')) i++;
                tokens.add(new Token("WORD", input.substring(start, i)));
                continue;
            }
            if (Character.isDigit(c) || (c == '-' && i + 1 < input.length() && Character.isDigit(input.charAt(i + 1)))) {
                int start = i++;
                while (i < input.length() && Character.isDigit(input.charAt(i))) i++;
                if (i < input.length() && input.charAt(i) == '.') {
                    i++;
                    if (i == input.length() || !Character.isDigit(input.charAt(i)))
                        throw new ModelException("Número inválido en filtro");
                    while (i < input.length() && Character.isDigit(input.charAt(i))) i++;
                }
                tokens.add(new Token("NUMBER", input.substring(start, i)));
                continue;
            }
            if ("(),=<>!".indexOf(c) >= 0) {
                int start = i++;
                if (i < input.length() && "=<>".indexOf(input.charAt(i)) >= 0 && "<>!".indexOf(c) >= 0) i++;
                String op = input.substring(start, i);
                if (op.equals("!") || op.equals("><") || op.equals("=>") || op.equals("=<"))
                    throw new ModelException("Operador no admitido");
                tokens.add(new Token(op, op));
                continue;
            }
            throw new ModelException("Carácter no permitido en filtro");
        }
        tokens.add(new Token("END", ""));
    }

    private boolean is(String type) {
        Token t = tokens.get(pos);
        return t.type.equals(type) || (t.type.equals("WORD") && t.text.equalsIgnoreCase(type));
    }
    private boolean take(String type) { if (is(type)) { pos++; return true; } return false; }
    private void expect(String type) throws ModelException {
        if (!take(type)) throw new ModelException("Se esperaba " + type + " en el filtro");
    }
    private String expression() throws ModelException {
        String left = conjunction();
        while (take("OR")) left = "(" + left + " OR " + conjunction() + ")";
        return left;
    }
    private String conjunction() throws ModelException {
        String left = unary();
        while (take("AND")) left = "(" + left + " AND " + unary() + ")";
        return left;
    }
    private String unary() throws ModelException {
        if (take("NOT")) return "(NOT " + unary() + ")";
        if (take("(")) {
            String sql = expression();
            expect(")");
            return "(" + sql + ")";
        }
        return predicate();
    }
    private String predicate() throws ModelException {
        Token t = tokens.get(pos);
        if (!t.type.equals("WORD")) throw new ModelException("Se esperaba columna en filtro");
        pos++;
        String column = columns.get(t.text.toLowerCase(Locale.ROOT));
        if (column == null) throw new ModelException("Columna no permitida: " + t.text);

        if (take("IS")) {
            boolean not = take("NOT");
            expect("NULL");
            return column + (not ? " IS NOT NULL" : " IS NULL");
        }
        boolean not = take("NOT");
        if (take("IN")) {
            expect("(");
            StringBuilder sql = new StringBuilder(column).append(not ? " NOT IN (" : " IN (");
            sql.append(literal());
            while (take(",")) sql.append(", ").append(literal());
            expect(")");
            return sql.append(")").toString();
        }
        if (take("BETWEEN")) {
            String a = literal();
            expect("AND");
            String b = literal();
            return column + (not ? " NOT BETWEEN " : " BETWEEN ") + a + " AND " + b;
        }
        String like = null;
        if (take("LIKE")) like = "LIKE";
        else if (take("ILIKE")) like = "ILIKE";
        if (like != null) return column + (not ? " NOT " : " ") + like + " " + literal();
        if (not) throw new ModelException("NOT debe acompañar IN, BETWEEN, LIKE o ILIKE");

        String op = tokens.get(pos).type;
        if (!(op.equals("=") || op.equals("<") || op.equals(">") || op.equals("<=")
                || op.equals(">=") || op.equals("<>") || op.equals("!=")))
            throw new ModelException("Operador no permitido en filtro");
        pos++;
        return column + " " + op + " " + literal();
    }
    private String literal() throws ModelException {
        Token t = tokens.get(pos);
        if (t.type.equals("STRING")) {
            pos++;
            values.add(t.text);
            return "?";
        }
        if (t.type.equals("NUMBER")) {
            pos++;
            try { values.add(new BigDecimal(t.text)); }
            catch (NumberFormatException e) { throw new ModelException("Número inválido"); }
            return "?";
        }
        if (take("TRUE")) { values.add(Boolean.TRUE); return "?"; }
        if (take("FALSE")) { values.add(Boolean.FALSE); return "?"; }
        throw new ModelException("Se esperaba valor literal en filtro");
    }
}
