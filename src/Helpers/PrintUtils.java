package Helpers;

public class PrintUtils {
    public static void welcomeMessage() {
        System.out.println("-------------------------");
        System.out.println("Welcome To our Hangman Game");
        System.out.println("""
                    (*) The word the user must guess                             (*)
                    (*) The word has to be guessed before your run out of lives  (*)
                    (*) You will be given 6 lives at starting                    (*) 
                    """);
        System.out.println(HangmanFigureUtils.HANGMAN[0]);
        System.out.println("-------------------------");
    }
    public static void enterWordMessage() {
        System.out.print("Please Enter the Word :: ");
    }
    public static void looseMessage(String wordToFind) {
        System.out.println("You lose!");
        System.out.println("Word to find was : " + wordToFind);
    }
    public static void noOfLivesRemaningMessage(int maxLive, int wrongGuesses) {
        System.out.println("No of lives remaining : " + (maxLive - wrongGuesses));
        System.out.println("----------------------------");
    }
}
