package exams;

import javax.swing.*;
import java.awt.*;

public class MyProgram2 extends JFrame {

    public MyProgram2() {
        setTitle("My Program");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 5, 5));

        // first number
        JLabel firstLabel = new JLabel("First Number:");
        JTextField firsField = new JTextField();
        add(firstLabel);
        add(firsField);

        // second number
        JLabel secondLabel = new JLabel("second Number:");
        JTextField secondField = new JTextField();
        add(secondLabel);
        add(secondField);

        // result label
        JLabel resultLabel = new JLabel("computed result");
        add(resultLabel);

        // buttons
        JButton plusButton = new JButton("Plus");
        JButton minusButton = new JButton("minus");

        JPanel panel = new JPanel();
        panel.add(plusButton);
        panel.add(minusButton);
        add(panel);

        plusButton.addActionListener(e -> {
            double num1 = Double.parseDouble(firsField.getText());
            double num2 = Double.parseDouble(secondField.getText());

            resultLabel.setText("Result:" + (num1 + num2));
        });
        minusButton.addActionListener(e -> {
            double num1 = Double.parseDouble(firsField.getText());
            double num2 = Double.parseDouble(secondField.getText());

            resultLabel.setText("Result:" + (num1 - num2));
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MyProgram2();
    }

}
