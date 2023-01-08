import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Paintbrush {
  private Color color = Color.BLACK;
  private BasicStroke basicStroke = new BasicStroke(5f);

  public void drawLine(Graphics2D g2, float x1, float y1, float x2, float y2) {
    g2.setColor(color);
    g2.setStroke(basicStroke);
    g2.draw(new Line2D.Float(x1, y1, x2, y2));
  }
}
