public class GuessResult {
    public boolean solved;
    public int strikes;
    public int balls;

    public GuessResult(boolean solved, int strikes, int balls) {
        this.solved = solved;
        this.strikes = strikes;
        this.balls = balls;
    }
}
