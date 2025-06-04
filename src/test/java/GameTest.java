import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    private void assertIllegalArgument(String number) {
        try {
            game.guess(number);
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void throwIllegalArgumentExceptionInvalidInput() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12a");
        assertIllegalArgument("116");
    }

    @Test
    void returnSolvedResultIfMatchedNumber() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("123"), true, 3, 0);
    }

    @Test
    void returnSolvedResultIfUnMatchedNumber() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("456"), false, 0, 0);
    }

    @Test
    void returnSolvedResult2Strikes0Ball() {
        generateQuestion("814");
        assertMatchedNumber(game.guess("854"), false, 2, 0);

        generateQuestion("173");
        assertMatchedNumber(game.guess("973"), false, 2, 0);

        generateQuestion("691");
        assertMatchedNumber(game.guess("681"), false, 2, 0);
    }

    @Test
    void returnSolvedResult1Strike20Ball() {
        generateQuestion("814");
        assertMatchedNumber(game.guess("418"), false, 1, 2);

        generateQuestion("198");
        assertMatchedNumber(game.guess("918"), false, 1, 2);
    }

    private void generateQuestion(String questionNumber) {
        game.question = questionNumber;
    }

    private static void assertMatchedNumber(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }
}