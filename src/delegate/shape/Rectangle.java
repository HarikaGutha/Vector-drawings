package delegate.shape;

import java.awt.*;
import java.io.Serializable;

public class Rectangle extends Shape implements Serializable {
    /**
     * constructor.
     *
     * @param x1    the coordinates
     * @param y1    the coordinates
     * @param x2    width
     * @param y2    height
     * @param color current color
     * @param flag  checkbox value
     */
    public Rectangle(int x1, int y1, int x2, int y2, Color color, boolean flag) {
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
        if (flag == true) {
            g.fillRect(x1, y1, x2, y2);
        } else {
            g.drawRect(x1, y1, x2, y2);
        }
    }
}
