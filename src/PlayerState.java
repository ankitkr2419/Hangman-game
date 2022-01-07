class PlayerState {
    public final int MAX_LIVES = 6;
    private int wrongGuess;

    public void initialize() {
        wrongGuess = 0;
    }
    public void incrementWrongGuess() {
        wrongGuess = wrongGuess + 1;
    }
    public int getWrongGuess() {
        return wrongGuess;
    }
}
