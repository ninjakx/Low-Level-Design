package CarRental.Model;

public class Location {
    String address;
    String city;
    String state;
    String country;
    int pincode;
    public Location(String address, String city, String state, String country, int pincode){
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }
    
}
