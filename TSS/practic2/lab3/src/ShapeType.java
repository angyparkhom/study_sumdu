/**
 * Enumeration class for complicate shape type object
 */
public enum ShapeType {

    STAR_BIG_WIDTH_THIN(ShapeForm.STAR_BIG, ShapeStyle.WIDTH_THIN),
    STAR_BIG_DEFAULT(ShapeForm.STAR_BIG, ShapeStyle.DEFAULT),
    STAR_BIG_WIDTH_THICK(ShapeForm.STAR_BIG, ShapeStyle.WIDTH_THICK),
    STAR_BIG_COLOR_GRADIENT(ShapeForm.STAR_BIG, ShapeStyle.COLOR_GRADIENT),
    STAR_BIG_COLOR_RED(ShapeForm.STAR_BIG, ShapeStyle.COLOR_RED),
    STAR_SMALL_WIDTH_THIN(ShapeForm.STAR_SMALL, ShapeStyle.WIDTH_THIN),
    STAR_SMALL_DEFAULT(ShapeForm.STAR_SMALL, ShapeStyle.DEFAULT),
    STAR_SMALL_WIDTH_THICK(ShapeForm.STAR_SMALL, ShapeStyle.WIDTH_THICK),
    STAR_SMALL_COLOR_GRADIENT(ShapeForm.STAR_SMALL, ShapeStyle.COLOR_GRADIENT),
    STAR_SMALL_COLOR_RED(ShapeForm.STAR_SMALL, ShapeStyle.COLOR_RED),
    RECTANGLE_WIDTH_THIN(ShapeForm.RECTANGLE, ShapeStyle.WIDTH_THIN),
    RECTANGLE_DEFAULT(ShapeForm.RECTANGLE, ShapeStyle.DEFAULT),
    RECTANGLE_WIDTH_THICK(ShapeForm.RECTANGLE, ShapeStyle.WIDTH_THICK),
    RECTANGLE_COLOR_GRADIENT(ShapeForm.RECTANGLE, ShapeStyle.COLOR_GRADIENT),
    RECTANGLE_COLOR_RED(ShapeForm.RECTANGLE, ShapeStyle.COLOR_RED),
    PATH_WIDTH_THIN(ShapeForm.PATH, ShapeStyle.WIDTH_THIN),
    PATH_DEFAULT(ShapeForm.PATH, ShapeStyle.DEFAULT),
    PATH_WIDTH_THICK(ShapeForm.PATH, ShapeStyle.WIDTH_THICK),
    PATH_COLOR_GRADIENT(ShapeForm.PATH, ShapeStyle.COLOR_GRADIENT),
    PATH_COLOR_RED(ShapeForm.PATH, ShapeStyle.COLOR_RED),
    ARC_WIDTH_THIN(ShapeForm.ARC, ShapeStyle.WIDTH_THIN),
    ARC_DEFAULT(ShapeForm.ARC, ShapeStyle.DEFAULT),
    ARC_WIDTH_THICK(ShapeForm.ARC, ShapeStyle.WIDTH_THICK),
    ARC_COLOR_GRADIENT(ShapeForm.ARC, ShapeStyle.COLOR_GRADIENT),
    ARC_COLOR_RED(ShapeForm.ARC, ShapeStyle.COLOR_RED);

    private ShapeForm form;
    private ShapeStyle style;
    private int type;

    private ShapeType(ShapeForm form, ShapeStyle style) {
        this.form = form;
        this.style = style;
        type = form.getValue() * 10 + style.getValue();
    }

    public ShapeForm getForm() {
        return form;
    }

    public ShapeStyle getStyle() {
        return style;
    }

    public int getType() {
        return type;
    }

    /**
     * Returns ShapeType enumeration object by integer number.
     * If such object is not found then the IllegalArgumentException will be thrown.
     * The shape type value is being calculated from the shape form and style values.
     * @param typeId The integer value which represent shape type
     * @return ShapeType enumeration object
     */
    public static ShapeType getShapeTypeById(int typeId) {
        for(ShapeType shType : values()) {
            if (shType.getType() == typeId) {
                return shType;
            }
        }
        throw new IllegalArgumentException("There is no shape type with ID [" + typeId + "]");
    }
}
