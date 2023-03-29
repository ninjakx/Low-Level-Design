package Java.RideSharing.Model;

import java.util.UUID;

public class Rider {
    // static int counter =0;
    // private int id;
    private String id;
    private String name;

    public Rider(String name) {
        // this.id = counter;
        this.id = UUID.randomUUID().toString();
        // counter++;
        this.name = name;
    }
    public String getID() {
        return id;
    }
    public String getName() {
        return name;
    }
}
