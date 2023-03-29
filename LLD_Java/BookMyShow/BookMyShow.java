package Java.BookMyShow;

import Java.BookMyShow.Movie.Movie;
import Java.BookMyShow.Movie.MovieController;
import Java.BookMyShow.Theatre.TheatreController;
import Java.BookMyShow.Model.*;
import Java.BookMyShow.Theatre.*;
import Java.BookMyShow.Booking.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheatreController theaterController;
    BookMyShow(){
        movieController = new MovieController();
        theaterController = new TheatreController();       
    }

    private void createBooking(Location location, String movieName){

        //1. search movie by my location
        List<Movie> movieList = movieController.getMoviesByLocation(location);

        //2. select the movie which you want to see. i want to see Baahubali
        Movie targetMovie = null;
        for (Movie movie: movieList){
            if (movie.getMovieName().equals(movieName)){
                targetMovie = movie;
            }
        }

        //3. get all show of this movie in given location
        Map<Theatre, List<Show>> showsTheatreWise = theaterController.getAllShow(targetMovie, location);

        //4. select the particular show user is interested in
        List<Show> runningShows = null;
        Show interestedShow = null;
        for(Map.Entry<Theatre,List<Show>> entry : showsTheatreWise.entrySet()) {
            runningShows = entry.getValue();
            interestedShow = runningShows.get(0);
            break;
        }

        // Map.Entry<Theatre,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        // List<Show> runningShows = entry.getValue();
        // Show interestedShow = runningShows.get(0);

        //5. select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if(screenSeat.getSeatID() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }

    private void createMovies() {

        Location lucknow = createLocation(123, "Jankipuram", "Lucknow", "UP", "INDIA");
        Location bangalore = createLocation(453, "Whitefield", "Bangalore", "Karnatak", "INDIA");
        //create Movies1
        Movie movie1 = new Movie();
        movie1.setMovieID(1);
        movie1.setMovieName("movie1");
        movie1.setMovieDurationInMin(128);

        //create Movies2
        Movie movie2 = new Movie();
        movie2.setMovieID(2);
        movie2.setMovieName("movie2");
        movie2.setMovieDurationInMin(180);


        //add movies against the cities
        movieController.addMovie(movie1, bangalore);
        movieController.addMovie(movie1, lucknow);
        movieController.addMovie(movie2, bangalore);
        movieController.addMovie(movie2, lucknow);
    }


    private Location createLocation(int pincode, String address, String city, String state, String country){
        Location location = new Location(pincode, address, city, state, country);
        return location;
    }

    private List<Seat> createSeats(){
        List<Seat> seats = new ArrayList<>();

        // 1 to 30
        for (int i =0; i<=30; i++){
            Seat seat = new Seat();
            seat.setSeatType(SeatType.BASIC);
            seat.setSeatID(i);
            seats.add(seat);
        }
        // 31 to 60
        for (int i = 31; i<=60; i++){
            Seat seat = new Seat();
            seat.setSeatType(SeatType.PREMIUM);
            seat.setSeatID(i);
            seats.add(seat);
        }
        // 60 to 100
        for (int i = 60; i<=100; i++){
            Seat seat = new Seat();
            seat.setSeatType(SeatType.GOLD);
            seat.setSeatID(i);
            seats.add(seat);
        }
        return seats;
    }

    private List<Screen> createScreen(){
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenID(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);

        return screens;

    }

    private Show createShow(int showID, Screen screen, Movie movie, int showStartTime){
        Show show = new Show();
        show.setShowID(showID);
        show.setToTimeStamp(showStartTime);
        show.setMovie(movie);
        show.setScreen(screen);
        return show;
    }

    private void createTheatre() {

        Movie movie1 = movieController.getMovieByName("movie1");
        Movie movie2 = movieController.getMovieByName("movie2");
         

        Location lucknow = createLocation(123, "Jankipuram", "Lucknow", "UP", "INDIA");
        Location bangalore = createLocation(453, "Whitefield", "Bangalore", "Karnatak", "INDIA");
     
        Theatre inox = new Theatre();
        inox.setScreens(createScreen());
        inox.setTheatreID(0);
        inox.setLocation(bangalore);

        Show inoxShowMorning = createShow(1, inox.getScreens().get(0), movie1, 10);
        Show inoxShowEvening = createShow(2, inox.getScreens().get(0), movie2, 18);

    
        List<Show> inoxShows = new ArrayList<>();
        inoxShows.add(inoxShowEvening);
        inoxShows.add(inoxShowMorning);
        inox.setShows(inoxShows);

        theaterController.addTheatre(bangalore, inox);
    }


    private void initialize() {

        //create movies
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();
    }

    public static void main(String args[]){
        BookMyShow bookMyShow = new BookMyShow();
        
        bookMyShow.initialize();
        Location bangalore = bookMyShow.createLocation(453, "Whitefield", "Bangalore", "Karnatak", "INDIA");
        bookMyShow.createBooking(bangalore, "movie1");

    }

}
