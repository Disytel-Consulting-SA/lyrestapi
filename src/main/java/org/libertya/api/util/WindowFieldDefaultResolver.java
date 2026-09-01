package org.libertya.api.util;

import org.libertya.api.common.UserInfo;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;
import org.openXpertya.util.DisplayType;
import org.openXpertya.util.Env;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;


/**
 * Resuelve valores por defecto definidos en AD_Column.DefaultValue
 * para su utilización por el frontend dinámico.
 *
 * La lógica se basa en MField.getDefault() de Libertya CORE,
 * evitando depender del modelo Swing MWindow/MTab/MField.
 *
 * El valor final se retorna siempre como String porque ése es
 * el contrato definido por WindowSchemaField.defaultvalue.
 */
public final class WindowFieldDefaultResolver {

    private static final CLogger log =
            CLogger.getCLogger(
                    WindowFieldDefaultResolver.class
            );

    /*
     * La REST API no posee una instancia MWindow.
     *
     * WindowNo = 0 permite igualmente resolver valores
     * globales del contexto (#AD_Client_ID, #AD_Org_ID, etc.).
     */
    private static final int WINDOW_NO = 0;


    private WindowFieldDefaultResolver() {
    }


    public static String resolve(
            UserInfo info,
            Integer adReferenceId,
            String columnName,
            boolean isKey,
            boolean isParent,
            String defaultValue) {

        /*
         * MField.getDefault() no genera defaults
         * para keys, RowID ni Binary.
         */
        if (isKey
                || adReferenceId == DisplayType.RowID
                || adReferenceId == DisplayType.Binary) {

            return null;
        }


        Properties ctx =
                info != null
                        ? info.getCtx()
                        : Env.getCtx();


        /*
         * IsActive posee un default implícito.
         */
        if ("IsActive".equals(columnName)) {

            return "Y";
        }


        /*
         * Intentar primero el DefaultValue explícito
         * definido en AD_Column.
         */
        if (!isEmpty(defaultValue)) {

            String resolved =
                    resolveExplicitDefault(
                            ctx,
                            columnName,
                            defaultValue
                    );


            String normalized =
                    normalize(
                            columnName,
                            adReferenceId,
                            resolved
                    );


            if (normalized != null) {

                return normalized;
            }
        }


        /*
         * Un parent sin DefaultValue se obtiene en CORE
         * desde el contexto del registro padre.
         *
         * Al recuperar /schema todavía no tenemos un
         * registro padre seleccionado.
         */
        if (isParent) {

            return null;
        }


        /*
         * Defaults implícitos de MField.getDefault().
         */

        // Button -> N
        if (adReferenceId == DisplayType.Button
                && columnName != null
                && !columnName.endsWith("_ID")) {

            return "N";
        }


        // YesNo -> N
        if (adReferenceId == DisplayType.YesNo) {

            return "N";
        }


        // IDs permanecen null
        if (columnName != null
                && columnName.endsWith("_ID")) {

            return null;
        }


        // Valores numéricos -> 0
        if (adReferenceId != null
                && DisplayType.isNumeric(
                adReferenceId
        )) {

            return "0";
        }


        return null;
    }


    /**
     * Resuelve el contenido explícito de
     * AD_Column.DefaultValue.
     */
    private static String resolveExplicitDefault(
            Properties ctx,
            String columnName,
            String defaultValue) {

        /*
         * Default mediante sentencia SQL.
         */
        if (defaultValue.startsWith("@SQL=")) {

            return resolveSql(
                    ctx,
                    columnName,
                    defaultValue
            );
        }


        /*
         * Libertya permite alternativas separadas
         * mediante coma o punto y coma.
         */
        StringTokenizer tokenizer =
                new StringTokenizer(
                        defaultValue,
                        ",;",
                        false
                );


        while (tokenizer.hasMoreTokens()) {

            String token =
                    tokenizer
                            .nextToken()
                            .trim();


            String resolved =
                    resolveToken(
                            ctx,
                            token
                    );


            if (!isEmpty(resolved)) {

                return resolved;
            }
        }


        return null;
    }


    /**
     * Resuelve un token individual.
     */
    private static String resolveToken(
            Properties ctx,
            String token) {

        if (isEmpty(token)) {

            return null;
        }


        /*
         * Fecha/hora actual.
         */
        if ("@SysDate@".equals(token)) {

            return new Timestamp(
                    System.currentTimeMillis()
            ).toString();
        }


        /*
         * Variable de contexto.
         *
         * Env realizará fallback hacia #variable
         * cuando no exista un valor de ventana.
         */
        if (token.indexOf('@') != -1) {

            String variable =
                    token
                            .replace('@', ' ')
                            .trim();


            String value =
                    Env.getContext(
                            ctx,
                            WINDOW_NO,
                            variable
                    );


            return isEmpty(value)
                    ? null
                    : value;
        }


        /*
         * Literal delimitado mediante comillas simples.
         */
        if (token.indexOf('\'') != -1) {

            token =
                    token
                            .replace('\'', ' ')
                            .trim();
        }


        return isEmpty(token)
                ? null
                : token;
    }


    /**
     * Normaliza el valor resuelto según el tipo de
     * field, reproduciendo conceptualmente
     * MField.createDefault().
     *
     * El resultado continúa siendo String porque
     * ése es el contrato REST elegido.
     */
    private static String normalize(
            String columnName,
            Integer adReferenceId,
            String value) {

        if (isEmpty(value)) {

            return null;
        }


        try {

            /*
             * IDs, Integer y CreatedBy/UpdatedBy.
             *
             * La conversión tiene además el efecto
             * deseado de transformar un literal
             * inválido como "null" en null.
             */
            if ((columnName != null
                    && (columnName.endsWith("atedBy")
                    || columnName.endsWith("_ID")))
                    || adReferenceId == DisplayType.Integer) {

                return Integer.valueOf(
                        value
                ).toString();
            }


            /*
             * Valores numéricos.
             */
            if (adReferenceId != null
                    && DisplayType.isNumeric(
                    adReferenceId
            )) {

                return new BigDecimal(
                        value
                ).toPlainString();
            }


            /*
             * YesNo.
             *
             * CORE interpreta como true únicamente "Y".
             * Para nuestro contrato String conservamos
             * la representación Libertya Y/N.
             */
            if (adReferenceId == DisplayType.YesNo) {

                return "Y".equals(value)
                        ? "Y"
                        : "N";
            }


            /*
             * Para fechas mantenemos la representación
             * textual ya resuelta. La conversión concreta
             * se realizará en el frontend según el tipo
             * semántico del field.
             */
            return value;


        } catch (Exception e) {

            /*
             * MField.createDefault() devuelve null
             * cuando el valor no puede convertirse
             * al tipo correspondiente.
             */
            log.log(
                    Level.FINE,
                    "DefaultValue inválido para "
                            + columnName
                            + ": "
                            + value
            );

            return null;
        }
    }


    /**
     * Resuelve un DefaultValue @SQL=...
     */
    private static String resolveSql(
            Properties ctx,
            String columnName,
            String defaultValue) {

        String sql =
                defaultValue.substring(5);


        sql =
                Env.parseContext(
                        ctx,
                        WINDOW_NO,
                        sql,
                        false,
                        true
                );


        if (isEmpty(sql)) {

            log.log(
                    Level.WARNING,
                    "No fue posible resolver variables del "
                            + "DefaultValue SQL para columna "
                            + columnName
                            + ": "
                            + defaultValue
            );

            return null;
        }


        PreparedStatement ps = null;
        ResultSet rs = null;


        try {

            ps =
                    DB.prepareStatement(
                            sql,
                            null
                    );


            rs =
                    ps.executeQuery();


            if (rs.next()) {

                Object value =
                        rs.getObject(1);


                return value != null
                        ? String.valueOf(value)
                        : null;
            }


        } catch (Exception e) {

            log.log(
                    Level.WARNING,
                    "Error resolviendo DefaultValue SQL "
                            + "para columna "
                            + columnName
                            + ": "
                            + defaultValue,
                    e
            );


        } finally {

            DB.close(
                    rs,
                    ps
            );
        }


        return null;
    }


    private static boolean isEmpty(
            String value) {

        return value == null
                || value.trim().isEmpty();
    }
}