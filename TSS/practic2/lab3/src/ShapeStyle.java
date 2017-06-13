
public enum ShapeStyle {

    WIDTH_THIN(1),
    DEFAULT(3),
    WIDTH_THICK(4),
    COLOR_GRADIENT(7),
    COLOR_RED(8);

    private int value;

    private ShapeStyle(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Returns ShapeStyle enumeration object by integer number.
     * If such object is not found then the IllegalArgumentException will be thrown.
     * @param styleId The integer value which represent shape style
     * @return ShapeStyle enumeration object
     */
    public static ShapeStyle getShapeStyleById(int styleId) {
        for(ShapeStyle shs : values()) {
            if (shs.getValue() == styleId) {
                return shs;
            }
        }
        throw new IllegalArgumentException("There is no shape style with ID [" + styleId + "]");
    }

}
