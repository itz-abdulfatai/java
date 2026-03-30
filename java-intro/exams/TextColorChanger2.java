package exams;

import javax.swing.*;
import java.awt.*;

public class TextColorChanger2 extends JFrame {

    public TextColorChanger2() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Numbers Panel");

        // text area

        JTextArea textArea = new JTextArea("Type here");
        add(textArea);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Colors");

        // menu items
        JMenuItem blue = new JMenuItem("blue");
        JMenuItem black = new JMenuItem("black");
        JMenuItem green = new JMenuItem("green");

        blue.addActionListener(e -> textArea.setForeground(Color.blue));
        black.addActionListener(e -> textArea.setForeground(Color.black));
        green.addActionListener(e -> textArea.setForeground(Color.green));

        menu.add(blue);
        menu.add(black);
        menu.add(green);

        setJMenuBar(menuBar);

        menuBar.add(menu);

        setVisible(true);

    }

    public static void main(String[] args) {
        new TextColorChanger2();
    }

}
