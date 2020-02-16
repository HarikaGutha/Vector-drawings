package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import delegate.shape.Shape;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;

public class ModelTest {
    private Model model;
    private static LinkedList<Shape> shapes;
    private static LinkedList<Shape> removedShapes;

    @Before
    public void setUp() throws Exception {
        model =new Model();
    }

    @Test
    public void setShapeType() {
        model.setShapeType(ShapeType.LINE);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.LINE, model.getShapeType());
        assertNotEquals(ShapeType.ELLIPSE, model.getShapeType());

        model.setShapeType(ShapeType.RECTANGLE);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.RECTANGLE, model.getShapeType());
        assertNotEquals(ShapeType.ELLIPSE, model.getShapeType());

        model.setShapeType(ShapeType.TRIANGLE);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.TRIANGLE, model.getShapeType());
        assertNotEquals(ShapeType.ELLIPSE, model.getShapeType());

        model.setShapeType(ShapeType.ELLIPSE);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.ELLIPSE, model.getShapeType());
        assertNotEquals(ShapeType.TRIANGLE, model.getShapeType());

        model.setShapeType(ShapeType.PARALLELOGRAM);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.PARALLELOGRAM, model.getShapeType());
        assertNotEquals(ShapeType.ELLIPSE, model.getShapeType());

        model.setShapeType(ShapeType.HEXAGON);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.HEXAGON, model.getShapeType());
        assertNotEquals(ShapeType.ELLIPSE, model.getShapeType());
    }

    @Test
    public void getShapeType() {
        model.setShapeType(ShapeType.LINE);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.LINE, model.getShapeType());

        model.setShapeType(ShapeType.RECTANGLE);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.RECTANGLE, model.getShapeType());

        model.setShapeType(ShapeType.TRIANGLE);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.TRIANGLE, model.getShapeType());

        model.setShapeType(ShapeType.ELLIPSE);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.ELLIPSE, model.getShapeType());

        model.setShapeType(ShapeType.PARALLELOGRAM);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.PARALLELOGRAM, model.getShapeType());

        model.setShapeType(ShapeType.HEXAGON);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.HEXAGON, model.getShapeType());
    }

    @Test
    public void getColor() {
        Color color =new Color(0, 0, 0, 1);
        Color currentColor=model.getColor();
        assertEquals(currentColor,model.getColor());
    }

    @Test
    public void line() {
        model.setShapeType(ShapeType.LINE);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.LINE, model.getShapeType());
        assertNotEquals(ShapeType.ELLIPSE, model.getShapeType());
        assertNotEquals(ShapeType.HEXAGON, model.getShapeType());
        assertNotEquals(ShapeType.RECTANGLE, model.getShapeType());
        assertNotEquals(ShapeType.PARALLELOGRAM, model.getShapeType());
        assertNotEquals(ShapeType.TRIANGLE, model.getShapeType());
    }

    @Test
    public void rectangle() {
        model.setShapeType(ShapeType.RECTANGLE);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.RECTANGLE, model.getShapeType());
        assertNotEquals(ShapeType.ELLIPSE, model.getShapeType());
        assertNotEquals(ShapeType.LINE, model.getShapeType());
        assertNotEquals(ShapeType.PARALLELOGRAM, model.getShapeType());
        assertNotEquals(ShapeType.TRIANGLE, model.getShapeType());
        assertNotEquals(ShapeType.HEXAGON, model.getShapeType());
    }

    @Test
    public void parallelogram() {
        model.setShapeType(ShapeType.PARALLELOGRAM);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.PARALLELOGRAM, model.getShapeType());
        assertNotEquals(ShapeType.ELLIPSE, model.getShapeType());
        assertNotEquals(ShapeType.HEXAGON, model.getShapeType());
        assertNotEquals(ShapeType.RECTANGLE, model.getShapeType());
        assertNotEquals(ShapeType.LINE, model.getShapeType());
        assertNotEquals(ShapeType.TRIANGLE, model.getShapeType());
    }

    @Test
    public void triangle() {
        model.setShapeType(ShapeType.TRIANGLE);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.TRIANGLE, model.getShapeType());
        assertNotEquals(ShapeType.ELLIPSE, model.getShapeType());
        assertNotEquals(ShapeType.HEXAGON, model.getShapeType());
        assertNotEquals(ShapeType.RECTANGLE, model.getShapeType());
        assertNotEquals(ShapeType.LINE, model.getShapeType());
        assertNotEquals(ShapeType.PARALLELOGRAM, model.getShapeType());
    }

    @Test
    public void hexagon() {
        model.setShapeType(ShapeType.HEXAGON);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.HEXAGON, model.getShapeType());
        assertNotEquals(ShapeType.ELLIPSE, model.getShapeType());
        assertNotEquals(ShapeType.RECTANGLE, model.getShapeType());
        assertNotEquals(ShapeType.LINE, model.getShapeType());
        assertNotEquals(ShapeType.PARALLELOGRAM, model.getShapeType());
        assertNotEquals(ShapeType.TRIANGLE, model.getShapeType());
    }

    @Test
    public void ellipse() {
        model.setShapeType(ShapeType.ELLIPSE);
        assertNotNull(model.getShapeType());
        assertEquals(ShapeType.ELLIPSE, model.getShapeType());
        assertNotEquals(ShapeType.TRIANGLE, model.getShapeType());
        assertNotEquals(ShapeType.HEXAGON, model.getShapeType());
        assertNotEquals(ShapeType.RECTANGLE, model.getShapeType());
        assertNotEquals(ShapeType.LINE, model.getShapeType());
        assertNotEquals(ShapeType.PARALLELOGRAM, model.getShapeType());
    }

    @Test
    public void clear() {
        model.clear();
        assertNull(shapes);
        assertNull(removedShapes);
    }

}