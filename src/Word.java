import java.util.ArrayList;

public class Word {
	private ArrayList<Letter> word = new ArrayList<>();
	
	public Word(String word) {
		word = word.toUpperCase();
		for(int currentChar = 0; currentChar < word.length(); currentChar++) {
			this.word.add(new Letter(word.charAt(currentChar)));
		}
	}

	public Word(){ 
		
	}

	public ArrayList<Letter> getLetters() {
		return word;
	}

	public void check(Word target) {
		int posLetter = 0;
		for (Letter letter : this.word) {
			int pos = 0;
			for (Letter goal : target.getLetters()) {
				
				if (letter.getLetter() == goal.getLetter()) {
					if (posLetter == pos){
						letter.changeState(3);
					}else {
						letter.changeState(2);
					}
					break;
				}else {
					letter.changeState(1);
				}
				pos++;
			}
			posLetter++;
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
