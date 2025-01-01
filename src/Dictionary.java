import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dictionary {
    private Map<String, String> words = new HashMap<>();

    public Dictionary(String pathName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(pathName));
        readWords(scanner);
        scanner.close();
    }

    public void readWords(Scanner scanner) throws FileNotFoundException {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" - ");
            words.put(parts[0], parts[1]);
        }
    }

    public String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(words.size());

        ArrayList<String> keys = new ArrayList<>(words.keySet());
        return keys.get(index);
    }

    public String getDefinition(String word) {
        return words.get(word);
    }
}