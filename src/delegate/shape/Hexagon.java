package delegate.shape;

import java.awt.*;
import java.io.Serializable;

/**
 * class to draw hexagon.
 */

public class Hexagon extends Shape implements Serializable {
    /**
     * constructor.
     *
     * @param x1    the coordinate point.
     * @param y1    the coordinate point
     * @param x2    the coordinate point
     * @param y2    the coordinate point
     * @param x3    the coordinate point
     * @param y3    the coordinate point
     * @param x4    the coordinate point
     * @param y4    the coordinate point
     * @param x5    the coordinate point
     * @param y5    the coordinate point
     * @param x6    the coordinate point
     * @param y6    the coordinate point
     * @param color current color
     * @param flag  check box value
     */

    public Hexagon(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6, int y6, Color color, boolean flag) {
        super(x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6, color, flag);
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
     * @param x5 the coordinate point
     */
    @Override
    public void setX5(int x5) {
        x[4] = x5;
    }

    /**
     * setter method.
     *
     * @param x6 the coordinate point
     */
    @Override
    public void setX6(int x6) {
        x[5] = x6;
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
     * setter method.
     *
     * @param y5 the coordinate point
     */
    @Override
    public void setY5(int y5) {
        y[4] = y5;
    }

    /**
     * setter method.
     *
     * @param y6 the coordinate point
     */
    @Override
    public void setY6(int y6) {
        y[5] = y6;
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
    public int getX5() {
        return x[4];
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    @Override
    public int getX6() {
        return x[5];
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

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    @Override
    public int getY5() {
        return y[4];
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    @Override
    public int getY6() {
        return y[5];
    }
}
