package todolist;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Serializable {
    private String name;
    private String creationDate;
    private String completionDate;
    
    private Date date = new Date();
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy, HH:mm");

    public Task(String name) {
        this.name = name;
        creationDate = df.format(date);
    }
    
    public Task(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
        completionDate = df.format(date);
    }
    
    //GETTER & SETTER
    public String getName() {
        return name;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public String getCreationDate() {
        return creationDate;
    }
    
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setName(String name) {
        this.name = name;
    }
}
