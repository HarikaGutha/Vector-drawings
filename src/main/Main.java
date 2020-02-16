package main;

import delegate.GUIDelegate;
import model.Model;

/**
 * Main class.
 */
public class Main {
    /**
     * main method.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Model model = new Model();
        GUIDelegate guiDelegate = new GUIDelegate(model);
    }
}
