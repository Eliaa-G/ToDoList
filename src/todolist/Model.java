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

    public ArrayList<Task> getProgTasks() {
        return progTasks;
    }
    
    public ArrayList<Task> getCompTasks() {
        return compTasks;
    }
    
    private void printList(){
        for (Task t : progTasks){
            System.out.println(t.getName());
        }
    }
}
