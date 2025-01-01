import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static final String PATH = "src/words.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Dictionary dictionary = new Dictionary(PATH);
        Scanner scanner = new Scanner(System.in);
        boolean isPlayAgain;

        do {
            MaskedWord word  = new MaskedWord(dictionary);

            Game game = new Game(word, scanner);
            game.runGameLoop();

            System.out.println("Хотите сыграть еще раз? (Y/N)");
            char answer = scanner.next().charAt(0);
            isPlayAgain = answer == 'Y' || answer == 'y';
        } while (isPlayAgain);

        scanner.close();
    }
}