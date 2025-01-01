import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private Scanner scanner;
    private static final int EASY = 1;
    private static final int MEDIUM = 2;
    private static final int HARD = 3;
    private MaskedWord maskedWord;

    public Game(MaskedWord maskedWord, Scanner scanner) {
        this.maskedWord = maskedWord;
        this.scanner = scanner;
    }

    public void runGameLoop() {
        int difficultyLevel = inputDifficultyLevel(scanner);
        Set<Character> usedLetters = new HashSet<>();

        if (difficultyLevel == EASY) {
            maskedWord.openNLettersInMask(2);
        }

        int mistakes = 0;
        boolean isWin = false;
        boolean isLose = false;
        do {
            printHangman(mistakes);
            System.out.println("\nОшибок: " + mistakes);
            System.out.println(maskedWord.getMask());

            if (difficultyLevel == EASY || difficultyLevel == MEDIUM) {
                System.out.println("Определение слова: " + maskedWord.getDefinition());
            }

            char letter = inputValidLetter(scanner, usedLetters);
            usedLetters.add(letter);

            if (maskedWord.containsLetter(letter)) {
                maskedWord.openLetter(letter);
            } else {
                mistakes++;
            }

            if (mistakes == 6) {
                isLose = true;
            }

            if (maskedWord.isFullyOpen()) {
                isWin = true;
            }
        } while (!isWin && !isLose);

        if (isWin) {
            System.out.println("Вы выиграли! Загаданное слово: " + maskedWord.getSecretWord());
            System.out.println("Определение: " + maskedWord.getDefinition());
        } else {
            printHangman(mistakes);
            System.out.println("Вы проиграли! Загаданное слово: " + maskedWord.getSecretWord());
            System.out.println("Определение: " + maskedWord.getDefinition());
        }
    }

    public static char inputValidLetter(Scanner scanner, Set<Character> usedLetters) { //оставляем static потому что не обращается к текущему состоянию класса
        while (true) {
            System.out.println("Введите букву: ");
            String input = scanner.next();

            if (input.length() != 1) {
                System.out.println("Введите только одну букву!");
                continue;
            }

            char letter = input.charAt(0);

            if (letter < 'а' || letter > 'я') {
                System.out.println("Введите строчную букву русского алфавита!");
                continue;
            }

            if (usedLetters.contains(letter)) {
                System.out.println("Вы уже вводили эту букву!");
                continue;
            }

            return letter;
        }
    }

    static int inputDifficultyLevel(Scanner scanner) {
        System.out.println("Выберите уровень сложности (1/2/3: ");
        System.out.println("1. Легкий - значение слова как подсказка, две открытые буквы");
        System.out.println("2. Средний - значение слова как подсказка");
        System.out.println("3. Сложный - без подсказок");

        while (true) {
            String input = scanner.next();

            if (!input.matches("\\d")) {
                System.out.println("Введите число!");
                continue;
            }

            int difficultyLevel = Integer.parseInt(input);

            if (difficultyLevel < 1 || difficultyLevel > 3) {
                System.out.println("Введите число от 1 до 3!");
                continue;
            }

            return difficultyLevel;
        }
    }


    static void printHangman(int mistakes) {
        switch (mistakes) {
            case 0:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 1:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 2:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 3:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 4:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 5:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" /    |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 6:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                System.out.println("      |");
                System.out.println("=========");
                break;
        }
    }
}