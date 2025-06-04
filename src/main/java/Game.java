public class Game {
    public String question;

    public GuessResult guess(String guessNumber) {
        assertIllegalArgument(guessNumber);
        int matchedStrikes = getMatchedStrikes(guessNumber);
        int matchedBalls = getMatchedBalls(guessNumber);

        return new GuessResult(isSolved(matchedStrikes), matchedStrikes, matchedBalls);
    }

    private static boolean isSolved(int matchedStrikes) {
        return matchedStrikes == 3;
    }

    public int getMatchedStrikes(String guessNumber) {
        int ret = 0;
        for (int i = 0; i < guessNumber.length(); i++) {
            if (question.charAt(i) == guessNumber.charAt(i)) ret += 1;
        }
        return ret;
    }

    public int getMatchedBalls(String guessNumber) {
        int ret = 0;
        for (int i = 0; i < guessNumber.length(); i++) {
            for (int j = 0; j < guessNumber.length(); j++) {
                if (i == j) continue;
                if (guessNumber.charAt(i) == question.charAt(j)) ret += 1;
            }
        }
        return ret;
    }

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
}
