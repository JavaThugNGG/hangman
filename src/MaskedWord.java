import java.util.*;

public class MaskedWord {
    private final String secretWord;
    private String mask;
    private final String definition;

    public MaskedWord(Dictionary dictionary) {
        secretWord = dictionary.getRandomWord();
        definition = dictionary.getDefinition(secretWord);
        mask = "*".repeat(secretWord.length());
    }

    public void openLetter(char letter) {
        char[] maskArray = mask.toCharArray();
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                maskArray[i] = letter;
            }
        }
        mask = new String(maskArray);
    }

    public boolean containsLetter(char letter) {
        return secretWord.indexOf(letter) != -1;
    }

    public boolean isFullyOpen() {
        return mask.equals(secretWord);
    }

    public void openNLettersInMask(int letterCount) {
        Random random = new Random();
        for (int i = 0; i < letterCount; i++) {
            int randomIndex = random.nextInt(secretWord.length() + 1);
            char randomLetter = secretWord.charAt(randomIndex);
            openLetter(randomLetter);
        }
    }

    public String getDefinition() {
        return definition;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public String getMask() {
        return mask;
    }
}