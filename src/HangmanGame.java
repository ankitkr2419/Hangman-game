import API.ApiReader;
import API.WordReader;
import Helpers.HangmanFigureUtils;
import Helpers.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HangmanGame implements GameController {
    private String wordToFind;
    private char[] wordFound;
    private final PlayerState sc = new PlayerState();
    private final ArrayList<String> letters = new ArrayList<>();

    @Override
    public void newGame() {
        sc.initialize();
        letters.clear();
        //API CALL FOR NEW WORD
        ApiReader apiReader = new ApiReader("https://random-word-api.herokuapp.com/word?number=10");
        WordReader wr = new WordReader(apiReader);
        wr.load();

        wordToFind = wr.getWord();
        wordFound = new char[wordToFind.length()];
        Arrays.fill(wordFound, '_');
    }

    @Override
    public void play() {
        try (Scanner input = new Scanner(System.in)) {
            PrintUtils.welcomeMessage();
            while (sc.getWrongGuess() < sc.MAX_LIVES) {
                System.out.print("Word :: ");
                System.out.println(wordFoundContent());
                PrintUtils.enterWordMessage();
                String str = input.next();
                if (str.length() > 1) {
                    str = str.substring(0, 1);
                }
                enter(str);
                if (wordFound()) {
                    System.out.println("\nYou win!");
                    break;
                } else {
                    HangmanFigureUtils.DrawFigure(sc.getWrongGuess());
                    PrintUtils.noOfLivesRemaningMessage(sc.MAX_LIVES, sc.getWrongGuess());
                }
            }
            if (sc.getWrongGuess() == sc.MAX_LIVES) {
                PrintUtils.looseMessage(wordToFind);
            }
        }
    }

    @Override
    public void stop() {
        System.exit(1);
    }

    public boolean wordFound() {
        return wordToFind.contentEquals(new String(wordFound));
    }

    private void enter(String c) {
        if (!letters.contains(c)) {
            if (wordToFind.contains(c)) {
                int index = wordToFind.indexOf(c);
                while (index >= 0) {
                    wordFound[index] = c.charAt(0);
                    index = wordToFind.indexOf(c, index + 1);
                }
            } else {
                sc.incrementWrongGuess();
            }
            letters.add(c);
        }
    }

    private String wordFoundContent() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < wordFound.length; i++) {
            builder.append(wordFound[i]);
            if (i < wordFound.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}