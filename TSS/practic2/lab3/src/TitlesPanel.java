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

public class TitlesPanel
  extends JPanel
  implements ActionListener
{
  private Graphics2D g2d;
  private Timer animation;
  private boolean is_done;
  private int start_angle = 0;
  private int shape;
  
  public TitlesPanel(int _shape)
  {
    this.is_done = true;
    this.shape = _shape;
    this.animation = new Timer(50, this);
    this.animation.setInitialDelay(50);
    this.animation.start();
  }

    /**
     * Invoked when an action occurs and repaints object
     * @param arg0 Event that describes the occurred action
     */
  public void actionPerformed(ActionEvent arg0)
  {
    if (this.is_done) {
      repaint();
    }
  }
  
  private void doDrawing(Graphics g)
  {
    this.is_done = false;
    this.g2d = ((Graphics2D)g);
    this.g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
      RenderingHints.VALUE_ANTIALIAS_ON);
    
    Dimension size = getSize();
    Insets insets = getInsets();
    
    int w = size.width - insets.left - insets.right;
    int h = size.height - insets.top - insets.bottom;
    
    ShapeFactory shape = new ShapeFactory(this.shape);
    this.g2d.setStroke(shape.stroke);
    this.g2d.setPaint(shape.paint);
    double angle = this.start_angle++;
    if (this.start_angle > 360) {
      this.start_angle = 0;
    }
    double dr = 90.0D / (w / (shape.width * 1.5D));
    for (int j = shape.height; j < h; j = (int)(j + shape.height * 1.5D)) {
      for (int i = shape.width; i < w; i = (int)(i + shape.width * 1.5D))
      {
        angle = angle > 360.0D ? 0.0D : angle + dr;
        AffineTransform transform = new AffineTransform();
        transform.translate(i, j);
        transform.rotate(Math.toRadians(angle));
        this.g2d.draw(transform.createTransformedShape(shape.shape));
      }
    }
    this.is_done = true;
  }

    /**
     * Overrides parent JPanel method to perform custom drawing logic
     * @param g The original Graphics object
     */
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    doDrawing(g);
  }
}
