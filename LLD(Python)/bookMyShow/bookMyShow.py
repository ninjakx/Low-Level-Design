from Controller.MovieController import MovieController
from Controller.TheatreController import TheatreController
from Model.Movie import Movie
from Model.Location import Location
from Model.Theatre import Theatre
from Model.Hall import Hall
from Model.Seat import Seat
from Model.Show import Show
from Model.Booking import Booking

from Enums.SeatType import SeatType

class BookMyShow:
    def __init__(self):
        # call controllers
        self.movieController = MovieController()
        self.theatreController = TheatreController()

    def createSeats(self)->list:
        seats = []
        for i in range(50):
            if (i<20):
                seat = Seat()
                seat.setSeatID(i)
                seat.setSeatType(SeatType.SILVER)
                seat.setRowno(i)
            elif (i>=20 and i<=40):
                seat = Seat()
                seat.setSeatID(i)
                seat.setSeatType(SeatType.GOLD)
                seat.setRowno(i)     
            else:    
                seat = Seat()
                seat.setSeatID(i+100)
                seat.setSeatType(SeatType.PLATINUM)
                seat.setRowno(i) 
            seats.append(seat)
        return seats

    def createShow(self, hall, movie, startTime, endTime):
        show = Show()
        show.setMovie(movie)
        show.setHall(hall)
        show.setStartTime(startTime)
        show.setEndTime(endTime)   
        return show   

    def createTheatre(self):
        avengers = self.movieController.getMovieByName("Avengers")
        rchock = Location("Rajiv Chock")
        delhi = Location("Delhi")
        inox = Theatre()

        inox.setAddress(rchock)
        inox.setCity(delhi)
        inoxHall1 = Hall("inoxHall1")
        # set seats for inoxHall1
        inoxHall1.setSeats(self.createSeats())
        inox.setHalls(inoxHall1)

        # inox.setMovieList(avengers)
        
        # add show
        inoxMorningShow = self.createShow(inox.getHalls()[0], avengers, 10, 20)
        inox.setShows(inoxMorningShow)
        self.theatreController.setTheatreByCity(delhi, inox)
        self.theatreController.setTheatreList(inox)

    def createMovies(self):
        avengers = Movie()
        avengers.setMovieName("Avengers")
        avengers.setMovieDuration(150)

        batman = Movie()
        batman.setMovieName("Batman")
        batman.setMovieDuration(180)

        delhi = Location("Delhi")
        mumbai = Location("Mumbai")
        self.movieController.addMovie(delhi, avengers)
        self.movieController.addMovie(mumbai, batman)

    def createBooking(self, city, movieName):
        # 1) Get movies by Location
        # 2) select the movies you want to setEndTime
        # 3) select the theatre you want to see the movie at
        # 4) select the show (slot at which you want to see the movie)
        # 5) see the available seats
        # 6) book the seat if you can book
        # 7) do the payment and get the receipt

        movieList = self.movieController.getMoviesByCity(city)
        desiredMovie = None
        for movie in movieList:
            if movie.getMovieName()==movieName :
                desiredMovie = movie
        
        desiredShow = None
        for theatre in self.theatreController.getTheatreList():
            for show in theatre.getShows():
                if show.getMovie().getMovieName()==desiredMovie.getMovieName():
                    desiredShow = show

        pickedSeat = 10
        if pickedSeat not in desiredShow.getBookedSeats():
            for seat in desiredShow.getHall().getSeats():
                if pickedSeat != seat.getSeatID():
                    pass
                else:
                    show.setBookedSeats(pickedSeat)
                    booking = Booking()
                    booking.setBookedSeats(pickedSeat)
                    booking.setShow(desiredShow)
                    booking.setBookedSeats(seat)
                    print("BOOKING IS SUCCESSFUL")
        else:
            print("SEAT IS ALREADY BOOKED")
                

    def initialize(self):
        self.createMovies()
        self.createTheatre()
        
if __name__ == '__main__':
    bookmyshow = BookMyShow()
    bookmyshow.initialize()
    delhi = Location("Delhi")
    bookmyshow.createBooking(delhi, "Avengers")

    # bookmyshow.createMovies()
    # bookmyshow.createTheatre()