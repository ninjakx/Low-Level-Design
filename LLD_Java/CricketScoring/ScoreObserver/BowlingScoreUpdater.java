package CricketScoring.ScoreObserver;
import CricketScoring.Innings.*;
import CricketScoring.Team.Player.*;

public class BowlingScoreUpdater implements ScoreUpdaterObserver{
    @Override
    public void update(Ball ball){
        Player bowler = ball.getBowledBy();
        int run = 0;
        if (ball.getBallNum()==6 && ball.getBallType()==BallType.NORMAL){
            int totalOver = bowler.getBowlingScoreCard().getTotalOverSoFar();
            bowler.getBowlingScoreCard().setTotalOverSoFar(totalOver+1);
        }

        if (ball.getRunType()==RunType.ONE){
            run = 1;
        } else if (ball.getRunType()==RunType.TWO){
            run = 2;
        } else if (ball.getRunType()==RunType.THREE){
            run = 3;
        } else if (ball.getRunType()==RunType.FOUR){
            run = 4;
        } else if (ball.getRunType()==RunType.SIX){
            run = 6;
        }
        int totalRun = bowler.bowlingScoreCard.getRunsMade();
        bowler.bowlingScoreCard.setRunsMade(totalRun+run);
        int wktsTaken = bowler.bowlingScoreCard.getWicketsTaken();
        if (ball.getWicket()!=null){
            bowler.bowlingScoreCard.setWicketsTaken(wktsTaken+1);
        }
        if (ball.getBallType()==BallType.NOBALL){
            int noBallCount = bowler.bowlingScoreCard.getNoBallCount();
            bowler.bowlingScoreCard.setNoBallCount(noBallCount);
        }
        if (ball.getBallType()==BallType.WIDE){
            int wideBallCount = bowler.bowlingScoreCard.getWideBallCount();
            bowler.bowlingScoreCard.setWideBallCount(wideBallCount);
        }
    }  

}
