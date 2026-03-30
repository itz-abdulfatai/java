// Java GUI Event Handling Examples

import javax.swing.*; // Imports Swing components for GUI
import java.awt.*; // Imports AWT classes for layout
import java.awt.event.*; // Imports event classes for handling user actions

public class GUIEventExamples {
    public static void main(String[] args) {
        // Create a new window (JFrame) with a title
        JFrame frame = new JFrame("Event Handling Demo");
        frame.setLayout(new FlowLayout()); // Set layout manager for arranging components

        // Create a button, text field, and label
        JButton btn = new JButton("Click or Hover");
        JTextField textField = new JTextField(20); // Text field with 20 columns
        JLabel keyLabel = new JLabel("Type something...");

        // Add components to the frame
        frame.add(btn);
        frame.add(textField);
        frame.add(keyLabel);

        // Mouse Event: Handles mouse actions on the button
        btn.addMouseListener(new MouseAdapter() {
            // Called when mouse is clicked on the button
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "Mouse Clicked!"); // Show popup
            }

            // Called when mouse enters the button area
            public void mouseEntered(MouseEvent e) {
                btn.setText("Mouse In"); // Change button text
            }

            // Called when mouse exits the button area
            public void mouseExited(MouseEvent e) {
                btn.setText("Click or Hover"); // Reset button text
            }
        });

        // Keyboard Event: Handles key typing in the text field
        textField.addKeyListener(new KeyAdapter() {
            // Called when a key is typed
            public void keyTyped(KeyEvent e) {
                keyLabel.setText("Typed: " + e.getKeyChar()); // Update label with typed character
            }
        });

        // TextField Event: Handles pressing Enter in the text field
        textField.addActionListener(e -> {
            // Show popup with entered text
            JOptionPane.showMessageDialog(frame, "Entered: " + textField.getText());
        });

        // Window Event: Handles window actions
        frame.addWindowListener(new WindowAdapter() {
            // Called when window is closing
            public void windowClosing(WindowEvent e) {
                System.out.println("Window closing..."); // Print message to console
            }

            // Called when window is opened
            public void windowOpened(WindowEvent e) {
                System.out.println("Window opened!"); // Print message to console
            }
        });

        frame.setSize(400, 200); // Set window size
        frame.setVisible(true); // Show the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit app when window closes
    }
}

/*
 * Notes:
 * - MouseAdapter and KeyAdapter are adapter classes that let you override only
 * needed methods.
 * - ActionListener on JTextField triggers when Enter is pressed.
 * - WindowAdapter lets you handle window events like opening and closing with
 * default methods.
 */
