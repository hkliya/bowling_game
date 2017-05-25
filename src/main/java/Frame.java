import java.util.List;

public class Frame {
    private List<Integer> balls;

    public Frame(List<Integer> balls) {
        this.balls = balls;
    }

    public int getScore() {
        return balls.get(0);
    }

    public int getFirstBall() {
        return balls.get(0);
    }


    public List<Integer> getBalls() {
        return balls;
    }
}
