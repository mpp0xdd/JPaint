import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.Dimension;


public class JCanvas extends JPanel implements MouseListener, MouseMotionListener {
  private Paintbrush paintbrush = new Paintbrush();
  private boolean isDrawable = false;
  private float x1 = 0f, y1 = 0f;
  private float x2 = 0f, y2 = 0f;

  private Image image = null;

  public JCanvas(int width, int height) {
    Dimension size = new Dimension(width, height);
    setPreferredSize(size);
    setSize(size);

    addMouseListener(this);
    addMouseMotionListener(this);
  }

  @Override
  public void mousePressed(MouseEvent e) {
    x1 = (float)e.getX();
    y1 = (float)e.getY();
    isDrawable = true;

//    System.err.println("mousePressed() is running ...");
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    x2 = (float)e.getX();
    y2 = (float)e.getY();
    repaint();

//    System.err.println("mouseClicked() is running ...");
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    x2 = (float)e.getX();
    y2 = (float)e.getY();
    repaint();

//    System.err.println("mouseDragged() is running ...");
  }

  // Implement MouseListener
  @Override
  public void mouseEntered(MouseEvent e) {}
  @Override
  public void mouseExited(MouseEvent e) {}
  @Override
  public void mouseReleased(MouseEvent e) {}

  // Implement MouseMotionListener
  @Override
  public void mouseMoved(MouseEvent e) {}

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    final int currentWidth = getWidth();
    final int currentHeight = getHeight();

    if(image == null) {
      image = createImage(currentWidth, currentHeight);
    } else if(currentWidth != image.getWidth(this) || currentHeight != image.getHeight(this)) {
      Image newImage = createImage(currentWidth, currentHeight);
      newImage.getGraphics().drawImage(image, 0, 0, this);
      image = newImage;
      isDrawable = false;
    }

    if(isDrawable) {
      paintbrush.drawLine((Graphics2D)image.getGraphics(), x1, y1, x2, y2);
      x1 = x2;
      y1 = y2;
    }
    g.drawImage(image, 0, 0, this);
  }
}
