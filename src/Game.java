public class Game {
    public static void main(String[] args) {
        GameController game = new HangmanGame();
        game.newGame();
        game.play();
    }
}
