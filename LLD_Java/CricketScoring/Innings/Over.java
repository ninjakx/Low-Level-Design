package CricketScoring.Innings;

import java.util.ArrayList;
import java.util.List;
import CricketScoring.Team.Player.*;
import CricketScoring.Team.*;

public class Over {
    int overNumber;
    List<Ball> balls;
    int extraBall;
    Player bowledBy;

    public Over(int overNumber, Player bowledBy) {
        this.overNumber = overNumber;
        this.balls = new ArrayList<>();
        this.bowledBy = bowledBy;
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runNeedToWin){
        int ballCount=1;
        while(ballCount<=6){
            Ball ball = new Ball(ballCount);
            ball.StartBowling(battingTeam, bowlingTeam, this);
            if (ball.ballType == BallType.NORMAL){
                balls.add(ball);
                ballCount++;
                if (ball.wicket != null){
                    battingTeam.getNextBatsMan();
                }
                if (runNeedToWin !=-1 && battingTeam.getTotalRuns() >= runNeedToWin){
                    battingTeam.setWinner(true);
                    return true;
                }
            } else {
                extraBall++;
            }
        }
        return false;
    }
}
