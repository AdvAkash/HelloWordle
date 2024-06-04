import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    //private JTextArea feedbackArea;

    public MyKeyListener(){//JTextArea feedbackArea) {
       // this.feedbackArea = feedbackArea;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key-typed events (e.g., when the user types a character)
        char typedChar = e.getKeyChar();
        //feedbackArea.append("Typed: " + typedChar + "\n");
        System.out.println("Typed: " + typedChar + "\n");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle key-pressed events (e.g., when a key is physically pressed down)
        int keyCode = e.getKeyCode();
        //feedbackArea.append("Pressed: " + KeyEvent.getKeyText(keyCode) + "\n");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key-released events (e.g., when a key is released after being pressed)
        int keyCode = e.getKeyCode();
        //feedbackArea.append("Released: " + KeyEvent.getKeyText(keyCode) + "\n");
    }
}