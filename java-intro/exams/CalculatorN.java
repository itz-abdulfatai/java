package exams;

import javax.swing.*;
import java.awt.*;

public class CalculatorN extends JFrame {

    public CalculatorN() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel keysPanel = new JPanel(new GridLayout(0, 3));
        keysPanel.add(new JButton("1"));
        keysPanel.add(new JButton("2"));
        keysPanel.add(new JButton("3"));
        keysPanel.add(new JButton("4"));
        keysPanel.add(new JButton("5"));
        keysPanel.add(new JButton("6"));
        keysPanel.add(new JButton("7"));
        keysPanel.add(new JButton("8"));
        keysPanel.add(new JButton("9"));
        keysPanel.add(new JButton("*"));
        keysPanel.add(new JButton("0"));
        keysPanel.add(new JButton("#"));

        mainPanel.add(keysPanel, "Center");
        // // mainPanel.add(new JButton("North"), "North");
        mainPanel.add(new TextField(), "North");
        // mainPanel.add(new JButton("South"), "South");
        // mainPanel.add(new JButton("East"), "East");
        // mainPanel.add(new JButton("West"), "West");

        setContentPane(mainPanel);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new CalculatorN();
    }
}
