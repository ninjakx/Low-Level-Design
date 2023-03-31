package AdapterPattern.Adaptee;

public class Adaptee implements AdapteeInterface {
    @Override
    public double getWeightInKG(double weight){
        return weight;
    }
}
