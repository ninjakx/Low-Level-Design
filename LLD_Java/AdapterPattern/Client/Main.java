package Java.AdapterPattern.Client;
// main function call

import java.util.Scanner;
import Java.AdapterPattern.Adaptee.Adaptee;
import Java.AdapterPattern.Adapter.AdapterInterface;
import Java.AdapterPattern.Adapter.AdapterImpl;

public class Main {
    public static void main(String args[]){
        AdapterInterface adapterInterface =  new AdapterImpl(new Adaptee());
        Scanner in = new Scanner(System.in);
        double wtKG = in.nextDouble(); 
        System.out.printf("Get Weight in Pound: KG to Pound: %.2f\n", adapterInterface.getWeightInPound(wtKG));
    }
}
