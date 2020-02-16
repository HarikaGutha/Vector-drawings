package delegate.shape;

import java.awt.geom.Ellipse2D;
import java.awt.*;
import java.io.Serializable;

/**
 * class to draw ellipse.
 */
public class Ellipse extends Shape implements Serializable {
    /**
     * constructor.
     *
     * @param x1    the coordinate point
     * @param y1    the coordinate point
     * @param x2    width
     * @param y2    height
     * @param color current color
     * @param flag  checkbox value
     */

    public Ellipse(int x1, int y1, int x2, int y2, Color color, boolean flag) {
        super(x1, y1, x2, y2, color, flag);
    }

    /**
     * overriding draw() method in shape.
     *
     * @param g the graphics object
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        Graphics2D g2 = (Graphics2D) g;
        if (flag == true) {
            g2.fill(new Ellipse2D.Double(x1, y1, x2, y2));
        } else {
            g2.draw(new Ellipse2D.Double(x1, y1, x2, y2));
        }
    }
}
