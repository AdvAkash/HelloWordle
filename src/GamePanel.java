import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class GamePanel extends JPanel {

    
    
    public static Word target;
	public static Word guess = new Word();
    public static int guessCount = 0;
    private static ArrayList<Word> guesses = new ArrayList<>();

    private static Keyboard keyboard;
    private static Letter[][] grid;
    public static final int ROW = 6;
    public static final int COL = 5;
    public static int SIZE;
    public static int WIDTH; 
    public static int HEIGHT;

    // could delete
    private int gap = 5;

    public GamePanel() {
        createComponents();
        keyboard = new Keyboard();
        this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				WIDTH = getWidth();
				HEIGHT = getHeight();
                repaint();
			}
		});

    }

    public static void setTargetWord(String word) {
        target = new Word(word);
    }

    public void createComponents() {
        this.setBackground(new Color(255, 255, 255));
        this.setLayout(new BorderLayout());
        createHeader();
        createGrid();
    }


    public void createHeader() {
        JLabel headerLabel = new JLabel("HelloWordle");
        headerLabel.setFont( new Font("Arial", Font.BOLD, 72));
        headerLabel.setForeground(Color.BLACK); // You can change the color as needed
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Set the label to resize with the frame
        this.add(headerLabel, BorderLayout.NORTH);
    }
    

    public void createGrid() {
        grid = new Letter[ROW][COL];
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                grid[row][col] = new Letter();
            }
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGridOfLetters(g);
        drawKeyboard(g);

    }

    /*
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
        SIZE = Math.min((WIDTH * 9 / 16) / COL, (HEIGHT * 9 / 16) / ROW);
        int totalGridWidth = COL * SIZE;
        int totalGridHeight = 3*(SIZE+gap);//ROW * SIZE;
        int x;
        int y;
        int row;
        int col;
        int letterX;
        int letterY;
    
        // Subtract width/height of GUI by width/height of grid
        // Divide values by 2 to center the grid
        int posX = (WIDTH - totalGridWidth) / 2;
        int posY = //g.getFontMetrics(titleFont).getHeight()+0; (HEIGHT - totalGridHeight) / 2;
        (totalGridHeight-g.getFontMetrics( new Font("Arial", Font.BOLD, 72)).getHeight());
        for (row = 0; row < guesses.size(); row++) {
            for (col = 0; col < 5; col++) {
                g.setFont(new Font("Arial", Font.BOLD, 24));
    
                // Calculates the position with gap
                x = posX + col * (SIZE + gap);
                y = posY + row * (SIZE + gap);
    
                // Draws the black outline
                g.setColor(guesses.get(row).getLetters().get(col).getColor());
                g.fillRect(x, y, SIZE, SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, SIZE, SIZE);
    
                // Draws the letter (centered within the box)
                letterX = x + SIZE / 2;
                letterY = y + SIZE / 2;
    
                // Centers the text properly
                FontMetrics fm = g.getFontMetrics();
                int textWidth = fm.stringWidth(guesses.get(row).getLetters().get(col).toString());
                int textHeight = fm.getAscent();
    
                g.drawString(guesses.get(row).getLetters().get(col).toString(), letterX - textWidth / 2, letterY + textHeight / 4);
            }
        }
    
        // Draw the current guess
        y = posY + (row) * (SIZE + gap);
        letterY = y + SIZE / 2;
        for (col = 0; col < guess.getLetters().size(); col++) {
            x = posX + col * (SIZE + gap);
            letterX = x + SIZE / 2;
            g.setFont(new Font("Arial", Font.BOLD, 24));
    
            // Centers the text properly
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(guess.getLetters().get(col).toString());
            int textHeight = fm.getAscent();
    
            g.drawString(guess.getLetters().get(col).toString(), letterX - textWidth / 2, letterY + textHeight / 4);
        }
    
        repaint();
    }
    
    
    

    // public static void updateGrid(String example) {
    //     ArrayList<Letter> word = new ArrayList<>();
    //     for (int i = 0; i < example.length(); i++) {
    //         Letter letter = new Letter(example.charAt(i));
    //         word.add(letter);
    //     }

    //     System.out.println(word);

    //     int index = 0;
    //     for (int col = 0; col < COL; col++) {
    //             grid[OFFSET][col] = word.get(index);
    //             index++;
    //     }
    //     OFFSET++;
    //     printGrid(grid);

    // }

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
    SIZE = Math.min((WIDTH * 7 / 16) / COL, (HEIGHT * 7 / 16) / ROW);
    // int gap = 5;

    for (int row = 0; row < Keyboard.table.size(); row++) {
        int posX = (WIDTH / 2) - (int) ((((double) (Keyboard.table.get(row).size())) / 2.0) * (SIZE + gap));
        int posY = HEIGHT - (SIZE + gap) * (Keyboard.table.size() - row);

        for (Letter letter : Keyboard.table.get(row)) {
            g.setColor(letter.getColor());
            g.fillRect(posX, posY, SIZE, SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(posX, posY, SIZE, SIZE);

            // Get font metrics
            FontMetrics fm = g.getFontMetrics(new Font("Arial", Font.BOLD, 24));

            // Calculate the position to center the letter within the box
            int x = posX + (SIZE - fm.stringWidth(letter.getLetter()+"")) / 2;
            int y = posY + (SIZE + fm.getAscent()) / 2;

            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.drawString(letter.getLetter()+"", x, y);

            posX += SIZE + gap;
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

    // public void updateKeyPressed(char keyPressed, int backspace) {
    //     // Add the pressed key to the grid immediately
    //     for (int col = 0; col < COL; col++) {
    //         if (grid[OFFSET][col].getLetter() == 0) {
    //             if(backspace == 1){
    //                 grid[OFFSET][col-backspace] = new Letter();
    //                 break;
    //             }else{
    //                 grid[OFFSET][col] = new Letter(keyPressed);
    //                 break;
    //             }
    //         }
    //     }
    //     repaint(); // Refresh the panel to display the updated grid
    // }

    // public static void test() {

    // }

    // public void processWord(String word) {
    //     // Change the color of each tile in the current row
    //     for (int col = 0; col < COL; col++) {
    //         grid[OFFSET][col].changeState(3); // Change state to indicate found
    //     }
    //     repaint(); // Refresh the panel to display the updated grid
    // }
    
    public static void guess(){
        Word newGuess = new Word(guess.getWord());
        newGuess.check(target);
        guesses.add(newGuess);
        keyboard.updateKeys(newGuess);
        System.out.println(guess);
        System.out.println(guesses);
        guess = new Word();
        guessCount++;

        // checks to see if user guessed word in less than 6 guesses 
        if (newGuess.toString().contains("33333")) {
            JOptionPane.showMessageDialog(null, "Congratulations! You won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        } else if (guessCount == 6) {
            String missedWord = target.getWord(); // Get the missed word
            JOptionPane.showMessageDialog(null, "Sorry! You lost. The correct word was: " + missedWord, "Game Over", JOptionPane.ERROR_MESSAGE);
        }else if (GamePanel.guessCount == Main.trickGuess){
            JOptionPane.showMessageDialog(null, "Word Changed! You have " + (6-Main.trickGuess) + " more guesses!\nThe keyboard will only update the new letters you guess!\nThe previous guesses can now be ignored!\nGood luck!", "Word Changed", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void backspace(){
        guess.removeLast();
    }

    public static void clearGuesses() {
        guesses.clear();
    }
}
