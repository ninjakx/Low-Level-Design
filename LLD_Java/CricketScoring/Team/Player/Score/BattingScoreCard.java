package Java.CricketScoring.Team.Player.Score;
import Java.CricketScoring.Team.*;
import Java.CricketScoring.Team.Player.*;
public class BattingScoreCard {
    int totalRun;
    int totalBallPlayed;
    int total4s;
    int total6s;
    double strikeRate;
    Wicket wicketDetails;
    public int getTotalRun() {
        return totalRun;
    }
    public void setTotalRun(int totalRun) {
        this.totalRun = totalRun;
    }
    public int getTotalBallPlayed() {
        return totalBallPlayed;
    }
    public void setTotalBallPlayed(int totalBallPlayed) {
        this.totalBallPlayed = totalBallPlayed;
    }
    public int getTotal4s() {
        return total4s;
    }
    public void setTotal4s(int total4s) {
        this.total4s = total4s;
    }
    public int getTotal6s() {
        return total6s;
    }
    public void setTotal6s(int total6s) {
        this.total6s = total6s;
    }
    public double getStrikeRate() {
        return strikeRate;
    }
    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }
    public Wicket getWicketDetails() {
        return wicketDetails;
    }
    public void setWicketDetails(Wicket wicketDetails) {
        this.wicketDetails = wicketDetails;
    }
    public Player outBy(Wicket wicket){
        if (wicketDetails==null){
            return null;
        } 
        return wicketDetails.getTakenby();
    }
}
