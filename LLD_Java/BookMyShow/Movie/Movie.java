package Java.BookMyShow.Movie;

public class Movie {
    int movieID;
    String movieName;
    int movieDurationInMin;

    public int getMovieID(){
        return movieID;
    }
    public void setMovieID(int movieID){
        this.movieID = movieID;
    }
    public String getMovieName(){
        return movieName;
    }
    public void setMovieName(String movieName){
        this.movieName = movieName;
    }
    public int getMovieDurationInMin(){
        return movieDurationInMin;
    }
    public void setMovieDurationInMin(int movieDurationInMin){
        this.movieDurationInMin = movieDurationInMin;
    }

}
