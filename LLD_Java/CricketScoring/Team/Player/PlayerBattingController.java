package CricketScoring.Team.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PlayerBattingController {
    Queue<Player> playerInQueue; // waiting to play
    Player striker;
    Player nonStriker;
    List<Player> batsmanList;

    public List<Player> getBatsmanList() {
        return batsmanList;
    }
    public PlayerBattingController() {
        playerInQueue = new ArrayDeque<>();
        batsmanList = new ArrayList<>();
    }
    public Player getStriker() {
        return striker;
    }
    public void setStriker(Player striker) {
        this.striker = striker;
    }
    public Player getNonStriker() {
        return nonStriker;
    }
    public void setNonStriker(Player nonStriker) {
        this.nonStriker = nonStriker;
    }
    public void addPlayerInQueue(Player player){
        playerInQueue.add(player);
    }
    public Queue<Player> getPlayerInQueue() {
        return playerInQueue;
    }
    public void setPlayerInQueue(Queue<Player> playerInQueue) {
        this.playerInQueue = playerInQueue;
    }
    public void getNextPlayer(){
        if (playerInQueue.isEmpty()){
            throw new RuntimeException("Can't retrieve players");
        }
        if (striker==null){
            striker = playerInQueue.poll();
            batsmanList.add(striker);
        }
        if (nonStriker==null){
            nonStriker = playerInQueue.poll();
            batsmanList.add(nonStriker);
        }
    }


    
}
