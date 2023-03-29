package Java.BookMyShow.Model;

public class Location {
    int pincode;
    String address;
    String city;
    String state;
    String country;
    public Location(int pincode, String address, String city, String state, String country){
        this.pincode = pincode;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
    }
    @Override
    public boolean equals(Object obj){
        
        if(this == obj)
        return true;

        if(obj == null || obj.getClass()!= this.getClass())
        return false;

        // type casting of the argument. 
        Location location = (Location) obj;

        // comparing the state of argument with 
        // the state of 'this' Object.
        return (
            location.address.equals(this.address) &&
            location.city.equals(this.city)  && location.pincode == this.pincode &&
            location.state.equals(this.state) && location.country.equals(this.country)
        );
    }
    @Override
    public int hashCode()
    {
        return this.pincode;
    }
}
