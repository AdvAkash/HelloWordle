import javax.swing.*;

public class Main extends JFrame {

	public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

	private static volatile boolean done = false;

	public static void main(String[] args) throws InterruptedException {
		Main theGUI = new Main();
		SwingUtilities.invokeLater(() -> theGUI.createFrame(theGUI));
		synchronized (theGUI) {
            theGUI.wait();
        }


		testing();
		Keyboard keyboard = new Keyboard();
		System.out.println(keyboard);
	}

	public void createFrame(Object semaphore) {
		this.setTitle("Hello Wordle");
        this.setSize(WIDTH, HEIGHT);

        // Allows the application to properly close when the
        // user clicks on the Red-X. It tells the all threads
        // to terminate. This will end the main thread.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // The JFrame has a menu attached to it
        // addMenuBar();

		GamePanel gamePanel = new GamePanel();
		gamePanel.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
		add(gamePanel);
		gamePanel.setVisible(false); 

        // Set this JFrame to be visible
        this.setVisible(true);

        System.out.println("All done creating our frame");
        // tell the main thread that we are done creating our dialogs.
        // This allows the main thread to stop wait()'ing.
        synchronized (semaphore) {
            semaphore.notify();
        }
    }
	
	public static void testing() {
		Word testWord = new Word("Akash");
		System.out.println(testWord);
	}

}
