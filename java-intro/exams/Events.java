package exams;

import java.awt.*;
import javax.swing.*;

public class Events {
    public static void main(String[] args) {
        JFrame frame = new JFrame("hello world");
        frame.setTitle("my title");
        JPanel panel = new JPanel();
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("0"));
        panel.add(new JButton("#"));
        panel.add(new JButton("="));
        frame.setLayout(new GridLayout(0, 3));

        frame.setContentPane(panel);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
