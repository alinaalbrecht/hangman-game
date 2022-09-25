import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Round {

    public void playRound() {
        WordGenerator wordGenerator = new WordGenerator();
        String word = wordGenerator.getWord();
        UIGenerator uiGenerator = new UIGenerator(new HashSet<String>(), word);
        int wrongGuesses = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("I'm thinking of a word...");
        //System.out.println(word);
        System.out.println(uiGenerator.getFields());

        while (wrongGuesses < 10 || wrongGuesses == word.length()) {
            if (roundComplete(uiGenerator.getGuesses(), word)) {
                System.out.println("Congratulations you won the game!");
                System.out.println("You finished the game with " + 5 + " guesses");
                break;
            }
            System.out.println("Enter a guess...");
            String guess = scanner.nextLine();
            uiGenerator.addGuess(guess);
            if (!word.contains(guess)) {
                wrongGuesses++;
            }
            System.out.println(uiGenerator.getFields());
        }
    }

    private boolean roundComplete(Set<String> guesses, String word) {
        String[] wordList = word.split("");
        return guesses.containsAll(List.of(wordList));
    }
}
