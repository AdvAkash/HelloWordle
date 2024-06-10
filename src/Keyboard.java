import java.util.ArrayList;

public class Keyboard {

	public static ArrayList<ArrayList<Letter>> table = new ArrayList<ArrayList<Letter>>();
	private String[] keyBoard = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
	
	public Keyboard() {
		
		for (int i = 0; i < 3; i++) {
			table.add(new ArrayList<Letter>());
			for (int j = 0; j < keyBoard[i].length(); j++) {
				table.get(i).add(j, new Letter(keyBoard[i].charAt(j)));
			}
		}
	}

	public void updateKeys(Word word) {
		for(Letter letter: word.getLetters()){
			int i;
			for (i = 0; i <= keyBoard.length; i++){
				if(keyBoard[i].contains(letter.getLetter() + "")){
					break;
				}
			}
			int pos = keyBoard[i].indexOf(letter.getLetter());
			table.get(i).get(pos).changeState(letter.getState());
		}
	}
	
	public String toString() {
		String output = "";
		for (ArrayList<Letter> keyBoard: table) {
			for (Letter letter: keyBoard) {
				output += letter.toString() + letter.getState() + " ";
			}
			output += "\n"; 
		}
		return output; 
	}

	public static void clearKeys() {
		for (ArrayList<Letter> row : table) {
			for (Letter letter : row) {
				letter.changeState(0);
			}
		}
	}
}