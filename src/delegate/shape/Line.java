package delegate.shape;

import java.awt.*;
import java.awt.geom.Line2D;
import java.io.Serializable;

/**
 * class to draw line.
 */

public class Line extends Shape implements Serializable {

    /**
     * constructor.
     *
     * @param x1    the coordinate point
     * @param y1    the coordinate point
     * @param x2    the coordinate point
     * @param y2    the coordinate point
     * @param color current color
     */
    public Line(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
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
        g2.draw(new Line2D.Double(x1, y1, x2, y2));
    }
}
