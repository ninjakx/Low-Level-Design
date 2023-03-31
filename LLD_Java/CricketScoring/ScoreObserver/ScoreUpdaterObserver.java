package CricketScoring.ScoreObserver;
import CricketScoring.Innings.*;

public interface ScoreUpdaterObserver {
    public void update(Ball ball);
}
