import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class represents a panel element for displaying shapes animation
 */
public class TitlesPanel extends JPanel implements ActionListener {

    private boolean isDone = true;
    private int startAngle = 0;
    private ShapeFactory shapeFactory;

    /**
     * Constructs application panel using integer value which represents shape type.
     * During object building the ShapeFactory will be created according to the chosen shape type.
     * After that the animation will be run.
     * @param shapeTypeId The integer value which represents shape type
     */
    public TitlesPanel(int shapeTypeId) {
        this.shapeFactory = getShapeFactory(shapeTypeId);
        startAnimation();
    }

    /**
     * Constructs application panel using ShapeType enum value which represents shape type.
     * During object building the ShapeFactory will be created according to the chosen shape type.
     * After that the animation will be run.
     * @param shapeType The integer value which represents shape type
     */
    public TitlesPanel(ShapeType shapeType) {
        this.shapeFactory = getShapeFactory(shapeType);
        startAnimation();
    }

    /**
     * Runs the shape animation
     */
    private void startAnimation() {
        Timer animation = new Timer(50, this);
        animation.setInitialDelay(50);
        animation.start();
    }

    /**
     * Creates ShapeFactory object by integer value which represents shape type
     * @param shapeTypeId The integer value which represents shape type
     * @return ShapeFactory object
     */
    private ShapeFactory getShapeFactory(int shapeTypeId) {
        return new ShapeFactory(shapeTypeId);
    }

    /**
     * Creates ShapeFactory object by integer value which represents shape type
     * @param shapeType The ShapeType enum value which represents shape type
     * @return ShapeFactory object
     */
    private ShapeFactory getShapeFactory(ShapeType shapeType) {
        return new ShapeFactory(shapeType);
    }

    /**
     * Invoked when an action occurs and repaints object
     * @param event Event that describes the occurred action
     */
    public void actionPerformed(ActionEvent event) {
        if (isDone) {
            repaint();
        }
    }

    private void doDrawing(Graphics g) {
        isDone = false;
        Graphics2D g2d = ((Graphics2D) g);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Dimension size = getSize();
        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;

        g2d.setStroke(shapeFactory.getStroke());
        g2d.setPaint(shapeFactory.getPaint());
        double angle = startAngle++;
        if (startAngle > 360) {
            startAngle = 0;
        }
        double dr = 90.0D / (w / (shapeFactory.getWidth() * 1.5D));
        for (int j = shapeFactory.getHeight(); j < h; j = (int) (j + shapeFactory.getHeight() * 1.5D)) {
            for (int i = shapeFactory.getWidth(); i < w; i = (int) (i + shapeFactory.getWidth() * 1.5D)) {
                angle = angle > 360.0D ? 0.0D : angle + dr;
                AffineTransform transform = new AffineTransform();
                transform.translate(i, j);
                transform.rotate(Math.toRadians(angle));
                g2d.draw(transform.createTransformedShape(shapeFactory.getShape()));
            }
        }
        isDone = true;
    }

    /**
     * Overrides parent JPanel method to perform custom drawing logic
     * @param g The original Graphics object
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
