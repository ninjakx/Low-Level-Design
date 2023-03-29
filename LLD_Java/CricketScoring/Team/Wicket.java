package Java.CricketScoring.Team;
import Java.CricketScoring.Team.Player.*;
import Java.CricketScoring.Innings.*;
public class Wicket {
    WicketType wicketType;
    Player takenby;
    Over over;
    Ball ball;

    public Wicket(WicketType wicketType, Player takenby, Over over, Ball ball) {
        this.wicketType = wicketType;
        this.takenby = takenby;
        this.over = over;
        this.ball = ball;
    }

    public Player getTakenby() {
        return takenby;
    }
    public Over getOver() {
        return over;
    }
    public Ball getBall() {
        return ball;
    }
}
