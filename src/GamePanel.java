import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    Keyboard keyboard;

    // private static final int HEADER_SIZE = Main.getSize().WIDTH;
    private static Letter[][] grid;
    public static final int ROW = 6;
    public static final int COL = 5;
    public static int SIZE;
    public static int WIDTH; 
    public static int HEIGHT;
    public static int OFFSET = 0;
    

    public GamePanel() {
        createComponents();
        keyboard = new Keyboard();
        this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				WIDTH = getWidth();
				HEIGHT = getHeight();
                repaint();
				//theGUI.paintComponents(null);
			}
		});
    }

    public void createComponents() {
        this.setBackground(new Color(255, 255, 255));
        setLayout(null);
        createHeader();
        createGrid();
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
        drawKeyboard(g);

    }


    // TODO: typecast SIZE to double
    public static void drawBoard(Graphics g) {
        SIZE = Math.min((WIDTH * 5 / 8)/COL, (HEIGHT * 5 / 8)/ROW);
        int totalGridWidth = COL * SIZE;
        int totalGridHeight = ROW * SIZE;

        // subtracts width/height of GUI by width/height of grid
        // Divides values by 2 to center grid
        int posX = (WIDTH - totalGridWidth) / 2;
        int posY = (HEIGHT - totalGridHeight) / 2;

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                
                // positions grid boxes side by side
                g.drawRect(posX + col * SIZE, posY + row * SIZE, SIZE, SIZE);
            }
        }
    }

    public static void drawLetters(Graphics g) {
        SIZE = Math.min((WIDTH * 5 / 8)/COL, (HEIGHT * 5 / 8)/ROW);
        Font font = new Font("Arial", Font.BOLD, 24);
        int totalGridWidth = COL * SIZE;
        int totalGridHeight = ROW * SIZE;


        // subtracts width/height of GUI by width/height of grid
        // Divides values by 2 to center grid
        int width = (WIDTH - totalGridWidth) / 2;
        int height = (HEIGHT - totalGridHeight) / 2;
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                g.setFont(font);

                // ensures letter is positioned in middle of grid box
                int x = width + col * SIZE + (SIZE/2);
                int y = height + row * SIZE + (SIZE/2);
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

        // TODO: get rid of loop
        for (int row = 0 + OFFSET; row < ROW; row++) {
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

    public void drawKeyboard(Graphics g) {
        SIZE = Math.min((WIDTH * 3 / 8)/COL, (HEIGHT * 3 / 8)/ROW);
        for (int row = 0; row < keyboard.table.size(); row++) {
            int posX = (WIDTH / 2) - (int) ((((double) (keyboard.table.get(row).size())) / 2.0) * SIZE) + SIZE / 2;
            int posY = HEIGHT - SIZE * (keyboard.table.size() - row) - 20; //-20 for flexability

            for (Letter letter : keyboard.table.get(row)) {
                g.setColor(letter.getColor());
                g.fillRect(posX, posY, SIZE, SIZE);
                g.setColor(Color.BLACK);
                g.drawString(letter.getLetter() + "", posX + SIZE / 2, posY + SIZE / 2);
                posX += SIZE;
            }
            System.out.println();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
        System.out.println(e.getKeyChar()+"");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
        System.out.println(e.getKeyChar());
    }
}
