package delegate;

import delegate.shape.Shape;
import model.Model;
import delegate.ApplicationPanel;

import javax.swing.*;
import java.io.*;
import java.util.LinkedList;

/**
 * class to save and load a file.
 */
public class SaveAndLoad {
    private JFileChooser fileChooser;
    private File file;

    /**
     * load method to load the file.
     *
     * @param applicationPanel the drawing panel.
     */
    public void load(ApplicationPanel applicationPanel,Model model) {
        //referenced from https://docs.oracle.com/javase/7/docs/api/javax/swing/JFileChooser.html.
        fileChooser = new JFileChooser();
        int value = fileChooser.showOpenDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            //reference ends.
            file = fileChooser.getSelectedFile();
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                LinkedList<Shape> filedata = (LinkedList<Shape>) in.readObject();
                model.setShapes(filedata);
               // applicationPanel.repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * method to save the file.
     *
     * @param shapes the linkedlist
     */
    public void save(LinkedList<Shape> shapes) {
        //referenced from https://docs.oracle.com/javase/7/docs/api/javax/swing/JFileChooser.html.
        fileChooser = new JFileChooser();
        int value = fileChooser.showSaveDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            //reference ends.
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(shapes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
