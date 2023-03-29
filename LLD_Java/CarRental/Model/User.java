package Java.CarRental.Model;

public class User {
    int userID;
    int drivingLicense;
    String userName;

    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public int getDrivingLicense(){
        return drivingLicense;
    }
    public void setDrivingLicense(int drivingLicense){
        this.drivingLicense = drivingLicense;
    }
}
