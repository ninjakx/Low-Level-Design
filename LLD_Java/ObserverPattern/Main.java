package ObserverPattern;

import ObserverPattern.Editor.Editor;
import ObserverPattern.Listener.EmailNotificationListener;
import ObserverPattern.Listener.LogOpenListener;

public class Main {
    public static void main(String[] args){
        Editor editor = new Editor();
        editor.events.suscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.suscribe("save", new EmailNotificationListener("email@gmail.com"));

        try{
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
