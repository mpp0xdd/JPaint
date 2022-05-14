import javax.swing.JFrame;


public class JPaint extends JFrame {

  private static final int CANVAS_WIDTH  = 640;
  private static final int CANVAS_HEIGHT = 480;

  private JPaint() {
    super("JPaint");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    JCanvas canvas = new JCanvas(CANVAS_WIDTH, CANVAS_HEIGHT);
    add(canvas);

    pack();
    setVisible(true);
  }

  public static void main(String[] args) {
    new JPaint();
  }
}
