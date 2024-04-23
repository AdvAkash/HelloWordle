import javax.swing.*;

public class SimpleUIExample {
    public static void main(String[] args) {
        // Create a JFrame (window) and set its size
        JFrame frame = new JFrame("Simple UI Example");
        frame.setSize(400, 300);

        // Create a JLabel (text label) to display a message
        JLabel label = new JLabel("Hello, World!");
        
        // Create a JButton (button) to perform an action
        JButton button = new JButton("Click Me");
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Button clicked!");
        });

        // Create a JPanel (container) to hold components
        JPanel panel = new JPanel();
        panel.add(label); // Add the label to the panel
        panel.add(button); // Add the button to the panel

        // Add the panel to the frame and set frame properties
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}



