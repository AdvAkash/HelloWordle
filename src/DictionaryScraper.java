import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DictionaryScraper {


    public static void main(String args[]) {
        try {
            System.out.println(pickRandomWord("dictionary.txt"));
        } catch (IOException e) {
            System.out.println("WOW FIX THIS NOW!");
        }
    }


    public static String pickRandomWord(String fileName) throws IOException  {
        ArrayList<String> dictionary = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String word = reader.nextLine();
                dictionary.add(word);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if (dictionary.isEmpty()) {
            return null;
        } else {
            Random random = new Random();
            int index = random.nextInt(dictionary.size());
            return dictionary.get(index);
        }
    }
}
