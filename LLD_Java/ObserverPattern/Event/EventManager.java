package Java.ObserverPattern.Event;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Java.ObserverPattern.Listener.*;

public class EventManager {
    // for a given event type(save, open) created listeners
    Map<String, List<EventListener>> listeners = new HashMap<>();
    // suscribe, unsuscribe, notify
    public EventManager(String... operations){ // save open
        for (String operation: operations){
            this.listeners.put(operation, new ArrayList<>());
        }
    }
    // eventType: open, save
    public void suscribe(String eventType, EventListener listener){
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }
    public void unsuscribe(String eventType, EventListener listener){
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }
    public void notify(String eventType, File file){
        List<EventListener> users = listeners.get(eventType);
        // notify all the listener
        for (EventListener listener: users){
            listener.update(eventType, file);
        }
    }
}
