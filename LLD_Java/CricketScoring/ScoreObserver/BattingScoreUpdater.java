package CricketScoring.ScoreObserver;

import CricketScoring.Innings.*;
import CricketScoring.Team.Player.*;

public class BattingScoreUpdater implements ScoreUpdaterObserver{
    @Override
    public void update(Ball ball){
        int run = 0;
        Player batsman = ball.getPlayedBy();

        if (ball.getRunType()==RunType.ONE){
            run = 1;
        } else if (ball.getRunType()==RunType.TWO){
            run = 2;
        } else if (ball.getRunType()==RunType.THREE){
            run = 3;
        } else if (ball.getRunType()==RunType.FOUR){
            run = 4;
            int total4s = batsman.battingScoreCard.getTotal4s();
            batsman.battingScoreCard.setTotal4s(total4s+1);
        } else if (ball.getRunType()==RunType.SIX){
            run = 6;
            int total6s = batsman.battingScoreCard.getTotal6s();
            batsman.battingScoreCard.setTotal6s(total6s+1);
        }
        int totalRun = batsman.battingScoreCard.getTotalRun();
        batsman.battingScoreCard.setTotalRun(totalRun+run);
        if (ball.getWicket()!=null){
            batsman.battingScoreCard.setWicketDetails(ball.getWicket());
        }
    }
}
