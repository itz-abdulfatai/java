import java.awt.*; // Imports AWT classes for GUI components and containers
import javax.swing.*; // Imports Swing classes for advanced GUI components

public class TopLevelWindows {
    public static void main(String[] args) {
        // Create a JFrame (a top-level window with title bar, close/minimize/maximize
        // buttons)
        JFrame frame = new JFrame("My JFrame");
        frame.setLocation(100, 100); // Set the position of the frame on the screen (x=100, y=100)
        frame.setSize(300, 300); // Set the size of the frame (width=300, height=300)

        // Get the content pane of the frame (where components are added)
        Container fcp = frame.getContentPane();
        // Create a button and add it to the frame's content pane
        JButton fb = new JButton("Draggable, Resizable Frame");
        fcp.add(fb);

        // Create a JWindow (a top-level window without window decorations)
        JWindow window = new JWindow();
        window.setLocation(500, 100); // Set the position of the window (x=500, y=100)
        window.setSize(300, 300); // Set the size of the window (width=300, height=300)

        // Get the content pane of the window
        Container wcp = window.getContentPane();
        // Create a button and add it to the window's content pane
        JButton wb = new JButton("Unmovable, No Frills Window");
        wcp.add(wb);

        // Make both windows visible
        frame.setVisible(true);
        window.setVisible(true);
    }
}
