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
    add(new TitlesPanel(78));
    setSize(350, 350);
    setLocationRelativeTo(null);
  }
  
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
