package Java.CricketScoring.Team;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import Java.CricketScoring.Team.Player.*;

public class Team {
    String teamName;
    Queue<Player> playerList;
    List<Player> bench;
    PlayerBattingController battingController;
    PlayerBowlingController bowlingController;
    boolean isWinner;

    public Team(String teamName){
        this.teamName = teamName;
        this.playerList= new ArrayDeque<>(); 
        this.bench = new ArrayList<>();
        this.battingController = new PlayerBattingController();
        this.bowlingController = new PlayerBowlingController();
    }

    public void chooseNextBatsMan() throws Exception{
        battingController.getNextPlayer();
    }

    public void chooseNextBowler(int maxOverCountPerBowler){
        bowlingController.getNextBowler(maxOverCountPerBowler);
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Queue<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(Queue<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getBench() {
        return bench;
    }

    public void setBench(List<Player> bench) {
        this.bench = bench;
    }

    public PlayerBattingController getBattingController() {
        return battingController;
    }

    public void setBattingController(PlayerBattingController battingController) {
        this.battingController = battingController;
    }

    public PlayerBowlingController getBowlingController() {
        return bowlingController;
    }

    public void setBowlingController(PlayerBowlingController bowlingController) {
        this.bowlingController = bowlingController;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }
    public boolean isWinner(boolean isWinner) {
        return isWinner;
    }
    public int getTotalRuns(){
        int totalRun = 0;
        for (Player player: battingController.getBatsmanList()){
            totalRun += player.battingScoreCard.getTotalRun();
        }
        return totalRun;
    }

    public Player getStriker(){
        return battingController.getStriker();
    }
    public void setStriker(Player batsman){
        battingController.setStriker(batsman);
    }
    public Player getNonStriker(){
        return battingController.getNonStriker();
    }
    public void setNotStriker(Player batsman){
        battingController.setNonStriker(batsman);
    }
    public void getNextBatsMan(){
        battingController.getNextPlayer();
    }
    public Player getCurrentBowler() {
        return bowlingController.getCurrentBowler();
    }
    public void printBattingScoreCard(){
        for (Player player: battingController.getBatsmanList()) {
            if (player.getBattingScoreCard().getTotalRun()>0)
                player.printBattingScoreCard();
        }      
    }
    public void printBowlingScoreCard(){
        for (Player player: bowlingController.getBowlerList()) {
            if (player.bowlingScoreCard.getTotalOverSoFar()>0)
                player.printBowlingScoreCard();
        }      
    }
}
