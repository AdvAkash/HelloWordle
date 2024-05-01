import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class GamePanel extends JPanel implements ActionListener {

    //private static final int HEADER_SIZE = Main.getSize().WIDTH;
    private static Letter[][] grid;
    public static final int ROW = 6;
    public static final int COL = 5;
    public static final int SIZE = 100;
    public static final int WIDTH = 473; 
    public static final int HEIGHT = 150;

    public GamePanel() {
        createComponents();
    }

    public void createComponents() {
        this.setBackground(new Color(128, 128, 128));
        setLayout(null);
        createHeader();
        createGrid();
        updateGrid();
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
                g.drawRect(WIDTH + col * (offset + SIZE),  HEIGHT + row * (offset + SIZE),  SIZE, SIZE);
            }
        }
    }


    public static void updateGrid() {
        ArrayList<Letter> word = new ArrayList<>();
        String example = "AKASH";
        for (int i = 0; i < example.length(); i++) {
            Letter letter = new Letter(example.charAt(i));
            word.add(letter);
        }

        System.out.println(word );

        int index = 0;
        for (int col = 0; col < COL; col++) {
            for (int row = 0; row < ROW; row++) {
                grid[col][row] = word.get(index);
            }
        }
        printGrid(grid); 

    }

    public static void printGrid(Letter[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + " "); // Assuming Letter class has a meaningful toString method
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }


 

}
