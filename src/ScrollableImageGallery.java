import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScrollableImageGallery extends JFrame {
    private JPanel imagePanel;
    private JScrollPane scrollPane;

    public ScrollableImageGallery() {
        setTitle("Scrollable Image Gallery");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Create a panel to hold the images
        imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Add some sample images (you can replace these with your own logic)
        for (int i = 1; i <= 10; i++) {
            ImageIcon icon = new ImageIcon("path_to_your_image/image" + i + ".jpg");
            JLabel label = new JLabel(icon);
            imagePanel.add(label);
        }

        // Create a scroll pane and add the image panel to it
        scrollPane = new JScrollPane(imagePanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        getContentPane().add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ScrollableImageGallery());
    }
}
