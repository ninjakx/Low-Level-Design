package Java.CricketScoring.Team.Player;

import Java.CricketScoring.Team.Player.Score.BattingScoreCard;
import Java.CricketScoring.Team.Player.Score.BowlingScoreCard;

public class Player {
    String playerName;
    PlayerType playerType; // bowler, batter, wicket keeper
    public BattingScoreCard battingScoreCard;
    public BowlingScoreCard bowlingScoreCard;
    public String getPlayerName() {
        return playerName;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public BattingScoreCard getBattingScoreCard() {
        return battingScoreCard;
    }
    public BowlingScoreCard getBowlingScoreCard() {
        return bowlingScoreCard;
    }
    public Player(String playerName, PlayerType playerType) {
        this.playerName = playerName;
        this.playerType = playerType;
        this.battingScoreCard = new BattingScoreCard();
        this.bowlingScoreCard = new BowlingScoreCard();
    }
    public void printBattingScoreCard(){
        System.out.printf("\n======Batting Score ======\nPlayer Name: %s\nPlayer total run: %d\nPlayer 6s: %d\nPlayer 4s: %d\nPlayer Total Balls Played: %d\nPlayer out by: %s\n", playerName, battingScoreCard.getTotalRun(), battingScoreCard.getTotal6s(), battingScoreCard.getTotal4s(), battingScoreCard.getTotalBallPlayed(), (battingScoreCard.getWicketDetails()!=null)? battingScoreCard.getWicketDetails().getTakenby().getPlayerName(): null);
    }
    public void printBowlingScoreCard(){
        System.out.printf("\n======Bowling Score ======\nPlayer Name: %s\nPlayer total overs throw: %d\nPlayer total runs given: %d\nPlayer wickets taken: %d\n", playerName, bowlingScoreCard.getTotalOverSoFar(), bowlingScoreCard.getRunsMade(), bowlingScoreCard.getWicketsTaken());
    }
}
