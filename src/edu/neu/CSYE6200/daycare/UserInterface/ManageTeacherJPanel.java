/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.CSYE6200.daycare.UserInterface;

import edu.neu.CSYE6200.daycare.Architecture.School;
import edu.neu.CSYE6200.daycare.Architecture.Student;
import edu.neu.CSYE6200.daycare.Architecture.Teacher;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kcnuk
 */
public class ManageTeacherJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private School school;

    /**
     * Creates new form ManageTeacherJPanel
     */
    public ManageTeacherJPanel(JPanel userProcessContainer, School school) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.school = school;
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTeacher = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(216, 233, 239));

        tblTeacher.setFont(new java.awt.Font("微软雅黑", 0, 18)); // NOI18N
        tblTeacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Group ID", "First Name", "Last Name", "Age", "Credit", "Wage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTeacher);
        if (tblTeacher.getColumnModel().getColumnCount() > 0) {
            tblTeacher.getColumnModel().getColumn(0).setResizable(false);
            tblTeacher.getColumnModel().getColumn(1).setResizable(false);
            tblTeacher.getColumnModel().getColumn(2).setResizable(false);
            tblTeacher.getColumnModel().getColumn(3).setResizable(false);
            tblTeacher.getColumnModel().getColumn(4).setResizable(false);
            tblTeacher.getColumnModel().getColumn(5).setResizable(false);
            tblTeacher.getColumnModel().getColumn(6).setResizable(false);
        }

        btnRemove.setBackground(new java.awt.Color(0, 0, 0));
        btnRemove.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(216, 233, 239));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnCreate.setBackground(new java.awt.Color(0, 0, 0));
        btnCreate.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(216, 233, 239));
        btnCreate.setText("Create a Teacher Info");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnView.setBackground(new java.awt.Color(0, 0, 0));
        btnView.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        btnView.setForeground(new java.awt.Color(216, 233, 239));
        btnView.setText("View a Teacher's Info");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 25)); // NOI18N
        jLabel1.setText("Teacher Info");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnView)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRemove)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnCreate)))))
                        .addGap(100, 100, 100))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCreate, btnView});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblTeacher.getSelectedRow();
        if(selectedRow>=0){
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete??","Warning",selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
                Teacher teacher = (Teacher)tblTeacher.getValueAt(selectedRow, 0);
                school.removeTeacher(teacher);
                populateTable();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        AddNewTeacherJPanel panel = new AddNewTeacherJPanel(this.userProcessContainer, school);
        userProcessContainer.add("AddNewTeacherJPanel", panel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblTeacher.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row from table first to view", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            Teacher teacher = (Teacher)tblTeacher.getValueAt(selectedRow, 0);
            ViewTeacherJPanel panel = new ViewTeacherJPanel(this.userProcessContainer, school, teacher);
            userProcessContainer.add("ViewTeacherJPanel", panel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }

    }//GEN-LAST:event_btnViewActionPerformed

    void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblTeacher.getModel();
        dtm.setRowCount(0);
        for(Teacher t: school.getTeachers()){
            Object[] row = new  Object[7];
            row[0] = t;
            row[1] = t.getGroupID();
            row[2] = t.getFirstname();
            row[3] = t.getLasstname();
            row[4] = t.getAge();
            row[5] = t.getCredit();
            row[6] = t.getWage();
            
            dtm.addRow(row);
        }        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTeacher;
    // End of variables declaration//GEN-END:variables
}