package Java.AbstractFactoryPattern;

public class DEFAULTCarFactory {
    public static Car buildCar(CarType model){
        Car car = null;
        switch(model){
            case MICRO:
                car = new MicroCar(Location.DEFAULT);
                break;
            case MINI:
                car = new MiniCar(Location.DEFAULT);
                break;
            case LUXURY:
                car = new LuxuryCar(Location.DEFAULT);
                break;
            default:
                break;  
        }
        return car;
    }
}

