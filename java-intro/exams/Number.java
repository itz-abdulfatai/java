package exams;

import javax.swing.*;
import java.awt.*;

public class Number extends JFrame {

    int i = 1;

    public Number() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Panel");
        setLayout(new BorderLayout());
        JButton west = new JButton("One");
        add(west, "Center");
        add(new JButton("four"), "North");
        add(new JButton("three"), "South");
        add(new JButton("two"), "East");
        add(new JButton("five"), "West");

        west.addActionListener(e -> {
            west.setText("" + i);
            i++;
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        new Number();
    }
}
