package Helpers;

public class HangmanFigureUtils {

public static String[] HANGMAN = {"""
        +---+
        |   |
        |
        |
        |
        |
      ========""", """
        +---+
        |   |
        |   O
        |
        |
        |
      =========""", """
        +---+
        |   |
        |   O
        |   |
        |
        |
      =========""", """
        +---+
        |   |
        |   O
        |  /|
        |   
        |
      =========""", """
        +---+
        |   |
        |   O
        |  /|\\
        |   
        |
      =========""", """
        +---+
        |   |
        |   O
        |  /|\\
        |  /
        |
      =========""", """
        +---+
        |   |
        |   O
        |  /|\\
        |  / \\
        |
      ========="""
    };

    public static void DrawFigure(int index) {
        switch (index) {
            case 1 -> System.out.println(HangmanFigureUtils.HANGMAN[1]);
            case 2 -> System.out.println(HangmanFigureUtils.HANGMAN[2]);
            case 3 -> System.out.println(HangmanFigureUtils.HANGMAN[3]);
            case 4 -> System.out.println(HangmanFigureUtils.HANGMAN[4]);
            case 5 -> System.out.println(HangmanFigureUtils.HANGMAN[5]);
            case 6 -> System.out.println(HangmanFigureUtils.HANGMAN[6]);
        }
    }
}
