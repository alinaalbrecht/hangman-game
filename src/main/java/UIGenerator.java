import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UIGenerator {
    private final Set<String> guesses;
    private final String word;

    public UIGenerator(Set<String> guesses, String word) {
        this.guesses = guesses;
        this.word = word;
    }

    public Set<String> getGuesses() {
        return guesses;
    }

    public String getFields() {
        List<String> fieldUI = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            if (guesses.contains(Character.toString(word.charAt(i)))) {
                fieldUI.add(String.valueOf(word.charAt(i)));
            }
            else {
                fieldUI.add("_");
            }
        }
        return fieldUI.toString();
    }

    public String getMan() {
        return "hangman illustration";
    }

    public void addGuess(String letter) {
        guesses.add(letter);
    }

}
