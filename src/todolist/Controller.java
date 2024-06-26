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
                String name = JOptionPane.showInputDialog(null, "Enter task name:", "New task", 3);
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
        
        view.btnEditListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int task = view.getSelectedIndex();
                    if(task != -1){
                        String name = JOptionPane.showInputDialog(null, "Enter task name:", "Edit task", 3);
                        if (name == null || name.equals(""));
                        else{
                            model.editTaskName(view.getSelectedList(), view.getSelectedIndex(), name);
                        }
                    }
                    else throw new IndexOutOfBoundsException();
                }
                catch(IndexOutOfBoundsException err){
                    JOptionPane.showMessageDialog(null, "Please select a task to edit.", "Warning", 2);
                }
            }
        });
        
        view.btnClearAllListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!model.getProgTasks().isEmpty() || !model.getCompTasks().isEmpty()){
                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want do delete ALL tasks?", "Clear all", 0, 2);
                    if(choice == 0){
                        model.clearAllTasks();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "There are no tasks.", "Information", 1);
                }
            }
        });
        
        view.btnClearCompletedListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!model.getCompTasks().isEmpty()){
                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want do delete completed tasks?", "Clear completed", 0, 2);
                    if(choice == 0){
                        model.clearCompTasks();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "There are no completed tasks.", "Information", 1);
                }
            }
        });
        
        view.btnCompleteListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int list = view.getSelectedList();
                    if (list != 2){
                        int task = view.getSelectedIndex();
                        if(task != -1){
                            int choice = JOptionPane.showConfirmDialog(null, "The task will be set as completed.", "Complete", 0, 1);
                            if(choice == 0){
                                model.completeTask(task);
                            }
                        }
                        else throw new IndexOutOfBoundsException();
                    }
                    else throw new IndexOutOfBoundsException();
                }
                catch(IndexOutOfBoundsException err){
                    JOptionPane.showMessageDialog(null, "Please select a task to complete.", "Warning", 2);
                }
            }
        });
        
        view.btnUnCompleteListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int list = view.getSelectedList();
                    if (list == 2){
                        int task = view.getSelectedIndex();
                        if(task != -1){
                            int choice = JOptionPane.showConfirmDialog(null, "The task will be set as in-progress.", "Uncomplete", 0, 1);
                            if(choice == 0){
                                model.unCompleteTask(task);
                            }
                        }
                        else throw new IndexOutOfBoundsException();
                    }
                    else throw new IndexOutOfBoundsException();
                }
                catch(IndexOutOfBoundsException err){
                    JOptionPane.showMessageDialog(null, "Please select a task to uncomplete.", "Warning", 2);
                }
            }
        });
    }
}