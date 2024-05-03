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
    public static int OFFSET = 0;

    public GamePanel() {
        createComponents();
    }

    public void createComponents() {
        this.setBackground(new Color(128, 128, 128));
        setLayout(null);
        createHeader();
        createGrid();
        updateGrid("AKASH");
        updateGrid("HELLO");
        updateGrid("WORLD");
    }

    public void createHeader() {
    }

    public void createGrid() {
        grid = new Letter[ROW][COL];
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                grid[row][col] = new Letter(); 
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawLetters(g); 

    }

    public static void drawBoard(Graphics g) {
        // int offset = 10 ;
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                g.drawRect(WIDTH + col * (SIZE),  HEIGHT + row * (SIZE),  SIZE, SIZE);
            }
        }
    }

    public static void drawLetters(Graphics g) {
        Font font = new Font("Arial", Font.BOLD, 24); 

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                int x = WIDTH + col * (OFFSET+SIZE) + OFFSET + 30;
                int y = HEIGHT + row * (OFFSET+SIZE) + OFFSET + 50;
                g.setFont(font);
                g.drawString(grid[row][col].toString(), x, y);
            }
        }
    }


    public static void updateGrid(String example) {
        ArrayList<Letter> word = new ArrayList<>();
        for (int i = 0; i < example.length(); i++) {
            Letter letter = new Letter(example.charAt(i));
            word.add(letter);
        }

        System.out.println(word);

        int index = 0;
        for (int row = 0 + OFFSET; row < ROW ; row++) {
            for (int col = 0; col < COL; col++) {
                grid[row][col] = word.get(index);
                index++;
            }
            break;
        }
        OFFSET++;
        printGrid(grid); 

    }

    // outputs Grid to Console
    public static void printGrid(Letter[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + " "); // Assuming Letter class has a meaningful toString method
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }


 

}
