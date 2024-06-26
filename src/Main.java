import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;

public class Main extends JFrame {

	public static double width;
	public static double height;

	/* Toggle for trick mode
	 * 0 - Regular
	 * 1 - Trick
	 */
	public static int trick = 0;

	/* Difficulty of game
	 * 0 - Easy
	 * 1 - Hard
	 */
	public static int diff = 0;
	public static int trickGuess = 7;


	private JPanel gamePanel; 

	public static void main(String[] args) {
		Main theGUI = new Main();
		SwingUtilities.invokeLater(() -> theGUI.createFrame(theGUI));
	}

	public void createFrame(Object semaphore) {
		this.setTitle("Hello Wordle");
        this.setSize(600, 900);
		this.getContentPane().setBackground(new Color(100,10,50));

        // Allows the application to properly close when the
        // user clicks on the Red-X. It tells the all threads
        // to terminate. This will end the main thread.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMenuBar();

		gamePanel = new GamePanel();
		MyKeyListener keyListener = new MyKeyListener();
		this.addKeyListener(keyListener);
		gamePanel.setBounds(0, 0, WIDTH, HEIGHT);
		this.add(gamePanel);

        // Sets this JFrame to be visible
        this.setVisible(true);
        System.out.println("All done creating our frame");

    }

	private void addMenuBar() {
		JMenuBar bar = new JMenuBar();

		// Adds the menu bar to the JFrame
		this.setJMenuBar(bar);
	
		// Adds more top-level menu options for the specific animation panel
		JMenu menu = new JMenu("Options");
		menu.setMnemonic('O');
	
		JMenu difficultyMenu = new JMenu("Difficulty");
		difficultyMenu.setMnemonic('D');
		JMenu modeMenu = new JMenu("Mode");
		modeMenu.setMnemonic('M');
		JMenuItem restart = new JMenuItem("Restart");
		restart.setMnemonic('R');
		restart.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				System.out.println("HERE");
                restartGame();
            }
        });

		JMenuItem difficultyItem = new JMenuItem("Easy", 'E');
		difficultyMenu.add(difficultyItem);
		difficultyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				Main.diff = 0;
				restartGame();
			}
        });

		difficultyItem = new JMenuItem("Hard", 'H');
		difficultyMenu.add(difficultyItem);
		difficultyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				Main.diff = 1;
            	restartGame();
			}
        });

		JMenuItem modeItem = new JMenuItem("Regular", 'R');
		modeMenu.add(modeItem);
		modeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				Main.trick = 0;
				restartGame();
			}
        });


		modeItem = new JMenuItem("Trick", 'T');
		modeMenu.add(modeItem);
		modeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				Main.trick = 1;
				JOptionPane.showMessageDialog(null, "Trick mode enabled!", "Trick Mode", JOptionPane.INFORMATION_MESSAGE);
				restartGame();
			}
        });

		menu.add(difficultyMenu);
		menu.add(modeMenu);
		menu.add(restart);

		bar.add(menu);
	}

	public void restartGame() {

        // Resets the game state here
        // Resets guesses and guess count
		GamePanel.clearGuesses();
		GamePanel.guessCount = 0;
		Keyboard.clearKeys();
		if(Main.diff == 0){
			try {
				GamePanel.setTargetWord(DictionaryScraper.pickRandomWord("sampleDictionary.txt"));
				JOptionPane.showMessageDialog(null, "The game has been restarted with an easy word.", "Restarted", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				System.out.println("Didn't get new word");
			}
		}else{
			try {
				GamePanel.setTargetWord(DictionaryScraper.pickRandomWord("dictionary.txt"));
				JOptionPane.showMessageDialog(null, "The game has been restarted with a hard word.", "Restarted", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				System.out.println("Didn't get new word");
			}
		}
		if (Main.trick == 1){
			Main.trickGuess = (int)(Math.random()*3)+1;
		}else{
			Main.trickGuess = 7;
		}
        repaint();
    }

}
