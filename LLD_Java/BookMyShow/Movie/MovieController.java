package Java.BookMyShow.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Java.BookMyShow.Model.*;

public class MovieController {

    Map<Location, List<Movie>> locationVsMovies;
    List<Movie> allMovies;

    public MovieController(){
        locationVsMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }


    //ADD movie to a particular Location, make use of locationVsMovies map
    public void addMovie(Movie movie, Location location) {

        allMovies.add(movie);

        List<Movie> movies = locationVsMovies.getOrDefault(location, new ArrayList<>());
        movies.add(movie);
        locationVsMovies.put(location, movies);
    }


    public Movie getMovieByName(String movieName) {

        for(Movie movie : allMovies) {
            if((movie.getMovieName()).equals(movieName)) {
                return movie;
            }
        }
        return null;
    }


    public List<Movie> getMoviesByLocation(Location location) {
        return locationVsMovies.get(location);
    }
    //REMOVE movie from a particular location, make use of locationVsMovies map

    //UPDATE movie of a particular location, make use of locationVsMovies map

    //CRUD operation based on Movie ID, make use of allMovies list



}
