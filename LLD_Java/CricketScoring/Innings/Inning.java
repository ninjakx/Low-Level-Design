package CricketScoring.Innings;
import java.util.ArrayList;
import java.util.List;

import CricketScoring.MatchType;
import CricketScoring.Team.*;
import CricketScoring.Team.Player.Player;
public class Inning {
    Team battingTeam;
    Team bowlingTeam;
    MatchType matchType;
    List<Over> overs;

    public Inning(Team battingTeam, Team bowlingTeam, MatchType matchType){
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        overs = new ArrayList<>();
    }
    public void start(int runNeedToWin){
        try {
            battingTeam.chooseNextBatsMan();
        } catch (Exception e){
        }

    int noOfOvers = matchType.noOfOvers();
    for (int overNumber = 1; overNumber <= noOfOvers; overNumber++){
        bowlingTeam.chooseNextBowler(matchType.maxOverCountBowlers());
        Over over = new Over(overNumber, bowlingTeam.getCurrentBowler());
        overs.add(over);
        try {
            boolean won = over.startOver(battingTeam, bowlingTeam, runNeedToWin);
            if (won == true){
                break;
            }
        } catch (Exception e){
            break;
        }
        Player temp = battingTeam.getStriker();
        battingTeam.setStriker(battingTeam.getNonStriker());
        battingTeam.setNotStriker(temp);
    }
}
    public int getTotalRuns(){
        return battingTeam.getTotalRuns();
    }
}
