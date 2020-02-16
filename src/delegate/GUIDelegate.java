package delegate;

import delegate.shape.Shape;
import model.Model;
import model.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;

/**
 * class GUIDelegate.
 */
public class GUIDelegate extends JFrame implements ActionListener, PropertyChangeListener {
    private static final long serialVersionUID = 1L;
    private static final int FRAME_HEIGHT = 600;
    private static final int FRAME_WIDTH = 800;
    protected static String BUTTON_COLOUR = "Colour";
    protected static String BUTTON_UNDO = "Undo";
    protected static String BUTTON_REDO = "Redo";
    protected static String BUTTON_LINE = "Line";
    protected static String BUTTON_RECTANGLE = "Rectangle";
    protected static String BUTTON_PARALLELOGRAM = "Parallelogram";
    protected static String BUTTON_TRIANGLE = "Triangle";
    protected static String BUTTON_HEXAGON = "Hexagon";
    protected static String BUTTON_ELLIPSE = "Ellipse";
    protected static String BUTTON_CLEAR = "Clear";
    protected static String CHECKBOX_FILLED = "solidFill";
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private JToolBar toolBar;
    private ApplicationPanel applicationPanel;
    private JCheckBox filled;
    private BorderLayout bl;
    private JButton colourButton;
    private JButton undoButton;
    private JButton redoButton;
    private JButton lineButton;
    private JButton rectangleButton;
    private JButton parallelogramButton;
    private JButton triangleButton;
    private JButton hexagonButton;
    private JButton ellipseButton;
    private JButton clearButton;
    private Model model;


    /**
     * parameterized constructor.
     *
     * @param model the IModel reference
     */
    public GUIDelegate(Model model) {
        this.model = model;
        menuBar = new JMenuBar();
        toolBar = new JToolBar();
        applicationPanel = new ApplicationPanel(model);
        drawFrame();
        model.addObserver(this);
        addActionListenerForButtons(this::actionPerformed);
    }

    /**
     * methods to set frame.
     */
    public void drawFrame() {
        setBackground(new Color(39, 174, 96));
        setTitle("My Main Frame");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        addComponents();
        setVisible(true);
    }

    /**
     * method to add components to the frame.
     */
    public void addComponents() {
        setUpMenuBar();
        setUpToolBar();
        applicationPanel.setUpApplicationPanel();
        add(applicationPanel, BorderLayout.CENTER);
    }

    /**
     * methods to set up menubar.
     */
    public void setUpMenuBar() {
        setJMenuBar(menuBar);
        menu = new JMenu("File");
        menuBar.add(menu);
        menuItem = new JMenuItem("Load");
        MenuActionListener menuActionListener = new MenuActionListener();
        menuItem.addActionListener(menuActionListener);
        menu.add(menuItem);
        menuItem = new JMenuItem("Save");
        menu.add(menuItem);
        menuItem.addActionListener(menuActionListener);
    }

    /**
     * method to set up tool bar.
     */
    public void setUpToolBar() {
        add(toolBar, BorderLayout.NORTH);
        filled = new JCheckBox(CHECKBOX_FILLED);
        colourButton = new JButton(BUTTON_COLOUR);
        undoButton = new JButton(BUTTON_UNDO);
        redoButton = new JButton(BUTTON_REDO);
        lineButton = new JButton(BUTTON_LINE);
        rectangleButton = new JButton(BUTTON_RECTANGLE);
        parallelogramButton = new JButton(BUTTON_PARALLELOGRAM);
        triangleButton = new JButton(BUTTON_TRIANGLE);
        hexagonButton = new JButton(BUTTON_HEXAGON);
        ellipseButton = new JButton(BUTTON_ELLIPSE);
        clearButton = new JButton(BUTTON_CLEAR);
        toolBar.add(filled);
        toolBar.add(colourButton);
        toolBar.add(undoButton);
        toolBar.add(redoButton);
        toolBar.add(lineButton);
        toolBar.add(rectangleButton);
        toolBar.add(parallelogramButton);
        toolBar.add(triangleButton);
        toolBar.add(hexagonButton);
        toolBar.add(ellipseButton);
        toolBar.add(clearButton);
        filled.addActionListener(new CheckBoxListener());
    }


    /**
     * adding actionListener for buttons.
     *
     * @param al the ActionListener
     */

    public void addActionListenerForButtons(ActionListener al) {
        colourButton.addActionListener(al);
        undoButton.addActionListener(al);
        redoButton.addActionListener(al);
        lineButton.addActionListener(al);
        rectangleButton.addActionListener(al);
        parallelogramButton.addActionListener(al);
        triangleButton.addActionListener(al);
        hexagonButton.addActionListener(al);
        ellipseButton.addActionListener(al);
        clearButton.addActionListener(al);
    }

    /**
     * overriding actionPerformed.
     *
     * @param e the ActionEvent.
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colourButton) {
            applicationPanel.color();
        } else if (e.getSource() == undoButton) {
            model.undo();
        } else if (e.getSource() == redoButton) {
            model.redo();
        } else if (e.getSource() == lineButton) {
            model.setShapeType(ShapeType.LINE);
        } else if (e.getSource() == rectangleButton) {
            model.setShapeType(ShapeType.RECTANGLE);
        } else if (e.getSource() == parallelogramButton) {
            model.setShapeType(ShapeType.PARALLELOGRAM);
        } else if (e.getSource() == triangleButton) {
            model.setShapeType(ShapeType.TRIANGLE);
        } else if (e.getSource() == hexagonButton) {
            model.setShapeType(ShapeType.HEXAGON);
        } else if (e.getSource() == ellipseButton) {
            model.setShapeType(ShapeType.ELLIPSE);
        } else if (e.getSource() == clearButton) {
            model.clear();
        }
    }

    /**
     * overriding propertyChange() method.
     *
     * @param event the propertyChangeEvent
     */
    @Override
    //referenced from studres examples.
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getSource() == model && event.getPropertyName().equals("theText")) {
            applicationPanel.repaint();
            SwingUtilities.invokeLater(new Runnable() {
                //reference ends
                public void run() {
                    Graphics g = applicationPanel.getGraphics();
                    g.setColor(model.getColor());
                    LinkedList<Shape> shapes = model.getShapes();
                    for (int i = 0; i < shapes.size(); i++) {
                        //polymorphism
                        shapes.get(i).draw(g);
                    }

                }
            });
        }
    }


    /**
     * inner class to handle checkbox events.
     */

    class CheckBoxListener implements ActionListener {
        /**
         * overriding actionPerformed.
         *
         * @param e the ActionEvent
         */

        @Override
        public void actionPerformed(ActionEvent e) {
            if (filled.isSelected()) {
                System.out.println("im checked");
                applicationPanel.controlSolidFill();
            } else {
                applicationPanel.controlUncheckedDraw();
            }
        }
    }

    /**
     * innerclass to handle menubar events.
     */
    class MenuActionListener implements ActionListener {
        /**
         * overriding actionPerformed.
         *
         * @param e the ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Select menu!");
            if (e.getActionCommand().equalsIgnoreCase("Load")) {
                model.load(applicationPanel);
            } else if (e.getActionCommand().equalsIgnoreCase("Save")) {
                model.save();
            }
        }
    }
}
