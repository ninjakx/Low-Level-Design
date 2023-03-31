package RideSharing.Strategy;

public class PricingStrategyImpl implements PricingStrategy{
    @Override
    public double calculateFare(int origin, int destination, int seats){
        // To Do plan strategy
        return AMT_PER_KM*(destination-origin)*seats;
    }
}
