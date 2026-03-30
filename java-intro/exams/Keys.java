package exams;

import javax.swing.*;
import java.awt.*;

public class Keys extends JFrame {

    public Keys() {
        setLayout(new GridLayout(0, 3));
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("keys");

        add(new JButton("1"));
        add(new JButton("2"));
        add(new JButton("3"));
        add(new JButton("4"));
        add(new JButton("5"));
        add(new JButton("6"));
        add(new JButton("7"));
        add(new JButton("8"));
        add(new JButton("9"));
        add(new JButton("0"));
        add(new JButton("#"));
        add(new JButton("="));

        setVisible(true);

    }

    public static void main(String[] args) {
        new Keys();

    }

}
