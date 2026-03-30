package exams;

import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.*;
import javax.swing.JLabel;

public class Gui {
    public static void main(String[] args) {

        JFrame frame = new JFrame(); // creates a window
        frame.setTitle("this is our title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make window close when i tap "X"
        // frame.setResizable(false);// dissalow resize
        ImageIcon image = new ImageIcon("exams/img.png"); // create image icon
        frame.setIconImage(image.getImage());
        frame.setSize(420, 420); // sets the size of the window
        frame.setVisible(true); // make window visible
        frame.getContentPane().setBackground(new Color(225, 200, 150)); // change bg color

        JLabel label = new JLabel("this is a label");
        label.setIcon(image);
        label.setText("this is a label");
        label.setHorizontalTextPosition(JLabel.CENTER); // position of text in relation to its image
        label.setVerticalTextPosition(JLabel.TOP);

        frame.add(label);

    }

}
