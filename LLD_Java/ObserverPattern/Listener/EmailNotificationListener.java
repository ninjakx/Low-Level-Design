package ObserverPattern.Listener;

import java.io.File;

public class EmailNotificationListener implements EventListener{
    private String email;
    public EmailNotificationListener(String email){
        this.email = email;
    }
    @Override
    public void update(String eventType, File file){
        System.out.printf("Email to %s : someone has performed %s operation on file: %s\n", email, eventType, file, file.getName());
    }
}
