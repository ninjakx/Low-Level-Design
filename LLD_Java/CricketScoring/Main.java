package CricketScoring;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import CricketScoring.Team.Team;
import CricketScoring.Team.Player.Player;
import CricketScoring.Team.Player.PlayerBattingController;
import CricketScoring.Team.Player.PlayerBowlingController;
import CricketScoring.Team.Player.PlayerType;
public class Main {
    // https://stackoverflow.com/a/13830541/6660373
    public static void main(String args []){
        // https://stackoverflow.com/a/11253710/6660373
        // Team teamA = new Team("India");
        // Pair p1 = Pair.of("P1", PlayerType.ALLROUNDER);
        // playerA.add(p1);

        Main ob = new Main();

        Team teamA = ob.addTeam("India");
        Team teamB = ob.addTeam("SriLanka");

        MatchType matchType = new T20MatchType();
        Match match = new Match(teamA, teamB, null, "SMS STADIUM", matchType);
        match.startMatch();

    }


    private Team addTeam(String name) {

        Queue<Player> players = new LinkedList<>();

        Player p1 = addPlayer(name+"1", PlayerType.ALLROUNDER);
        Player p2 = addPlayer(name+"2", PlayerType.ALLROUNDER);
        Player p3 = addPlayer(name+"3", PlayerType.ALLROUNDER);
        Player p4 = addPlayer(name+"4", PlayerType.ALLROUNDER);
        Player p5 = addPlayer(name+"5", PlayerType.ALLROUNDER);
        Player p6 = addPlayer(name+"6", PlayerType.ALLROUNDER);
        Player p7 = addPlayer(name+"7", PlayerType.ALLROUNDER);
        Player p8 = addPlayer(name+"8", PlayerType.ALLROUNDER);
        Player p9 = addPlayer(name+"9", PlayerType.ALLROUNDER);
        Player p10 = addPlayer(name+"10", PlayerType.ALLROUNDER);
        Player p11 = addPlayer(name+"11", PlayerType.ALLROUNDER);

        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);
        players.add(p6);
        players.add(p7);
        players.add(p8);
        players.add(p9);
        players.add(p10);
        players.add(p11);

        List<Player> bowlers = new ArrayList<>();
        bowlers.add(p8);
        bowlers.add(p9);
        bowlers.add(p10);
        bowlers.add(p11);

        Team team = new Team(name);
        team.setPlayerList(players);

        PlayerBowlingController bowlerController = team.getBowlingController();
        bowlerController.setBowlerList(bowlers);
        team.setBowlingController(bowlerController);

        PlayerBattingController battingController = team.getBattingController();
        battingController.setPlayerInQueue(players);
        team.setBattingController(battingController);

        return team;

    }

    private Player addPlayer(String name, PlayerType playerType) {
        Player player = new Player(name, playerType);
        return player;
    }
}
