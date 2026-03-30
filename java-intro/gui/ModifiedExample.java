import javax.swing.*;
import java.awt.*;

class ModifiedExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Layout Test");
        frame.setLayout(new FlowLayout());

        for (int i = 1; i <= 7; i++) {
            frame.add(new JButton("Button " + i));
        }

        frame.pack(); // replaces setSize()
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
