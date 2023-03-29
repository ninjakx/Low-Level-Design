package Java.AdapterPattern.Adapter;
import Java.AdapterPattern.Adaptee.AdapteeInterface;

public class AdapterImpl implements AdapterInterface{
    AdapteeInterface adapteeInterface;
    public AdapterImpl(AdapteeInterface adapteeInterface){
        this.adapteeInterface = adapteeInterface;
    }
    @Override
    public double getWeightInPound(double weight){
        
        double wtInKG = adapteeInterface.getWeightInKG(weight);
        double wtInPound = wtInKG/0.45;
        return wtInPound;
    }
}
