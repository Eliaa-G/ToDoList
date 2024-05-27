package todolist;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String task;
    private String creationDate;
    private boolean completed;
    
    private Date date = new Date();
    private SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy, HH:mm");

    public Task(String task) {
        this.task = task;
        creationDate = df.format(date);
        completed = false;
    }
    
    
}
