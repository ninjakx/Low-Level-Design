package Java.RideSharing.Strategy;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import Java.RideSharing.Model.*;

public class DriverMatchingStrategyImpl implements DriverMatchingStrategy {
    @Override
    public Optional<Driver> findDriver(Rider rider, List<Driver> drivers, int destination, int origin){
        // System.out.println("===>"+(drivers).size());
        Collections.shuffle(drivers);
        return drivers.stream().findAny();
    }
}
