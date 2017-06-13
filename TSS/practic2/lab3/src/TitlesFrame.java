import javax.swing.*;

/**
 * Class represents frame element which contains child elements for displaying shapes animation
 */
public class TitlesFrame extends JFrame {

    /**
     * Builds and initializes application frame
     */
    public TitlesFrame() {
        initUI();
    }

    private void initUI() {
        setTitle("Кривые фигуры");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new TitlesPanel(ShapeType.STAR_SMALL_COLOR_GRADIENT));
//        add(new TitlesPanel(51));
        setSize(350, 350);
        setLocationRelativeTo(null);
    }

    /**
     * Starts the application
     * @param args Standard array of String parameters. It's not used in this method.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TitlesFrame ps = new TitlesFrame();
                ps.setVisible(true);
            }
        });
    }
}
