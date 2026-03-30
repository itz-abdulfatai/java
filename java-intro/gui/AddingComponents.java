import java.awt.*;
import javax.swing.*;

// Main class extending JFrame to create a window
public class AddingComponents extends JFrame {

    // Create a button with label "Press Me"
    JButton button = new JButton("Press Me");
    // Create a label with text "Running Total:"
    JLabel label = new JLabel("Running Total:");
    // Create a text field with 10 columns
    JTextField textField = new JTextField(10);
    // Get the content pane of the JFrame to add components
    Container cp = getContentPane();

    // Constructor to set up the GUI
    public AddingComponents() {
        // Set the title of the window
        super("A Container With Components");
        // Set the size of the window
        setSize(300, 100);
        // Set the layout manager to FlowLayout
        cp.setLayout(new FlowLayout());
        // Add the label to the content pane
        cp.add(label);
        // Add the text field to the content pane
        cp.add(textField);
        // Add the button to the content pane
        cp.add(button);
        // Make the window visible
        setVisible(true);
    }

    // Main method to run the application
    public static void main(String args[]) {
        new AddingComponents();
    }
}
