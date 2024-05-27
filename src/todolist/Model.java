package todolist;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable{
    private ArrayList<Task> progTasks;
    private ArrayList<Task> compTasks;

    public Model() {
        progTasks = new ArrayList<>();
        compTasks = new ArrayList<>();
    }
    
    public void newTask(String task){
        progTasks.add(new Task(task));
        setChanged();
        notifyObservers();
    }
    
    public void removeTask(int index){
        progTasks.remove(index);
        setChanged();
        notifyObservers();
    }
    
    public void completeTask(String task, int index){
        compTasks.add(new Task(task));
        progTasks.remove(index);
        setChanged();
        notifyObservers();
    }
    
    public void clearTasks(){
        progTasks.clear();
        compTasks.clear();
        setChanged();
        notifyObservers();
    }

    public ArrayList<Task> getProgTasks() {
        return progTasks;
    }
    
    public ArrayList<Task> getCompTasks() {
        return compTasks;
    }
}
