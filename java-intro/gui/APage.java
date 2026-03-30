import java.awt.*;

import javax.swing.*;

public class APage {
    JFrame frame = new JFrame("hello world");

    Container container = frame.getContentPane();
    JTextField inpField = new JTextField("hello world");
    JLabel label = new JLabel("this is a label");

    JButton button = new JButton("tap me");

    public APage() {
        container.setLayout(new FlowLayout());
        container.add(label);
        container.add(inpField);
        container.add(button);
        frame.setSize(300, 200); // Set a default size for the frame
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        new APage();

    }

}
