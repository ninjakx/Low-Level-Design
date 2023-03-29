package Java.CricketScoring.Innings;
import java.util.ArrayList;
import java.util.List;

import Java.CricketScoring.ScoreObserver.*;
import Java.CricketScoring.Team.*;
import Java.CricketScoring.Team.Player.*;

public class Ball {
    int ballNum;
    BallType ballType;
    RunType runType;
    Player playedBy;
    Player bowledBy;
    Wicket wicket;

    List<ScoreUpdaterObserver> scoreUpdaterObserverList;
    public Ball(int ballNum){
        this.ballNum = ballNum;
        this.scoreUpdaterObserverList = new ArrayList<>();
        scoreUpdaterObserverList.add(new BowlingScoreUpdater());
        scoreUpdaterObserverList.add(new BattingScoreUpdater());

    }
    public RunType getRunType() {
        return runType;
    }
    public Player getPlayedBy() {
        return playedBy;
    }
    public Player getBowledBy() {
        return bowledBy;
    }
    public void StartBowling(Team battingTeam, Team bowlingTeam, Over over){
        playedBy = battingTeam.getStriker();
        bowledBy = over.bowledBy;
        ballType = BallType.NORMAL; 
        
        if (isWicketTaken()){
            runType = RunType.ZERO;
            wicket = new Wicket(WicketType.BOLD, bowledBy, over, this);
            battingTeam.setStriker(null); // striker gone
        } else {
            runType = genRunType();
            if (runType==RunType.ONE || runType==RunType.THREE){
                Player temp = battingTeam.getStriker();
                battingTeam.setStriker(battingTeam.getNonStriker());
                battingTeam.setNotStriker(temp);
            }
        }

        //update player scoreboard
        notifyUpdaters(this);
    }

    private void notifyUpdaters(Ball ballDetails){

        for(ScoreUpdaterObserver observer : scoreUpdaterObserverList) {
            observer.update(ballDetails);
        }
    }


    private RunType genRunType(){
        double val = Math.random();
        if (val<=0.2){
            return RunType.ONE;
        } else if (val>=0.3 && val<0.6){
            return RunType.TWO;
        } else if (val>=0.6 && val<=0.8){
            return RunType.FOUR;
        }
        return RunType.SIX;
    }

    private boolean isWicketTaken(){
        if (Math.random()<0.2){
            return true;
        }
        return false;
    }
    public Wicket getWicket() {
        return wicket;
    }
    public int getBallNum() {
        return ballNum;
    }
    public BallType getBallType() {
        return ballType;
    }
}
