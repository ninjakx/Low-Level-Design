package Java.AbstractFactoryPattern;

public class MiniCar extends Car {
    MiniCar(Location location){
        super(CarType.MINI, location);
        construct();
    }
    @Override
    protected void construct(){
        System.out.println("Connecting to Mini Car");
    }
}
