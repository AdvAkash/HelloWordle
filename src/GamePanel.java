import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {

    //private static final int HEADER_SIZE = Main.getSize().WIDTH;
    private Letter[][] grid;

    public GamePanel() {
        createComponents();
    }

    public void createComponents() {
        this.setBackground(new Color(255, 50, 160));
        setLayout(null);
        createHeader();
        createGrid();
        //createKeyboard();
    }

    public void createHeader() {
        
    }

    public void createGrid() {
        grid = new Letter[6][5];
    }

    public void actionPerformed(ActionEvent e) {

    }
}
