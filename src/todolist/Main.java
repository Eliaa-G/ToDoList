package todolist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Model model;
        
        // DE-SERIALIZATION
        try{
            FileInputStream fis = new FileInputStream("todo.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            model = (Model) ois.readObject();
        }
        catch(Exception err){
            model = new Model();
        }
        View view = new View(model);
        Controller controller = new Controller(model, view);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                view.setVisible(true);
            }
        });
    }
    
    // CLASS METHOD FOR SERIALIZATION
    public static void serialize(Model model){
        try{
            FileOutputStream fos = new FileOutputStream("todo.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(model);
            oos.close();
        }
        catch(IOException err){
            err.printStackTrace();
        }
    }
}