package AirlineTicketBooking.entity;

public class Passenger {
    String address; // Address -> object
    Integer phoneNum;
    String emailID;
    String name;
    public Passenger(String address, Integer phoneNum, String emailID, String name) {
        this.address = address;
        this.phoneNum = phoneNum;
        this.emailID = emailID;
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getEmailID() {
        return emailID;
    }
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Passenger [address=" + address + ", phoneNum=" + phoneNum + ", emailID=" + emailID + ", name=" + name
                + "]";
    }
}
