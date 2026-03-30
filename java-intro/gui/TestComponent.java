import javax.swing.*;
import java.awt.*;

public class TestComponent extends JFrame {

    public TestComponent() {
        super("A new page");
        Container container = getContentPane();
        setSize(500, 300);

        JButton button = new JButton("lets go");
        JTextField textField = new JTextField(10);
        textField.setText("hello");
        System.out.println(textField.getText());
        System.out.println(button.getText());
        JLabel label = new JLabel("this is the label");

        container.setLayout(new FlowLayout());
        container.add(label);
        container.add(textField);
        container.add(button);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TestComponent();
    }

}
