import java.util.List;

public class Frame {
    private List<Integer> balls;

    public Frame(List<Integer> balls) {
        this.balls = balls;
    }

    public int getFirstBall() {
        return balls.get(0);
    }


    public List<Integer> getBalls() {
        return balls;
    }

    public int getExtraBallCount() {
        if (isStrike()) {
            return 2;
        }
        if (isSpare()) {
            return 1;
        }
        return 0;
    }

    private boolean isSpare() {
        return getScore() == 10;
    }

    public int getScore() {
        int sum = 0;
        for (Integer ball : balls) {
            sum += ball;
        }
        return sum;
    }

    private boolean isStrike() {
        return balls.get(0) == 10;
    }
}
