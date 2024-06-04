import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MyKeyListener implements KeyListener {
    //private JTextArea feedbackArea;
    private GamePanel gamePanel;
    private StringBuilder wordBuilder;
    private ArrayList<Letter> wordList = new ArrayList<>();
    private int index = 0;

    public MyKeyListener(){//JTextArea feedbackArea) {
       // this.feedbackArea = feedbackArea;
    }

    public MyKeyListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.wordBuilder = new StringBuilder();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key-typed events (e.g., when the user types a character)
        char typedChar = e.getKeyChar();
        //feedbackArea.append("Typed: " + typedChar + "\n");
        // System.out.println("Typed: " + typedChar + "\n");
        // word += typedChar; 
        // if (word.length() > 4) {
        //     GamePanel.updateGrid(word);
        //     word="";
        // }
        gamePanel.updateKeyPressed(typedChar); // Update the GamePanel with the pressed key
        index++;
        if ((index > 4) && (GamePanel.OFFSET <= GamePanel.COL)) {
            GamePanel.OFFSET++;
            index = 0;
        }
    }
        
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key-released events (e.g., when a key is released after being pressed)
        int keyCode = e.getKeyCode();
        //feedbackArea.append("Released: " + KeyEvent.getKeyText(keyCode) + "\n");
    }

    public ArrayList<Letter> getWordList() {
        return wordList;
    }
}