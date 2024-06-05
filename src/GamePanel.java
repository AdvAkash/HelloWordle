import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class GamePanel extends JPanel{

    static Word target = new Word("CODES");
    Keyboard keyboard;
	public static Word guess = new Word();
    private static ArrayList<Word> guesses = new ArrayList<>();
    Font font = new Font("Arial", Font.BOLD, 24);

    // private static final int HEADER_SIZE = Main.getSize().WIDTH;
    private static Letter[][] grid;
    public static final int ROW = 6;
    public static final int COL = 5;
    public static int SIZE;
    public static int WIDTH; 
    public static int HEIGHT;
    public static int OFFSET = 0;
    public static int count;
    

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


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //drawBoard(g);
        //drawLetters(g);
        drawGridOfLetters(g);
        drawKeyboard(g);

    }

    /*
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
    */

    public void drawGridOfLetters(Graphics g) {
        SIZE = Math.min((WIDTH * 5 / 8) / COL, (HEIGHT * 5 / 8) / ROW);
        int totalGridWidth = COL * SIZE;
        int totalGridHeight = ROW * SIZE;
        int x;
        int y;
        int row = 0;
        int col = 0;
        int letterX;
        int letterY;
    
        // Subtract width/height of GUI by width/height of grid
        // Divide values by 2 to center the grid
        int posX = (WIDTH - totalGridWidth) / 2;
        int posY = (HEIGHT - totalGridHeight) / 2;
    
        // Set the gap size (adjust as needed)
        int gap = 5; // You can change this value
    
        for (; row < guesses.size(); row++) {
            for (; col < 5; col++) {
                g.setFont(font);
    
                // Calculate the position with gap
                x = posX + col * (SIZE + gap);
                y = posY + row * (SIZE + gap);
    
                // Draw the black outline
                g.setColor(guesses.get(row).getLetters().get(col).getColor());
                g.fillRect(x, y, SIZE, SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, SIZE, SIZE);
    
                // Draw the letter (centered within the box)
                letterX = x + SIZE / 2;
                letterY = y + SIZE / 2;
                g.drawString(guesses.get(row).getLetters().get(col).toString(), letterX, letterY+OFFSET);
            }
        }
        y = posY + (row+1) * (SIZE + gap);
        letterY = y + SIZE / 2;
        for(col = 0; col < guess.getLetters().size(); col++){
            x = posX + col * (SIZE + gap);
            letterX = x + SIZE / 2;
            g.drawString(guess.getLetters().get(col).toString(), letterX, letterY);
        }
        repaint();
    }
    
    

    public static void updateGrid(String example) {
        ArrayList<Letter> word = new ArrayList<>();
        for (int i = 0; i < example.length(); i++) {
            Letter letter = new Letter(example.charAt(i));
            word.add(letter);
        }

        System.out.println(word);

        int index = 0;
        for (int col = 0; col < COL; col++) {
                grid[OFFSET][col] = word.get(index);
                index++;
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
        SIZE = Math.min((WIDTH * 3 / 8) / COL, (HEIGHT * 3 / 8) / ROW);
    
        for (int row = 0; row < keyboard.table.size(); row++) {
            int posX = (WIDTH / 2) - (int) ((((double) (keyboard.table.get(row).size())) / 2.0) * SIZE);
            int posY = HEIGHT - SIZE * (keyboard.table.size() - row);
    
            for (Letter letter : keyboard.table.get(row)) {
                g.setColor(letter.getColor());
                g.fillRect(posX, posY, SIZE, SIZE);
                g.setColor(Color.BLACK);
    
                // Center the letter within the box
                int x = posX + SIZE / 2;
                int y = posY + SIZE / 2;
                g.setFont(font);
                g.drawString(letter.getLetter() + "", x, y);
    
                posX += SIZE;
            }
        }
    }
    

    /*
    public void drawKeyboard(Graphics g) {
        SIZE = Math.min((WIDTH * 3 / 8)/COL, (HEIGHT * 3 / 8)/ROW);
        for (int row = 0; row < keyboard.table.size(); row++) {
            int posX = (WIDTH / 2) - (int) ((((double) (keyboard.table.get(row).size())) / 2.0) * SIZE);
            int posY = HEIGHT - SIZE * (keyboard.table.size() - row); 

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
    */

    public void updateKeyPressed(char keyPressed, int backspace) {
        // Add the pressed key to the grid immediately
        for (int col = 0; col < COL; col++) {
            if (grid[OFFSET][col].getLetter() == 0) {
                if(backspace == 1){
                    grid[OFFSET][col-backspace] = new Letter();
                    break;
                }else{
                    grid[OFFSET][col] = new Letter(keyPressed);
                    break;
                }
            }
        }
        repaint(); // Refresh the panel to display the updated grid
    }

    public static void test() {

    }

    public void processWord(String word) {
        // Change the color of each tile in the current row
        for (int col = 0; col < COL; col++) {
            grid[OFFSET][col].changeState(3); // Change state to indicate found
        }
        repaint(); // Refresh the panel to display the updated grid
    }
    
    public static void guess(){
        Word newGuess = new Word(guess.getWord());
        newGuess.check(target);
        guesses.add(newGuess);
        System.out.println(guess);
        System.out.println(guesses);
        guess = new Word();
    }

    public static void backspace(){
        guess.removeLast();
    }
}
