import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MyKeyListener implements KeyListener {
    //private JTextArea feedbackArea;
    private ArrayList<Letter> wordList = new ArrayList<>();
    private int index = 0;

    public MyKeyListener(){//JTextArea feedbackArea) {
       // this.feedbackArea = feedbackArea;
    }

    // public MyKeyListener(GamePanel gamePanel) {
    //     this.gamePanel = gamePanel;
    // }

    public char typed(){
        return 'a';
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key-typed events (e.g., when the user types a character)
        char typedChar = e.getKeyChar();

        if (typedChar == KeyEvent.VK_ENTER) {

        } else if (typedChar != KeyEvent.VK_BACK_SPACE) {
            GamePanel.guess.add(typedChar);
            /*
            GamePanel.updateKeyPressed(typedChar, 0); // Update the GamePanel with the pressed key
            index++;
            
            // ensures a five-letter word is entered prior to next guess
            if ((index > 4) && (GamePanel.OFFSET < GamePanel.COL)) {
                GamePanel.OFFSET++;
                index = 0;
            }
            */
        } else {
            gamePanel.updateKeyPressed(' ', 1);
            index--;
        }
        // if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
           
        // } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        //     String word = wordBuilder.toString();
        //     if (word.length() == GamePanel.COL) {
        //         gamePanel.processWord(word); // Process the entered word for color change
        //         wordBuilder.setLength(0); // Clear the word buffer
        //         index = 0; // Reset the index for the next word
        //     }
        // }
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