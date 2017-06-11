import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TitlesFrame
  extends JFrame
{
  public TitlesFrame()
  {
    initUI();
  }
  
  private void initUI()
  {
    setTitle("Кривые фигуры");
    setDefaultCloseOperation(3);
    add(new TitlesPanel(51));
    setSize(350, 350);
    setLocationRelativeTo(null);
  }

    /**
     * Starts the application
     * @param args Standard array of String parameters. It's not used in this method.
     */
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        TitlesFrame ps = new TitlesFrame();
        ps.setVisible(true);
      }
    });
  }
}
