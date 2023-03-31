package CricketScoring;

import java.util.ArrayList;

import CricketScoring.Team.*;
import java.util.Date;
import java.util.List;
import CricketScoring.Innings.*;

public class Match {
    Team teamA;
    Team teamB;
    Date date;
    String venue;
    List<Inning> inningDet;
    MatchType matchType;
    Team tossWinner; // team go first
    public Match(Team a, Team b, Date date, String venue, MatchType matchType) {
        teamA = a;
        teamB = b;
        this.date = date;
        this.venue = venue;
        this.inningDet = new ArrayList<>(2);

        this.matchType = matchType;
    }

    Team toss(Team x, Team y){
        if(Math.random() < 0.5) {
            return x;
        } else {
            return y;
        }
    }
    // start match 
    // inning will have no of overs
    public  void startMatch(){
        tossWinner = toss(teamA, teamB); // chooses batting first
        for (int inning = 1; inning<=2; inning++){
            Team battingTeam, bowlingTeam;
            Inning inningDetails;
            battingTeam = tossWinner;
            bowlingTeam = tossWinner.getTeamName().equals(teamA.getTeamName())? teamB : teamA;
            if (inning ==1){
                battingTeam = tossWinner;
                bowlingTeam = tossWinner.getTeamName().equals(teamA.getTeamName())? teamB: teamA;   
                inningDetails = new Inning(battingTeam, bowlingTeam, matchType);  
                inningDetails.start(-1);
            } else {
                battingTeam = tossWinner;
                bowlingTeam = tossWinner.getTeamName().equals(teamA.getTeamName())? teamB: teamA;   
                inningDetails = new Inning(battingTeam, bowlingTeam, matchType);  
                inningDetails.start(inningDet.get(0).getTotalRuns());
                if (bowlingTeam.getTotalRuns() > battingTeam.getTotalRuns()){
                    bowlingTeam.setWinner(true); 
                }
            }
            inningDet.add(inningDetails);
            // Display score
            System.out.println("INNING "+inning+" -- total Run: "+battingTeam.getTotalRuns());
            System.out.println("---Batting Score: "+battingTeam.getTeamName() + "---");
            battingTeam.printBattingScoreCard();

            System.out.println();
            
            System.out.println("---Bowling Score: "+bowlingTeam.getTeamName() + "---");
            bowlingTeam.printBowlingScoreCard();
            System.out.println();
        }
        if (teamA.isWinner()){
            System.out.println("---Winner---"+teamA.getTeamName());
        } else {
            System.out.println("---Winner---"+teamB.getTeamName());
        }
    }
}
