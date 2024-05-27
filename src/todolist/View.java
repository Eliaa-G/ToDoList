package todolist;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class View extends javax.swing.JFrame implements Observer{
    private final Model model;
    
    private String[] PcolumnNames = {"Task", "Creation date"};
    private String[] CcolumnNames = {"Task", "Creation date", "Completion date"};
    private DefaultTableModel progTableModel;
    private DefaultTableModel compTableModel;
    
    public View(Model model) {
        progTableModel = new DefaultTableModel(null, PcolumnNames);
        compTableModel = new DefaultTableModel(null, CcolumnNames);
        initComponents();
        
        this.model = model;
        model.addObserver(this);
    }

    public void btnAddListener(ActionListener l){
        btnAdd.addActionListener(l);
    }
    
    public void btnRemoveListener(ActionListener l){
        btnRemove.addActionListener(l);
    }
    
    public void btnClearListener(ActionListener l){
        btnClear.addActionListener(l);
    }
    
    public void btnCompleteListener(ActionListener l){
        btnComplete.addActionListener(l);
    }
    
    public int getSelectedIndex(){
        if (progTable.isShowing()) return progTable.getSelectedRow();
        else if (compTable.isShowing()) return compTable.getSelectedRow();
        else return -1;        
    }
    
    public int getSelectedList(){
        if (progTable.isShowing()) return 1;
        else if (compTable.isShowing()) return 2;
        else return -1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblToDo = new javax.swing.JLabel();
        btnComplete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        tbdPane = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        progTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        compTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("To-Do List");
        setResizable(false);

        lblToDo.setFont(new java.awt.Font("Eras Bold ITC", 1, 36)); // NOI18N
        lblToDo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblToDo.setText("TO-DO");
        lblToDo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnComplete.setText("✔");

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setText("+");
        btnAdd.setPreferredSize(new java.awt.Dimension(22, 22));

        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRemove.setText("-");
        btnRemove.setPreferredSize(new java.awt.Dimension(22, 22));

        btnClear.setBackground(new java.awt.Color(255, 102, 102));
        btnClear.setText("CLEAR ALL");

        progTable.setModel(progTableModel);
        progTable.getTableHeader().setResizingAllowed(false);
        progTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(progTable);

        tbdPane.addTab("In progress", jScrollPane2);

        compTable.setModel(compTableModel);
        compTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        compTable.setGridColor(new java.awt.Color(255, 255, 255));
        compTable.getTableHeader().setResizingAllowed(false);
        compTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(compTable);

        tbdPane.addTab("Completed", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tbdPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblToDo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                        .addComponent(btnComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblToDo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbdPane, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComplete)
                    .addComponent(btnClear))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnRemove;
    private javax.swing.JTable compTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblToDo;
    private javax.swing.JTable progTable;
    private javax.swing.JTabbedPane tbdPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        progTableModel.setRowCount(0);
        compTableModel.setRowCount(0);
        
        for (Task t : model.getProgTasks()){
            Object[] data = {t.getName(), t.getCreationDate()};
            progTableModel.addRow(data);
        }
        
        for (Task t : model.getCompTasks()){
            Object[] data = {t.getName(), t.getCreationDate(), t.getCompletionDate()};
            compTableModel.addRow(data);
        }
    }
}
