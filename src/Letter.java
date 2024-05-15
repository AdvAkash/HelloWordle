import java.awt.Color;

public class Letter {
	
	private char letter;
	/*
	 * 0 - not attempted
	 * 1 - not in word
	 * 2 - wrong position
	 * 3 - found
	 */
	private int state;

	public Letter() {
		
	}
	
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

	public Color getColor() {
        if (state == 1) {
            return new Color(50, 50, 50);
        }else if (state == 2) {
            return new Color(255, 255, 0);
        }else if (state == 3) {
            return new Color(0, 255, 0);
        }
        return new Color(128, 128, 128);
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
