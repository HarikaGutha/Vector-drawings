package delegate;

import delegate.shape.Rectangle;
import delegate.shape.Shape;
import delegate.shape.*;
import model.Model;

import javax.swing.JPanel;
import javax.swing.JColorChooser;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class ApplicationPanel extends JPanel {

    private static Color currentColor;
    private Shape drawShape;
    private boolean flag;
    private Model model;

    /**
     * constructor.
     *
     * @param model model object
     */
    public ApplicationPanel(Model model) {
        this.model = model;
        flag = false;
    }

    /**
     * methods to set up application panel.
     */
    public void setUpApplicationPanel() {
        setBackground(Color.WHITE);
        MouseMotionListenerForApplicationPanel mouseMotionListenerForApplicationPanel = new MouseMotionListenerForApplicationPanel();
        addMouseListener(mouseMotionListenerForApplicationPanel);
        addMouseMotionListener(mouseMotionListenerForApplicationPanel);
    }

    /**
     * overriding paintComponent(-).
     *
     * @param g the graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * method to display color choosing pallet.
     */
    public void color() {
        currentColor = JColorChooser.showDialog(this, "select a color", model.getColor());
    }

    /**
     * method is check box is selected.
     */

    public void controlSolidFill() {
        flag = true;
    }

    /**
     * method if checkbox is not selected.
     */

    public void controlUncheckedDraw() {
        flag = false;
    }

    class MouseMotionListenerForApplicationPanel extends MouseAdapter implements MouseMotionListener {
        /**
         * overriding mousePressed.
         *
         * @param e the MouseEvent
         */
        @Override
        public void mousePressed(MouseEvent e) {
            switch (model.getShapeType()) {
                case LINE:
                    drawShape = new Line(e.getX(), e.getY(), e.getX(), e.getY(), currentColor);
                    break;
                case RECTANGLE:
                    drawShape = new Rectangle(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, flag);
                    break;
                case TRIANGLE:
                    drawShape = new Triangle(e.getX(), e.getY(), e.getX(), e.getY(), e.getX(), e.getY(), currentColor, flag);
                    break;
                case PARALLELOGRAM:
                    drawShape = new Parallelogram(e.getX(), e.getY(), e.getX(), e.getY(), e.getX(), e.getY(), e.getX(), e.getY(), currentColor, flag);
                    break;
                case ELLIPSE:
                    drawShape = new Ellipse(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, flag);
                    break;
                case HEXAGON:
                    drawShape = new Hexagon(e.getX(), e.getY(), e.getX(), e.getY(), e.getX(), e.getY(), e.getX(), e.getY(), e.getX(), e.getY(), e.getX(), e.getY(), currentColor, flag);
                    break;
                default:
                    break;
            }
        }

        /**
         * overriding mouseReleased.s
         *
         * @param e the MouseEvent
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            if (!(drawShape == null)) {
                switch (model.getShapeType()) {
                    case LINE:
                        logicForLine(e);
                        model.line(drawShape);
                        break;
                    case ELLIPSE:
                        logicForRectangleAndEllipse(e);
                        model.ellipse(drawShape);
                        break;
                    case RECTANGLE:
                        logicForRectangleAndEllipse(e);
                        model.rectangle(drawShape);
                        break;
                    case TRIANGLE:
                        logicForTriangle(e);
                        model.triangle(drawShape);
                        break;
                    case PARALLELOGRAM:
                        logicForParallelogram(e);
                        model.parallelogram(drawShape);
                        break;
                    case HEXAGON:
                        logicForHexagon(e);
                        model.hexagon(drawShape);
                        break;
                }
                drawShape = null;
            }
        }

        /**
         * overriding moudeDragged.
         *
         * @param e the MouseEvent
         */
        @Override
        public void mouseDragged(MouseEvent e) {
            if (drawShape != null) {
                switch (model.getShapeType()) {
                    case LINE:
                        logicForLine(e);
                        break;
                    case ELLIPSE:
                    case RECTANGLE:
                        logicForRectangleAndEllipse(e);
                        break;
                    case TRIANGLE:
                        logicForTriangle(e);
                        break;
                    case PARALLELOGRAM:
                        logicForParallelogram(e);
                        break;
                    case HEXAGON:
                        logicForHexagon(e);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * method to capture coordinates of mouse released and dragged for line.
     *
     * @param e the MouseEvent
     */
    public void logicForLine(MouseEvent e) {
        drawShape.setX2(e.getX());
        drawShape.setY2(e.getY());
    }

    /**
     * method to capture coordinates of mouse released and dragged for rectangle and ellipse.
     *
     * @param e the MouseEvent
     */
    public void logicForRectangleAndEllipse(MouseEvent e) {
        if (drawShape.getX1() >= e.getX() && drawShape.getY1() <= e.getY()) {
            drawShape.setX2(drawShape.getX1() - e.getX());
            drawShape.setY2(drawShape.getY1() - e.getY());
        } else {
            drawShape.setX2(e.getX() - drawShape.getX1());
            drawShape.setY2(e.getY() - drawShape.getY1());
        }
    }

    /**
     * method to capture coordinates of mouse released and dragged for triangle.
     *
     * @param e the MouseEvent
     */
    public void logicForTriangle(MouseEvent e) {
        drawShape.setX2(e.getX());
        drawShape.setY2(e.getY());
        drawShape.setX3(drawShape.getX1() - (e.getX() - drawShape.getX2()));
        drawShape.setY3(e.getY());
    }

    /**
     * method to capture coordinates of mouse released and dragged for parallelogram.
     *
     * @param e the MouseEvent
     */
    public void logicForParallelogram(MouseEvent e) {
        drawShape.setX2(e.getX());
        drawShape.setY2(drawShape.getY1());
        drawShape.setX3(drawShape.getX2() + (e.getX() - drawShape.getX1()));
        drawShape.setY3(e.getY());
        drawShape.setX4(e.getX());
        drawShape.setY4(e.getY());
    }

    /**
     * method to capture coordinates of mouse released and dragged for hexagon.
     *
     * @param e the MouseEvent
     */
    public void logicForHexagon(MouseEvent e) {
        drawShape.setX2((drawShape.getX1() + e.getX()) / 2);
        drawShape.setY2(drawShape.getY1());
        drawShape.setX3(e.getX());
        drawShape.setY3(drawShape.getY1() + (drawShape.getY5() - drawShape.getY1()) / 2);
        drawShape.setX4(drawShape.getX2());
        drawShape.setY4(e.getY());
        drawShape.setX5(drawShape.getX1());
        drawShape.setY5(drawShape.getY4());
        drawShape.setX6(drawShape.getX1() - (drawShape.getX2() - drawShape.getX1()));
        drawShape.setY6(drawShape.getY3());
    }

}
