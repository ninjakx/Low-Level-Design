package ObserverPattern.Listener;

import java.io.File;

public class LogOpenListener implements EventListener{
    private File logfile;
    public LogOpenListener(String filePath){
        this.logfile = new File(filePath);
    }
    @Override
    public void update(String eventType, File file){
        System.out.printf("Save to %s : someone has performed %s operation on file: %s\n", logfile.getName(), eventType, file, file.getName());
    }
}