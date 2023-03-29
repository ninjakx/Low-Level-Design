package Java.BookMyShow.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Java.BookMyShow.Model.*;
import java.util.Map;
import Java.BookMyShow.Movie.*;

public class TheatreController {
    public Map<Location, List<Theatre>> cityTheatre;
    public List<Theatre> theatreList;

    public TheatreController(){
        cityTheatre = new HashMap<>();
        theatreList = new ArrayList<>();
    }

    public void addTheatre(Location location, Theatre theatre){
        theatreList.add(theatre);
        List<Theatre> theatres = cityTheatre.getOrDefault(location, new ArrayList<>());
        theatres.add(theatre);
        cityTheatre.put(location, theatres);
    }

    public Map<Theatre, List<Show>> getAllShow(Movie movie, Location location) {

        //get all the theater of this location

        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();

        List<Theatre> theatres = cityTheatre.get(location);

        //filter the theatres which run this movie

        for(Theatre theatre : theatres) {

            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();


            for(Show show : shows) {
                if(show.movie.getMovieID() == movie.getMovieID()) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }

        return theatreVsShows;
    }

}
