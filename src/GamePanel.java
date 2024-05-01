import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class GamePanel extends JPanel implements ActionListener {

    //private static final int HEADER_SIZE = Main.getSize().WIDTH;
    private Letter[][] grid;
    public static final int ROW = 6;
    public static final int COL = 5;
    public static final int SIZE = 100;

    public GamePanel() {
        createComponents();
    }

    public void createComponents() {
        this.setBackground(new Color(128, 128, 128));
        setLayout(null);
        createHeader();
        createGrid();
    }

    public void createHeader() {
    }

    public void createGrid() {
        grid = new Letter[COL][ROW];
        for (int col = 0; col < COL; col++) {
            for (int row = 0; row < ROW; row++) {
                grid[col][row] = new Letter(); 
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);

    }

    public static void drawBoard(Graphics g) {
        int offset = 10 ;
        for (int col = 0; col < COL; col++) {
            for (int row = 0; row < ROW; row++) {
                g.drawRect(473 + col * (offset + SIZE),  150 + row * (offset + SIZE),  SIZE, SIZE);
            }
        }
    }


 

}
