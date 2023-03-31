package AbstractFactoryPattern;

public class CarFactory {
    private CarFactory(){

    }
    public static Car buildCar(CarType type){
        // default value
        Car car = null;
        Location location = Location.INDIA;
        switch(location){
            case USA:
                car = USACarFactory.buildCar(type);
                break;
            case INDIA:
                car = INDIACarFactory.buildCar(type);
                break;
            default:
                car = DEFAULTCarFactory.buildCar(type);
        }
        return car;
    }
}
