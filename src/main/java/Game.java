public class Game {

    private static void assertIllegalArgument(String guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }
        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (char number : guessNumber.toCharArray()) {
            if (number < '0' || number > '9') {
                throw new IllegalArgumentException();
            }
        }

        if (isDuplicatedNumber(guessNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicatedNumber(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1)
                || guessNumber.charAt(1) == guessNumber.charAt(2)
                || guessNumber.charAt(2) == guessNumber.charAt(0);
    }

    public void guess(String guessNumber) {
        assertIllegalArgument(guessNumber);
    }
}
