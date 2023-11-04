# book my show
# User
# Theatre
# Hall
# Screen (movie running at what time)
# Seats - Seat Type
<!-- # Booking
# Order -->
# Payment - Card Type
# Notification -> invoice

# controller
SearchByLocation -> MovieController -> Location and all the movies listed
TheatreController -> Getmovies -> runnin on hall
BookService -> MovieController, GetMovies by hall, book movies by location -> theatre and hall


