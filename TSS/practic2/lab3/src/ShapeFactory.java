import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Class represents an entity for creation of different shapes with specific form and style
 */
public class ShapeFactory {

    private Shape shape;
    private BasicStroke stroke;
    private Paint paint;
    private int width = 25;
    private int height = 25;

    /**
     * Constructs a ShapeFactory object using integer value which will be converted into specific shape form and style
     * @param shapeTypeId Initial integer value which will be used for shape generation
     */
    public ShapeFactory(int shapeTypeId) {
        this(ShapeType.getShapeTypeById(shapeTypeId));
    }

    /**
     * Constructs a ShapeFactory object by specified shape type which contains shape form and style
     * @param shapeType Initial enum value which represent a shape with some parameters
     */
    public ShapeFactory(ShapeType shapeType) {
        this(shapeType.getForm(), shapeType.getStyle());
    }

    /**
     * Constructs from from specified form and style parameters
     * @param form - Enum value of shape's form
     * @param style - Enum value of shape's style
     */
    public ShapeFactory(ShapeForm form, ShapeStyle style) {
        stroke = new BasicStroke(3.0F);
        switch (form) {
            case STAR_BIG:
                shape = createStar(3, new Point(0, 0), width / 2.0D, width / 2.0D);
                break;
            case STAR_SMALL:
                shape = createStar(5, new Point(0, 0), width / 2.0D, width / 4.0D);
                break;
            case RECTANGLE:
                shape = new Rectangle2D.Double(-width / 2.0D, -height / 2.0D, width, height);
                break;
            case PATH:
                GeneralPath path = new GeneralPath();
                double tmp_height = Math.sqrt(2.0D) / 2.0D * height;
                path.moveTo(-width / 2, -tmp_height);
                path.lineTo(0.0D, -tmp_height);
                path.lineTo(width / 2, tmp_height);
                path.closePath();
                shape = path;
                break;
            case ARC:
                shape = new Arc2D.Double(-width / 2.0D, -height / 2.0D, width, height, 30.0D, 300.0D, Arc2D.PIE);
                break;
            default:
                throw new IllegalArgumentException("Shape form '" + form + "' is unsupported");
        }

        switch (style) {
            case WIDTH_THIN:
                stroke = new BasicStroke(3.0F);
                break;
            case DEFAULT:
                break;
            case WIDTH_THICK:
                stroke = new BasicStroke(7.0F);
                break;
            case COLOR_GRADIENT:
                paint = new GradientPaint(
                        -width, -height, Color.white,
                        width, height, Color.gray, true);
                break;
            case COLOR_RED:
                paint = Color.red;
                break;
            default:
                throw new IllegalArgumentException("Shape style '" + style + "' is unsupported");
        }
    }

    /**
     * Creates star shape
     * @param arms   - count of arm of the star
     * @param center - center coordinates
     * @param rOuter - outer radius
     * @param rInner - inner radius
     * @return Shape object
     */
    private static Shape createStar(int arms, Point center, double rOuter, double rInner) {

        double angle = Math.PI / arms;
        GeneralPath path = new GeneralPath();
        for (int i = 0; i < 2 * arms; i++) {
            double r = (i & 0x1) == 0 ? rOuter : rInner;
            Point2D.Double p = new Point2D.Double(center.x + Math.cos(i * angle) * r, center.y + Math.sin(i * angle) * r);
            if (i == 0) {
                path.moveTo(p.getX(), p.getY());
            } else {
                path.lineTo(p.getX(), p.getY());
            }
        }
        path.closePath();
        return path;
    }

    /**
     * Returns current shape
     * @return Shape object
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * Sets current shape
     * @param shape Current shape object
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * Returns stroke for the current shape
     * @return Stroke for the current shape
     */
    public BasicStroke getStroke() {
        return stroke;
    }

    /**
     * Sets stroke for the current shape
     * @param stroke
     */
    public void setStroke(BasicStroke stroke) {
        this.stroke = stroke;
    }

    /**
     * Returns Paint object which contains color characteristics for current shape
     * @return Paint object with color characteristics for current shape
     */
    public Paint getPaint() {
        return paint;
    }

    /**
     * Sets Paint object which contains color characteristics
     * @param paint Paint object with color characteristics for current shape
     */
    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    /**
     * Return the width of the application window
     * @return Current width of the application window
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of the application window
     * @param width Width of the application window
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Return the height of the application window
     * @return Current height of the application window
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of the application window
     * @param height Height of the application window
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
