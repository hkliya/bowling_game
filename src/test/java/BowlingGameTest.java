import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {

    @Test
    public void test_all_strike() throws Exception {
        assertEquals(300, new BowlingGame().getBowlingScore("X|X|X|X|X|X|X|X|X|X||XX"));
    }

    @Test
    public void test_second_spare() throws Exception {
        assertEquals(150, new BowlingGame().getBowlingScore("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5"));
    }

    @Test
    public void test_second_miss() throws Exception {
        assertEquals(90, new BowlingGame().getBowlingScore("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||"));
    }

    @Test
    public void test_other_situation() throws Exception {
        String bowlingCode = "X|7/|9-|X|-8|8/|-6|X|X|X||81";      //167
        assertEquals(new BowlingGame().getBowlingScore(bowlingCode), 167);

    }
}

