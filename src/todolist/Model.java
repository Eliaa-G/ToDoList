package todolist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable implements Serializable{
    private ArrayList<Task> progTasks;
    private ArrayList<Task> compTasks;

    // CONSTRUCTOR
    public Model() {
        progTasks = new ArrayList<>();
        compTasks = new ArrayList<>();
    }
    
    // METHODS
    public void newTask(String name){
        progTasks.add(new Task(name));
        setChanged();
        notifyObservers();
    }
    
    public void progRemoveTask(int index){
        progTasks.remove(index);
        setChanged();
        notifyObservers();
    }
    
    public void compRemoveTask(int index){
        compTasks.remove(index);
        setChanged();
        notifyObservers();
    }
    
    public void completeTask(int index){
        compTasks.add(new Task(progTasks.get(index).getName(), progTasks.get(index).getCreationDate()));
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

    // GETTER
    public ArrayList<Task> getProgTasks() {
        return progTasks;
    }
    
    public ArrayList<Task> getCompTasks() {
        return compTasks;
    }
}
