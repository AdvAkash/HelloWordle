import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Scanner;

public class Main extends JFrame {

	public static double width;
	public static  double height;

	private JPanel gamePanel; 

	public static void main(String[] args) {
		Main theGUI = new Main();

		SwingUtilities.invokeLater(() -> theGUI.createFrame(theGUI));
		Keyboard keyboard = new Keyboard();
		//System.out.println(keyboard);
		Word targetWord = new Word("codes");
		System.out.println(targetWord);
		Scanner console = new Scanner(System.in);
		String input;
		Word guess;
		for(int i = 0; i <= 4; i++) {
			input = console.nextLine();
			guess = new Word(input);
			guess.check(targetWord);
			// System.out.println(guess);
		}
		console.close();
	}

	public void createFrame(Object semaphore) {
		this.setTitle("Hello Wordle");
        this.setSize(WIDTH, HEIGHT);

        // Allows the application to properly close when the
        // user clicks on the Red-X. It tells the all threads
        // to terminate. This will end the main thread.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // The JFrame has a menu attached to it
        addMenuBar();

		gamePanel = new GamePanel();
		gamePanel.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
		this.add(gamePanel);
		gamePanel.setVisible(true); 
		

        // Set this JFrame to be visible
        this.setVisible(true);

        System.out.println("All done creating our frame");

    }

	private void addMenuBar() {

		JMenuBar bar = new JMenuBar();
		// Add the menu bar to the JFrame
		this.setJMenuBar(bar);
	
		// Add more top-level menu options for the specific animation panel
		JMenu menu = new JMenu("Options");
		menu.setMnemonic('O');
	
		JMenu submenu = new JMenu("Mode");
		submenu.setMnemonic('M');

		JMenuItem item  = new JMenuItem("Regular", 'R');
		submenu.add(item);
		item = new JMenuItem("Trick", 'T');
		submenu.add(item);
		menu.add(submenu);

		bar.add(menu);
	}

}
