package org.libertya.api.security;

import org.libertya.api.exception.ModelException;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
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

        /**
         * Liga los valores desde la posicion {@code first} y devuelve la siguiente libre.
         * <p>
         * Los textos se ligan sin tipo ({@link Types#OTHER}) para que PostgreSQL los lea con el tipo de la columna
         * con la que se comparan, igual que un literal escrito en el SQL: {@code updated > '2026-11-01'} o
         * {@code c_bpartner_id = '1012145'}. Ligados como {@code varchar} fallan contra columnas de fecha o
         * numericas ({@code operator does not exist: timestamp > character varying}). Siguen siendo parametros:
         * PostgreSQL los convierte al tipo de la columna o da error, nunca los interpreta como SQL.
         * <p>
         * Va la variante de cuatro argumentos a proposito: el {@code CPreparedStatement} del core (lo que devuelve
         * {@code DB.prepareStatement}) descarta el tipo en {@code setObject(int, Object, int)} y llama a
         * {@code setObject(int, Object)}; la de cuatro si lo pasa al driver.
         */
        public int bind(PreparedStatement ps, int first) throws SQLException {
            int p = first;
            for (Object value : values) {
                if (value instanceof String)
                    ps.setObject(p++, value, Types.OTHER, 0);
                else
                    ps.setObject(p++, value);
            }
            return p;
        }
    }

    /**
     * Columna que el filtro admite aunque la tabla no la tenga, resuelta con un predicado SQL fijo escrito en el
     * codigo del repositorio (por ejemplo, el almacen de M_Storage a traves de M_Locator). Del filtro solo se toman
     * los valores: admite {@code = n} e {@code IN (n, ...)} con numeros, que se ligan como parametros en el lugar
     * de {@link #VALUES}. El texto del filtro nunca llega al SQL.
     * <p>
     * La plantilla se concatena al SQL tal cual: tiene que ser una constante del codigo, nunca armarse con datos del
     * request. No confundir con las columnas virtuales del diccionario de Libertya ({@code AD_Column.ColumnSQL}).
     */
    public static final class DerivedColumn {
        public static final String VALUES = "{values}";
        private final String sqlTemplate;

        /** @param sqlTemplate predicado SQL que contiene {@link #VALUES} una sola vez */
        public DerivedColumn(String sqlTemplate) {
            int at = sqlTemplate.indexOf(VALUES);
            if (at < 0 || at != sqlTemplate.lastIndexOf(VALUES))
                throw new IllegalArgumentException("La plantilla debe contener " + VALUES + " una sola vez");
            this.sqlTemplate = sqlTemplate;
        }

        private String render(String placeholders) {
            return "(" + sqlTemplate.replace(VALUES, placeholders) + ")";
        }
    }

    private static final class Token {
        final String type, text;
        Token(String type, String text) { this.type = type; this.text = text; }
    }

    private final String input;
    private final Map<String, String> columns;
    private final Map<String, DerivedColumn> derivedColumns;
    private final List<Token> tokens = new ArrayList<>();
    private final List<Object> values = new ArrayList<>();
    private int pos;

    private SafeQueryFilter(String input, Map<String, String> columns, Map<String, DerivedColumn> derivedColumns)
            throws ModelException {
        this.input = input;
        this.columns = columns;
        this.derivedColumns = derivedColumns;
        tokenize();
    }

    public static Compiled compile(String input, Map<String, String> columns) throws ModelException {
        return compile(input, columns, Collections.emptyMap());
    }

    /**
     * @param columns        columnas reales de la tabla, por nombre en minusculas
     * @param derivedColumns columnas derivadas, por nombre en minusculas; una columna real del mismo nombre tiene
     *                       prioridad
     */
    public static Compiled compile(String input, Map<String, String> columns,
                                   Map<String, DerivedColumn> derivedColumns) throws ModelException {
        if (input == null || input.trim().isEmpty())
            return new Compiled("1=1", Collections.emptyList());
        String normalized = input.trim();
        // Compatibilidad con filtros historicos documentados entre comillas dobles.
        // Solo se retira el par exterior; no se eliminan caracteres internos.
        if (normalized.length() >= 2 && normalized.charAt(0) == '"' &&
                normalized.charAt(normalized.length() - 1) == '"')
            normalized = normalized.substring(1, normalized.length() - 1);
        SafeQueryFilter parser = new SafeQueryFilter(normalized, columns, derivedColumns);
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
        String key = t.text.toLowerCase(Locale.ROOT);
        String column = columns.get(key);
        if (column == null) {
            DerivedColumn derived = derivedColumns.get(key);
            if (derived == null) throw new ModelException("Columna no permitida: " + t.text);
            return derivedPredicate(t.text, derived);
        }

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
    /** Columna derivada: solo {@code = n} o {@code IN (n, ...)}. El SQL lo pone la plantilla; del filtro salen los valores. */
    private String derivedPredicate(String name, DerivedColumn derived) throws ModelException {
        List<String> placeholders = new ArrayList<>();
        if (take("=")) {
            placeholders.add(numberLiteral(name));
        } else if (take("IN")) {
            expect("(");
            placeholders.add(numberLiteral(name));
            while (take(",")) placeholders.add(numberLiteral(name));
            expect(")");
        } else {
            throw new ModelException("Operador no permitido para " + name + ": solo = o IN");
        }
        return derived.render(String.join(", ", placeholders));
    }
    private String numberLiteral(String name) throws ModelException {
        if (!tokens.get(pos).type.equals("NUMBER"))
            throw new ModelException("Se esperaba un número para " + name);
        return literal();
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
