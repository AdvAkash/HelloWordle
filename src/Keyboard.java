import java.util.ArrayList;

public class Keyboard {

	ArrayList<ArrayList<Letter>> table = new ArrayList<ArrayList<Letter>>();
	String[] keyBoard = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
	
	public Keyboard() {
		
		for (int i = 0; i < 3; i++) {
			table.add(new ArrayList<Letter>());
			for (int j = 0; j < keyBoard[i].length(); j++) {
				table.get(i).add(j, new Letter(keyBoard[i].charAt(j)));
			}
		}
	}
	
	public String toString() {
		String output = "";
		for (ArrayList<Letter> keyBoard: table) {
			for (Letter letter: keyBoard) {
				output += letter + " ";
			}
			output += "\n"; 
		}
		return output; 
	}
}