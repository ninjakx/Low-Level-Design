package ObserverPattern.Editor;
import java.io.File;
import ObserverPattern.Event.*;
public class Editor {
    private File file;
    public EventManager events;
    public Editor(){
        this.events = new EventManager("open", "save");
    }
    public void openFile(String filePath){
        this.file = new File(filePath);
        events.notify("open", file);
    }
    public void saveFile() throws Exception{
        if (this.file!=null){
            events.notify("save", file);
        } else {
            throw new Exception("Please open a valid file");
        }
    }
}
