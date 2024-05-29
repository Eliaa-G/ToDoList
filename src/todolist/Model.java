package todolist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        sortTasksByName();
        setChanged();
        notifyObservers();
    }
    
    public void progRemoveTask(int index){
        progTasks.remove(index);
        sortTasksByName();
        setChanged();
        notifyObservers();
    }
    
    public void compRemoveTask(int index){
        compTasks.remove(index);
        sortTasksByName();
        setChanged();
        notifyObservers();
    }
    
    public void completeTask(int index){
        compTasks.add(new Task(progTasks.get(index).getName(), progTasks.get(index).getCreationDate()));
        progTasks.remove(index);
        sortTasksByName();
        setChanged();
        notifyObservers();
    }
    
    public void unCompleteTask(int index){
        progTasks.add(new Task(compTasks.get(index).getName(), compTasks.get(index).getCreationDate()));
        compTasks.remove(index);
        sortTasksByName();
        setChanged();
        notifyObservers();
    }
    
    public void clearAllTasks(){
        progTasks.clear();
        compTasks.clear();
        setChanged();
        notifyObservers();
    }
    
    public void clearCompTasks(){
        compTasks.clear();
        setChanged();
        notifyObservers();
    }
    
    private void sortTasksByName(){
        Collections.sort(progTasks, new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        
        Collections.sort(compTasks, new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

    // GETTER
    public ArrayList<Task> getProgTasks() {
        return progTasks;
    }
    
    public ArrayList<Task> getCompTasks() {
        return compTasks;
    }
}
