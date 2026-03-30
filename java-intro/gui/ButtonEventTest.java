import java.awt.*;
import java.awt.event.*;

/**
 * ButtonEventTest class demonstrates handling button click events.
 * It extends AddingComponents and implements ActionListener.
 */
class ButtonEventTest extends AddingComponents
        implements ActionListener {

    // Stores the sum of button clicks
    private int sum;

    // Constructor: sets up the button event listener
    public ButtonEventTest() {
        button.addActionListener(this); // Register this class as listener for button
    }

    // Handles button click events
    public void actionPerformed(ActionEvent ae) {
        sum += 1; // Increment sum on each click
        textField.setText(sum + ""); // Update text field with new sum
        Toolkit.getDefaultToolkit().beep(); // Play beep sound
    }

    // Main method: entry point of the program
    public static void main(String args[]) {
        new ButtonEventTest(); // Create instance to show GUI
    }
}
