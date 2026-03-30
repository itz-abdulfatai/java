package exams;

import javax.swing.*;
import java.awt.*;

public class TextColorChanger extends JFrame {

    public TextColorChanger() {
        // Frame setup
        setTitle("Numbers Panel");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JTextArea locally
        JTextArea textArea = new JTextArea("Type your text here...");
        add(textArea);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create Color menu
        JMenu colorMenu = new JMenu("Color");

        // Menu items
        JMenuItem blueItem = new JMenuItem("Blue");
        JMenuItem blackItem = new JMenuItem("Black");
        JMenuItem redItem = new JMenuItem("Red");

        // Add action listeners to change text color
        blueItem.addActionListener(e -> textArea.setForeground(Color.BLUE));
        blackItem.addActionListener(e -> textArea.setForeground(Color.BLACK));
        redItem.addActionListener(e -> textArea.setForeground(Color.RED));

        // Add items to menu
        colorMenu.add(blueItem);
        colorMenu.add(blackItem);
        colorMenu.add(redItem);

        // Add menu to menu bar
        menuBar.add(colorMenu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TextColorChanger();
        });
    }
}
