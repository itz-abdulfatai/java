package exams;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    public Calculator() {

        // Use BorderLayout so children can take full width
        JPanel panel1 = new JPanel(new BorderLayout());

        // Top text field
        JTextField textField = new JTextField();
        panel1.add(textField, "North");

        // Middle number buttons
        JPanel panel2 = new JPanel(new GridLayout(0, 3, 2, 2)); // 4 rows, 3 cols, gaps for spacing
        panel2.add(new JButton("1"));
        panel2.add(new JButton("2"));
        panel2.add(new JButton("3"));
        panel2.add(new JButton("4"));
        panel2.add(new JButton("5"));
        panel2.add(new JButton("6"));
        panel2.add(new JButton("7"));
        panel2.add(new JButton("8"));
        panel2.add(new JButton("9"));
        panel2.add(new JButton("0"));
        panel2.add(new JButton("#"));
        panel2.add(new JButton("="));
        panel1.add(panel2, "Center");

        // Bottom action buttons
        JPanel panel3 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel3.add(new JButton("Cancel"));
        panel3.add(new JButton("Redial"));
        panel1.add(panel3, "South");

        // Frame settings
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
