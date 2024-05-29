import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class DictionaryScraper {
    public static void main(String[] args) {
        String baseUrl = "https://dictionary.cambridge.org/browse/english/";
        ArrayList<String> allWords = new ArrayList<>();

        // Define the letters you want to scrape (e.g., A to Z)
        char startLetter = 'a';
        char endLetter = 'Z';

        for (char letter = startLetter; letter <= endLetter; letter++) {
            String url = baseUrl + letter;
            try {
                Document doc = Jsoup.connect(url).get();
                Elements wordLinks = doc.select(".entry-title"); // Adjust the selector based on the website's structure

                for (var link : wordLinks) {
                    String word = link.text();
                    allWords.add(word);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Print the scraped words
        for (String word : allWords) {
            System.out.println(word);
        }
    }
}
