package Java.RideSharing.Strategy;

public interface PricingStrategy {
    Integer AMT_PER_KM = 20;
    public double calculateFare(int origin, int destination, int seats);
}
