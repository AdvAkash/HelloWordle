import java.util.ArrayList;

public class Word {
	ArrayList<Letter> word = new ArrayList<>();
	
	public Word(String word) {
		for(int currentChar = 0; currentChar < word.length(); currentChar++) {
			this.word.add(new Letter(word.charAt(currentChar)));
		}
	}
	
	public String toString() {
		String output = "";
		for(int i = 0; i < word.size(); i++) {
			output += word.get(i).toString();
		}
		output += "\n";
		for(int i = 0; i < word.size(); i++) {
			output += word.get(i).getState();
		}
		return output;
	}
}
