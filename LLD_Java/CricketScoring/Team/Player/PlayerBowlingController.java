package CricketScoring.Team.Player;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerBowlingController {
    Deque<Player> bowlerList;
    Map<Player, Integer> bowlerVsOverCount;
    Player currentBowler;

    public PlayerBowlingController() {
        bowlerList = new ArrayDeque<>(); 
        bowlerVsOverCount  = new HashMap<>();
    }
    // using add will allow you to use an object that implements Queue instead, since add is part of both interfaces, whereas addLast is only part of Dequeue.
    public void setBowlerList(List<Player> bowlerList){
        for (Player bowler: bowlerList){
            bowlerVsOverCount.put(bowler, 0);
            this.bowlerList.addLast(bowler);
        }  
    }

    public Deque<Player> getBowlerList(){
        return bowlerList;
    }

    public void getNextBowler(int maxOverAllowedPerBowler){
        Player bowler = bowlerList.poll();
        if (bowlerVsOverCount.get(bowler)==maxOverAllowedPerBowler-1){
            currentBowler = bowler;
        } else {
            currentBowler = bowler;
            bowlerList.addLast(bowler);
            // for this player
            int currentOverCount = bowlerVsOverCount.get(bowler);
            bowlerVsOverCount.put(bowler, currentOverCount+1);
        }
    }
    public Player getCurrentBowler() {
        return currentBowler;
    } 
}
