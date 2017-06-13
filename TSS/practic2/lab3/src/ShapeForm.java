
/**
 * Enumeration class for shape form
 */
public enum ShapeForm {

    STAR_BIG(1),
    STAR_SMALL(3),
    RECTANGLE(5),
    PATH(7),
    ARC(9);

    private int value;

    private ShapeForm(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Returns ShapeForm enumeration object by integer number.
     * If such object is not found then the IllegalArgumentException will be thrown.
     * @param formId The integer value which represent shape form
     * @return ShapeForm enumeration object
     */
    public static ShapeForm getShapeFormById(int formId) {
        for(ShapeForm shf : values()) {
            if (shf.getValue() == formId) {
                return shf;
            }
        }
        throw new IllegalArgumentException("There is no shape form with ID [" + formId + "]");
    }

}
