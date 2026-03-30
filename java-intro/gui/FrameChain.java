import javax.swing.*;
// import java.awt.*;

public class FrameChain {
    public static void main(String[] args) {
        JFrame f1 = new JFrame("Frame 1");
        f1.setSize(200, 150);
        f1.setLocation(100, 100);
        f1.setVisible(true);

        JFrame f2 = new JFrame("Frame 2");
        f2.setSize(200, 150);
        f2.setLocation(f1.getX() + f1.getWidth(), f1.getY() + f1.getHeight());
        f2.setVisible(true);

        JFrame f3 = new JFrame("Frame 3");
        f3.setSize(200, 150);
        f3.setLocation(f2.getX() + f2.getWidth(), f2.getY() + f2.getHeight());
        f3.setVisible(true);

        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
