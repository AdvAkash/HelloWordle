import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

    public MyKeyListener(){
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key-typed events (e.g., when the user types a character)
        char typedChar = e.getKeyChar();
        if(typedChar == KeyEvent.VK_ENTER){
            GamePanel.guess();
        }else if (typedChar == KeyEvent.VK_BACK_SPACE) {
            GamePanel.backspace();
        }else if (GamePanel.guess.getLetters().size()<5){
            try {
                typedChar = Character.toUpperCase(e.getKeyChar());
                GamePanel.guess.addLetter(typedChar);
            } catch (Exception ex) {
                System.out.println("Not a letter, try any of the following:\nA B C D E F\nG H I J K L M\nN O P Q R S\nT U V W X Y Z");
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