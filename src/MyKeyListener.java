import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class MyKeyListener implements KeyListener {

    public MyKeyListener(){
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        // Handle key-typed events (e.g., when the user types a character)
        if (GamePanel.guessCount < 6) {
            char typedChar = e.getKeyChar();
            if(typedChar == KeyEvent.VK_ENTER){
                if (GamePanel.guess.getLetters().size() == 5) {

                    GamePanel.guess();
                }
            }else if (typedChar == KeyEvent.VK_BACK_SPACE) {
                GamePanel.backspace();
            }else if ((GamePanel.guess.getLetters().size()<5) && (Character.isLetter(typedChar))){
                try {
                    typedChar = Character.toUpperCase(e.getKeyChar());
                    GamePanel.guess.addLetter(typedChar);
                } catch (Exception ex) {
                    System.out.println("Not a letter, try any of the following:\nA B C D E F\nG H I J K L M\nN O P Q R S\nT U V W X Y Z");
                }
                if(Main.trick == 1 && GamePanel.guessCount == Main.trickGuess){
                    try {
                        if(Main.diff == 0){
                            GamePanel.setTargetWord(DictionaryScraper.pickRandomWord("sampleDictionary.txt"));
                        }else{
                            GamePanel.setTargetWord(DictionaryScraper.pickRandomWord("dictionary.txt"));
                        }
                    } catch (IOException e1) {
                        System.out.println("Didn't get new word");
                    }
                }
            }
        }
    }
        
    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}