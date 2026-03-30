import java.awt.*;
import java.awt.event.*;

public class MouseEventTest extends ButtonEventTest {
    public MouseEventTest() {
        class LightUpListener extends MouseAdapter {
            public void mouseEntered(MouseEvent e) {
                Component c = (Component) e.getSource();
                c.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e) {
                Component c = (Component) e.getSource();
                c.setBackground(Color.red);
            }
        }
        MouseListener listener = new LightUpListener();
        button.addMouseListener(listener);
        textField.addMouseListener(listener);
        cp.addMouseListener(listener);
    }

    public static void main(String[] args) {
        new MouseEventTest();
    }
}
