package delegate.shape;

import java.awt.*;
import java.awt.geom.Path2D;
import java.io.Serializable;


/**
 * abstract class shape.
 */

public abstract class Shape implements Serializable {
    //protected VectorView view;
    protected int x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6;
    protected Color color;
    protected Color fillColor;
    protected int[] x;
    protected int[] y;
    protected Polygon p;
    protected boolean flag;

    /**
     * constructor.
     *
     * @param x1    the coordinate point
     * @param y1    the coordinate point
     * @param x2    the coordinate point
     * @param y2    the coordinate point
     * @param color current  color
     */
    public Shape(int x1, int y1, int x2, int y2, Color color) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setColor(color);
    }

    /**
     * constructor.
     *
     * @param x1    the coordinate point
     * @param y1    the coordinate point
     * @param x2    the coordinate point
     * @param y2    the coordinate point
     * @param x3    the coordinate point
     * @param y3    the coordinate point
     * @param color current color
     * @param flag  check box value
     */
    public Shape(int x1, int y1, int x2, int y2, int x3, int y3, Color color, boolean flag) {
        this.flag = flag;
        x = new int[]{x1, x2, x3};
        y = new int[]{y1, y2, y3};
        p = new Polygon();
        p.xpoints = x;
        p.ypoints = y;
        p.npoints = x.length;
        setColor(color);
    }

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
     * @param flag  check box value
     */
    public Shape(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, Color color, boolean flag) {
        this.flag = flag;
        x = new int[]{x1, x2, x3, x4};
        y = new int[]{y1, y2, y3, y4};
        p = new Polygon();
        p.xpoints = x;
        p.ypoints = y;
        p.npoints = x.length;
        setColor(color);
    }

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
     * @param x5    the coordinate point
     * @param y5    the coordinate point
     * @param x6    the coordinate point
     * @param y6    the coordinate point
     * @param color current color
     * @param flag  check box value
     */
    public Shape(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6, int y6, Color color, boolean flag) {
        this.flag = flag;
        x = new int[]{x1, x2, x3, x4, x5, x6};
        y = new int[]{y1, y2, y3, y4, y5, y6};
        p = new Polygon();
        p.xpoints = x;
        p.ypoints = y;
        p.npoints = x.length;
        setColor(color);
    }

    /**
     * constructor.
     *
     * @param x1    the coordinate point
     * @param y1    the coordinate point
     * @param x2    the coordinate point
     * @param y2    the coordinate point
     * @param color current color
     * @param flag  check box value
     */
    public Shape(int x1, int y1, int x2, int y2, Color color, boolean flag) {
        this.flag = flag;
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setColor(color);
    }

    /**
     * abstract method.
     *
     * @param g the graphics object
     */
    public abstract void draw(Graphics g);


    /**
     * setter method.
     *
     * @param x1 the coordinate point
     */

    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * setter method.
     *
     * @param x2 the coordinate point
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * setter method.
     *
     * @param x3 the coordinate point
     */
    public void setX3(int x3) {
        this.x3 = x3;
    }

    /**
     * setter method.
     *
     * @param x4 the coordinate point
     */
    public void setX4(int x4) {
        this.x4 = x4;
    }

    /**
     * setter method.
     *
     * @param x5 the coordinate point
     */
    public void setX5(int x5) {
        this.x5 = x5;
    }

    /**
     * setter method.
     *
     * @param x6 the coordinate point
     */
    public void setX6(int x6) {
        this.x6 = x6;
    }

    /**
     * setter method.
     *
     * @param y1 the coordinate point
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * setter method.
     *
     * @param y2 the coordinate point
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * setter method.
     *
     * @param y3 the coordinate point
     */
    public void setY3(int y3) {
        this.y3 = y3;
    }

    /**
     * setter method.
     *
     * @param y4 the coordinate point
     */
    public void setY4(int y4) {
        this.y4 = y4;
    }

    /**
     * setter method.
     *
     * @param y5 the coordinate point
     */
    public void setY5(int y5) {
        this.y5 = y5;
    }

    /**
     * setter method.
     *
     * @param y6 the coordinate point
     */
    public void setY6(int y6) {
        this.y6 = y6;
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    public int getX1() {
        return x1;
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */

    public int getX2() {
        return x2;
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */

    public int getX3() {
        return x3;
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    public int getX4() {
        return x4;
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    public int getX5() {
        return x5;
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    public int getX6() {
        return x6;
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    public int getY1() {
        return y1;
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    public int getY2() {
        return y2;
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    public int getY3() {
        return y3;
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    public int getY4() {
        return y4;
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    public int getY5() {
        return y5;
    }

    /**
     * getter method.
     *
     * @return the cordinate point.
     */
    public int getY6() {
        return y6;
    }

    /**
     * getter method.
     *
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * setter method.
     *
     * @param color color object.
     */
    public void setColor(Color color) {
        this.color = color;
    }

}
