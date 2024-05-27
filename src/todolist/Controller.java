package todolist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        
        view.btnAddListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(null, "Enter task name:", "New Task", 3);
                if (name == null || name.equals(""));
                else{
                    model.newTask(name);
                }
            }
        });
        
        view.btnRemoveListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int task = view.getSelectedIndex();
                    if(task != -1){
                        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want do delete this task?", "Delete", 0, 2);
                        if(choice == 0){
                            switch (view.getSelectedList()) {
                                case 1:
                                    model.progRemoveTask(task);
                                    break;
                                case 2:
                                    model.compRemoveTask(task);
                                    break;
                                default:
                                    throw new IndexOutOfBoundsException();
                            }
                        }
                    }
                    else throw new IndexOutOfBoundsException();
                }
                catch(IndexOutOfBoundsException err){
                    JOptionPane.showMessageDialog(null, "Please select a task to remove.", "Warning", 2);
                }
            }
        });
        
        view.btnClearListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!model.getProgTasks().isEmpty() || !model.getCompTasks().isEmpty()){
                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want do delete ALL tasks?", "Clear all", 0, 2);
                    if(choice == 0){
                        model.clearTasks();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Lists are already empty.", "Information", 1);
                }
            }
        });
        
        view.btnCompleteListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int task = view.getSelectedIndex();
                    if(task != -1){
                        int choice = JOptionPane.showConfirmDialog(null, "The task will be set as completed.", "Complete", 0, 1);
                        if(choice == 0){
                            model.completeTask(task);
                        }
                    }
                    else throw new IndexOutOfBoundsException();
                }
                catch(IndexOutOfBoundsException err){
                    JOptionPane.showMessageDialog(null, "Please select a task to complete.", "Warning", 2);
                }
            }
        });
    }
}