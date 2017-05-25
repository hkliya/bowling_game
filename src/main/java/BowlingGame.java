import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public static final int FRAME_COUNT = 10;
    private List<Frame> frames;

    public int getBowlingScore(String bowlingCode) {
        frames = parse(bowlingCode);
        return calculate();
    }

    private int calculate() {
        int score = 0;
        for (int index = 0; index < FRAME_COUNT; index++) {
            Frame frame = frames.get(index);
            int baseScore = frame.getScore();
            int extraScore = getExtraScore(index);
            score += baseScore + extraScore;
        }
        return score;
    }

    private ArrayList<Frame> parse(String bowlingCode) {
        String[] framesAndExtraBalls = bowlingCode.split("\\|\\|");
        String[] framesStr = framesAndExtraBalls[0].split("\\|");
        String[] extraBallsStr = framesAndExtraBalls[1].split("");
        ArrayList<Frame> frames = new ArrayList<Frame>();
        for (int index = 0; index < FRAME_COUNT; index++) {
            List<Integer> balls = new ArrayList<Integer>();
            balls.add(getBottleCount(framesStr[index]));
            frames.add(new Frame(balls));
        }
        for (String extraBall : extraBallsStr) {
            List<Integer> extraBalls = new ArrayList<Integer>();
            extraBalls.add(getBottleCount(extraBall));
            frames.add(new Frame(extraBalls));
        }
        return frames;
    }

    private Integer getBottleCount(String ballStr) {
        return 10;
    }

    private int getExtraScore(int index) {
        List<Integer> extraBalls = getExtraBalls(frames, index);
        return extraBalls.get(0) + extraBalls.get(1);
    }

    private List<Integer> getExtraBalls(List<Frame> frames, int index) {
        List<Integer> balls = new ArrayList<Integer>();
        balls.addAll(frames.get(index + 1).getBalls());
        balls.addAll(frames.get(index + 2).getBalls());
        return balls;
    }
}
