import java.util.ArrayList;

public class Word {
	private ArrayList<Letter> word = new ArrayList<>();
	private String stringWord;
	
	public Word(String word) {
		stringWord = word;
		word = word.toUpperCase();
		for(int currentChar = 0; currentChar < word.length(); currentChar++) {
			this.word.add(new Letter(word.charAt(currentChar)));
		}
	}

	public Word(){ 
		
	}

	public String getWord(){
		if(stringWord == null){
			String constructWord = "";
			for(Letter letter : word){
				constructWord += letter.getLetter();
			}
			return constructWord;
		}
		return stringWord;
	}

	public void addLetter(Character letter){
		word.add(new Letter(letter));
	}

	public void removeLast(){
		word.removeLast();
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
					if((posLetter == pos)){
						letter.changeState(3);
						break;
					}else {
						letter.changeState(2);
					}
				}else {
					if (letter.getState() != 2 && letter.getState() != 3){
						letter.changeState(1);
					}
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
