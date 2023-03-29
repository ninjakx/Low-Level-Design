package Java.AbstractFactoryPattern;

// Abstract class: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class). 
abstract class Car{
    CarType model=null;
    Location location=null;
    Car(CarType model, Location location){
        this.model = model;
        this.location = location;
    }
    abstract void construct();

    CarType getModel(){
        return model;
    }

    void setModel(CarType model){
        this.model = model;
    }

    Location getLocation(){
        return location;
    }

    void setLocation(Location location){
        this.location = location;
    }

    @Override
    public String toString(){
        return "CarModel - " + model + " Location - " + location;
    } 

}
