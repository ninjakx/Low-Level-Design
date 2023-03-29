package Java.BookMyShow.Booking;
import java.util.ArrayList;
import java.util.List;
import Java.BookMyShow.Theatre.*;
public class Booking {
    static int counter=0;
    int bookID;
    List<Seat> bookedSeats = new ArrayList<>();
    Show show; // it will have movie and timmings(start, end)
    Payment payment;

    public int getBookID(){
        return bookID;
    }
    public void setBookID(){
        this.bookID = counter;
        counter+=1;
    }
    public Show getShow(){
        return show;
    }
    public void setShow(Show show){
        this.show=show;
    }
    public List<Seat> getBookedSeats(){
        return bookedSeats;
    }
    public void setBookedSeats(List<Seat> bookedSeats){
        this.bookedSeats=bookedSeats;
    }
    public Payment getPayment(){
        return payment;
    }
    public void setPayment(Payment payment){
        this.payment=payment;
    }
}
