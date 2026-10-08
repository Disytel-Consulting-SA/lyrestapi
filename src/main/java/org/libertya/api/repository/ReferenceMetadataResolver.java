package org.libertya.api.repository;

/**
 * Traduce referencias del diccionario de Libertya a tipos semánticos
 * consumidos por clientes dinámicos.
 *
 * La resolución no depende de AD_Field/AD_Column y puede reutilizarse
 * para otras fuentes de metadata, por ejemplo AD_Process_Para.
 */
public final class ReferenceMetadataResolver {

    public static final int REFERENCE_INTEGER = 11;
    public static final int REFERENCE_AMOUNT = 12;
    public static final int REFERENCE_DATE = 15;
    public static final int REFERENCE_DATETIME = 16;
    public static final int REFERENCE_LIST = 17;
    public static final int REFERENCE_TABLE = 18;
    public static final int REFERENCE_TABLE_DIRECT = 19;
    public static final int REFERENCE_YESNO = 20;
    public static final int REFERENCE_LOCATION = 21;
    public static final int REFERENCE_NUMBER = 22;
    public static final int REFERENCE_TIME = 24;
    public static final int REFERENCE_BUTTON = 28;
    public static final int REFERENCE_QUANTITY = 29;
    public static final int REFERENCE_SEARCH = 30;
    public static final int REFERENCE_MEMO = 34;
    public static final int REFERENCE_TEXT_LONG = 36;
    public static final int REFERENCE_COST_PRICE = 37;

    private ReferenceMetadataResolver() {
    }

    /**
     * Resuelve referencias cuya representación visual no necesita
     * metadata adicional ni un endpoint contextual.
     */
    public static String resolveVisualType(Integer referenceId) {
        if (referenceId == null) return null;

        switch (referenceId) {
            case REFERENCE_INTEGER:
                return "integer";
            case REFERENCE_AMOUNT:
                return "amount";
            case REFERENCE_NUMBER:
                return "number";
            case REFERENCE_QUANTITY:
                return "quantity";
            case REFERENCE_COST_PRICE:
                return "costprice";
            case REFERENCE_DATE:
                return "date";
            case REFERENCE_DATETIME:
                return "datetime";
            case REFERENCE_TIME:
                return "time";
            case REFERENCE_MEMO:
            case REFERENCE_TEXT_LONG:
                return "textarea";
            default:
                return null;
        }
    }
}
