package CarRental;
import java.util.List;
import CarRental.Model.*;
public class VehicleRentalSystem {
    List<Store> storeList;
    List<User> userList;

    VehicleRentalSystem(List<Store> storeList, List<User> userList){
        this.storeList = storeList;
        this.userList = userList;
    }
    public Store getStore(Location location){
        // based on location, filter out
        return storeList.get(0);
    }
}
