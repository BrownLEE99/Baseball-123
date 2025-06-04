public class Game {

    public void guess(Object guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }
    }
}
