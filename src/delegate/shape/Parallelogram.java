package delegate.shape;

import java.awt.*;
import java.io.Serializable;

/**
 * class to draw parallelogram.
 */

public class Parallelogram extends Shape implements Serializable {
    /**
     * constructor.
     *
     * @param x1    the coordinate point
     * @param y1    the coordinate point
     * @param x2    the coordinate point
     * @param y2    the coordinate point
     * @param x3    the coordinate point
     * @param y3    the coordinate point
     * @param x4    the coordinate point
     * @param y4    the coordinate point
     * @param color current color
     * @param flag  chech box value
     */

    public Parallelogram(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, Color color, boolean flag) {
        super(x1, y1, x2, y2, x3, y3, x4, y4, color, flag);
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
            g2.fillPolygon(p);
        } else {
            g2.drawPolygon(p);
        }
    }

    /**
     * setter method.
     *
     * @param x1 the coordinate point
     */
    @Override
    public void setX1(int x1) {
        x[0] = x1;
    }

    /**
     * setter method.
     *
     * @param x2 the coordinate point
     */
    @Override
    public void setX2(int x2) {
        x[1] = x2;
    }

    /**
     * setter method.
     *
     * @param x3 the coordinate point
     */
    @Override
    public void setX3(int x3) {
        x[2] = x3;
    }

    /**
     * setter method.
     *
     * @param x4 the coordinate point
     */
    @Override
    public void setX4(int x4) {
        x[3] = x4;
    }

    /**
     * setter method.
     *
     * @param y1 the coordinate point
     */
    @Override
    public void setY1(int y1) {
        y[0] = y1;
    }

    /**
     * setter method.
     *
     * @param y2 the coordinate point
     */
    @Override
    public void setY2(int y2) {
        y[1] = y2;
    }

    /**
     * setter method.
     *
     * @param y3 the coordinate point
     */
    @Override
    public void setY3(int y3) {
        y[2] = y3;
    }

    /**
     * setter method.
     *
     * @param y4 the coordinate point
     */
    @Override
    public void setY4(int y4) {
        y[3] = y4;
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    @Override
    public int getX1() {
        return x[0];
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    @Override
    public int getX2() {
        return x[1];
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    @Override
    public int getX3() {
        return x[2];
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    @Override
    public int getX4() {
        return x[3];
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    @Override
    public int getY1() {
        return y[0];
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    @Override
    public int getY2() {
        return y[1];
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    @Override
    public int getY3() {
        return y[2];
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    @Override
    public int getY4() {
        return y[3];
    }
}
