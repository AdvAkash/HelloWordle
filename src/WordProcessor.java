import java.io.*;
import java.util.Scanner;

public class WordProcessor {
    public static void main(String[] args) {
        String inputFileName = "wordList.txt";
        String outputFileName = "dictionary.txt";

        try (Scanner scanner = new Scanner(new File(inputFileName));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFileName))) {

            while (scanner.hasNext()) {
                String word = scanner.next();
                // Remove punctuation and keep only 5-letter words
                word = word.replaceAll("[^a-zA-Z]", "");
                if (word.length() == 5) {
                    writer.println(word.toUpperCase());
                }
            }
            System.out.println("Processing complete. Check " + outputFileName + " for results.");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + outputFileName);
        }
    }
}
