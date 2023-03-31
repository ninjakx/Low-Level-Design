package RideSharing.Strategy;
import java.util.List;
import java.util.Optional;

import RideSharing.Model.*;
public interface DriverMatchingStrategy {
    public Optional<Driver> findDriver(Rider rider, List<Driver> drivers, int destination, int origin);
}
