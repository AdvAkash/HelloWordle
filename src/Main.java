import javax.swing.*;

import java.awt.Color;
import java.util.Scanner;

public class Main extends JFrame {

	public static double width;
	public static double height;

	private JPanel gamePanel; 

	public static void main(String[] args) {
		Main theGUI = new Main();

		SwingUtilities.invokeLater(() -> theGUI.createFrame(theGUI));
		// Keyboard keyboard = new Keyboard();
		//System.out.println(keyboard);
		// System.out.println("WIDTH: " + GamePanel.WIDTH);
		// System.out.println("HEIGHT " + GamePanel.HEIGHT);
		// Word targetWord = new Word("codes");
		// System.out.println(targetWord);
		// Scanner console = new Scanner(System.in);
		// String input;
		// Word guess;
		// for(int i = 0; i <= 4; i++) {
		// 	input = console.nextLine();
		// 	guess = new Word(input);
		// 	guess.check(targetWord);
		// }
		// console.close();
	}

	public void createFrame(Object semaphore) {
		this.setTitle("Hello Wordle");
        this.setSize(WIDTH,HEIGHT);
		this.getContentPane().setBackground(new Color(100,10,50));

        // Allows the application to properly close when the
        // user clicks on the Red-X. It tells the all threads
        // to terminate. This will end the main thread.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.getContentPane().setBackground(Color.BLUE);

        // The JFrame has a menu attached to it
        addMenuBar();

		gamePanel = new GamePanel();
		MyKeyListener keyListener = new MyKeyListener();
		this.addKeyListener(keyListener);
		// JScrollPane scroll = new JScrollPane(gamePanel);
		gamePanel.setBounds(0, 0, WIDTH, HEIGHT);
		//this.add(scroll);
		this.add(gamePanel);

		// check if this code is needed
		// gamePanel.setVisible(true); 
		

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
