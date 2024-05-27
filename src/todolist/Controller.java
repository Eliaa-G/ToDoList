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
                String task = JOptionPane.showInputDialog(null, "Enter task name:", "New Task", 3);
                model.newTask(task);
            }
        });
        
        view.btnRemoveListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int check = view.getSelectedIndex();
                    if(check != -1){
                        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want do delete ALL tasks?", "Clear all?", 0, 2);
                        if(choice == 0){
                            model.removeTask(view.getSelectedIndex());
                        }
                    }
                    else throw new IndexOutOfBoundsException();
                }
                catch(IndexOutOfBoundsException err){
                    JOptionPane.showMessageDialog(null, "Please select a task to remove", "Warning", 2);
                }
            }
        });
        
        view.btnClearListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!model.getProgTasks().isEmpty() && !model.getCompTasks().isEmpty()){
                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want do delete ALL tasks?", "Clear all?", 0, 2);
                    if(choice == 0){
                        model.clearTasks();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Lists are already empty", "Information", 1);
                }
            }
        });
        
        view.btnCompleteListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    model.completeTask(view.getSelectedValue(), view.getSelectedIndex());
                }
                catch(IndexOutOfBoundsException err){
                    JOptionPane.showMessageDialog(null, "Please select a task to complete", "Warning", 2);
                }
            }
        });
    }
}