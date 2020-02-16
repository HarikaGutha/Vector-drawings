package model;

import delegate.ApplicationPanel;
import delegate.SaveAndLoad;
import delegate.shape.Shape;

import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;

public class Model {
    private static Color currentColor;
    private static ShapeType shapeType;
    private static LinkedList<Shape> shapes;
    private static LinkedList<Shape> removedShapes;
    private SaveAndLoad sl;
    private String old = null;
    /**
     * the change support object to help us fire change events at observers
     *
     * taken from studres examples
     */
    private PropertyChangeSupport notifier;

    /**
     * Constructs a new Model instance.
     * Initialises the property change support.
     */
    public Model() {
        currentColor = Color.black;
        shapes = new LinkedList<Shape>();
        removedShapes = new LinkedList<Shape>();
        notifier = new PropertyChangeSupport(this);
    }

    /**
     * getter method for shapes.
     *
     * @return shapes
     */

    public LinkedList<Shape> getShapes() {
        return shapes;
    }
    /**
     * setter method for shapes.
     *
     * @param shapes the linked list
     */

    public void setShapes(LinkedList<Shape> shapes) {
        Model.shapes = shapes;
        notifier.firePropertyChange("theText", old, "trigger");
    }

    /**
     * Utility method to permit an observer to add themselves as an observer to the model's change support object.
     *
     * @param listener the listener to add
     *                 referenced from studres examples
     */
    public void addObserver(PropertyChangeListener listener) {
        notifier.addPropertyChangeListener(listener);
    }

    /**
     * method that sets shapeType.
     *
     * @param type the current shape
     */
    public void setShapeType(ShapeType type) {
        shapeType = type;
    }

    /**
     * method to get color.
     *
     * @return the current color
     */
    public ShapeType getShapeType() {
        return shapeType;
    }

    /**
     * method to get color
     *
     * @return current color
     */
    public Color getColor() {
        return currentColor;
    }

    /**
     * method to draw line.
     *
     * @param line current shape
     */

    public void line(Shape line) {
        setShapeType(ShapeType.LINE);
        shapes.add(line);
        notifier.firePropertyChange("theText", old, "trigger");
    }

    /**
     * method to draw rectangle.
     *
     * @param rectangle current shape
     */

    public void rectangle(Shape rectangle) {
        setShapeType(ShapeType.RECTANGLE);
        shapes.add(rectangle);
        notifier.firePropertyChange("theText", old, "trigger");
    }

    /**
     * method to draw parallelogarm.
     *
     * @param parallelogram current shape
     */
    public void parallelogram(Shape parallelogram) {
        setShapeType(ShapeType.PARALLELOGRAM);
        shapes.add(parallelogram);
        notifier.firePropertyChange("theText", old, "trigger");
    }

    /**
     * method to draw triangle.
     *
     * @param triangle current shape
     */

    public void triangle(Shape triangle) {
        setShapeType(ShapeType.TRIANGLE);
        shapes.add(triangle);
        notifier.firePropertyChange("theText", old, "trigger");
    }

    /**
     * method to draw hexagon.
     *
     * @param hexagon current shape
     */

    public void hexagon(Shape hexagon) {
        setShapeType(ShapeType.HEXAGON);
        shapes.add(hexagon);
        notifier.firePropertyChange("theText", old, "trigger");
    }

    /**
     * method to draw ellipse.
     *
     * @param ellipse current shape
     */

    public void ellipse(Shape ellipse) {
        setShapeType(ShapeType.ELLIPSE);
        shapes.add(ellipse);
        notifier.firePropertyChange("theText", old, "trigger");
    }

    /**
     * method to undo shapes.
     */
    public void undo() {
        if (!shapes.isEmpty()) {
            removedShapes.addFirst(shapes.removeLast());
            notifier.firePropertyChange("theText", old, "trigger");
        }
    }

    /**
     * method to redo shapes.
     */
    public void redo() {
        if (!removedShapes.isEmpty()) {
            shapes.addFirst(removedShapes.removeFirst());
            notifier.firePropertyChange("theText", old, "trigger");
        }
    }

    /**
     * method to clear shapes.
     */
    public void clear() {
        shapes.clear();
        removedShapes.clear();
        notifier.firePropertyChange("theText", old, "trigger");
    }

    /**
     * method to load file.
     *
     * @param applicationPanel applicationpanel object
     */
    public void load(ApplicationPanel applicationPanel) {
        sl = new SaveAndLoad();
        sl.load(applicationPanel,this);
    }

    /**
     * method to save file.
     */
    public void save() {
        sl = new SaveAndLoad();
        sl.save(shapes);
    }
}
