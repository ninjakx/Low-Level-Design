package Java.FactoryPattern;

public class ShapeFactory {
    Shape getShape(String input){ // functio return shape object
        switch(input){
            case "CIRCLE":
                return new Circle();
            case "RECTANGULAR":
                return new Rectangle();
            default:
                return null;
        }
    }
}
