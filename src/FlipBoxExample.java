// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class FlipBoxExample {
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             JFrame frame = new JFrame("Flip Box Example");
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             frame.setSize(400, 400);

//             JPanel mainPanel = new JPanel(new GridLayout(5, 5, 10, 10)); // Grid layout for 5x5 grid
//             for (int i = 0; i < 25; i++) {
//                 JPanel cardPanel = createFlipCard();
//                 mainPanel.add(cardPanel);
//             }

//             frame.add(mainPanel);
//             frame.setVisible(true);
//         });
//     }

//     public static JPanel createFlipCard() {
//         JPanel cardPanel = new JPanel();
//         cardPanel.setLayout(new CardLayout());

//         JPanel frontPanel = new JPanel();
//         frontPanel.setBackground(Color.RED);
//         frontPanel.setPreferredSize(new Dimension(50, 50));
//         cardPanel.add(frontPanel, "front");

//         JPanel backPanel = new JPanel();
//         backPanel.setBackground(Color.BLUE);
//         backPanel.setPreferredSize(new Dimension(50, 50));
//         cardPanel.add(backPanel, "back");

//         Timer timer = new Timer(1000, new ActionListener() {
//             boolean isFront = true;

//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
//                 if (isFront) {
//                     cardLayout.show(cardPanel, "back");
//                 } else {
//                     cardLayout.show(cardPanel, "front");
//                 }
//                 isFront = !isFront;
//             }
//         });
//         timer.start();

//         return cardPanel;
//     }
// }
