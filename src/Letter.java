
public class Letter {
	
	private char letter;
	/*
	 * 0 - not attempted
	 * 1 - not in word
	 * 2 - wrong position
	 * 3 - found
	 */
	private int state;
	
	public Letter(char letter) {
		this.setLetter(letter);
		changeState(0);
	}
	
	public int getState() {
		return state;
	}

	public void changeState(int state) {
		this.state = state;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public String toString() {
		return "" + letter;
	}
}
