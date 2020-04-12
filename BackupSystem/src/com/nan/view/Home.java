package com.nan.view;

import com.nan.file.*;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Home extends javax.swing.JFrame {
    
    //Get database connection
    DbConnection connection = new DbConnection();
    Connection conn = connection.getConnection();
    
    //Resultset to show files in home
    ResultSet rs;
    
    //Like before, instance the user to do some op
    UsersOperation user = new UsersOperation();
  
    //Get the file from absolute path in "filepath" textfield
    File file;
    
    //Get the file that you want to do something (Delete/download/Whatever you want)
    private String fileToDoSomething = "";
    
    //Constructor
    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        user.showSavedFiles(rs, conn, user.currentUser, fileTable);
    }
    
    public void clearTextbox() {
        filePath.setText("");
    }

        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        filePath = new javax.swing.JTextField();
        searchFile = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileTable = new javax.swing.JTable();
        deleteFile = new javax.swing.JButton();
        downLoadFile = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        searchFile.setText("Buscar");
        searchFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFileActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar archivo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        fileTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        fileTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(fileTable);

        deleteFile.setText("Eliminar archivo");
        deleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFileActionPerformed(evt);
            }
        });

        downLoadFile.setText("Descargar archivo");
        downLoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downLoadFileActionPerformed(evt);
            }
        });

        jButton1.setText("Desconectarse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Como se usa?");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                                    .addComponent(filePath))
                                .addGap(29, 29, 29)
                                .addComponent(searchFile, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(deleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(downLoadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filePath, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(downLoadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFileActionPerformed
        // TODO add your handling code here:
        user.searchFile(filePath);
    }//GEN-LAST:event_searchFileActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        file            = new File(filePath.getText());
        String fileName = file.getName();
        String author   = user.currentUser;
        Boolean successValue = user.saveFile(conn, author, fileName, filePath.getText());
        
        if(successValue == true) {
            JOptionPane.showMessageDialog(null,"Archivo guardado");
            this.clearTextbox();
            user.showSavedFiles(rs, conn, author, fileTable); //Update table with new content
            
        } else {
            JOptionPane.showMessageDialog(null,"No se pudo guardar el archivo");
            this.clearTextbox();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fileTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileTableMouseClicked
        try {
            //Get table model
            DefaultTableModel model = (DefaultTableModel)fileTable.getModel();
            
            //Get row and column
            int row    = fileTable.getSelectedRow();
            int column = fileTable.getSelectedColumn();
            String fileData = model.getValueAt(row,column).toString();
           
            this.fileToDoSomething = fileData;
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo seleccionar el archivo");
        }
    }//GEN-LAST:event_fileTableMouseClicked

    private void deleteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFileActionPerformed
        
        String author        = user.currentUser;
        String file          = this.fileToDoSomething;
        
        Boolean successValue = user.deleteFile(conn, file, author);
        
        if(successValue == true) {
            JOptionPane.showMessageDialog(null,"Se elimino el archivo");
            this.clearTextbox();
            user.showSavedFiles(rs, conn, author, fileTable);
        
        } else {
            JOptionPane.showMessageDialog(null,"No se pudo eliminar el archivo");
        }
        
    }//GEN-LAST:event_deleteFileActionPerformed

    private void downLoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downLoadFileActionPerformed
        
        String file          = this.fileToDoSomething;
        Boolean successValue = user.DownloadFile(rs, conn, file);
        
        if(successValue == true) {
            JOptionPane.showMessageDialog(null,"El archivo se ha descargado en la carpeta de descargas");
            this.clearTextbox();
            
        } else {
            JOptionPane.showMessageDialog(null,"No se pudo descargar el archivo");
        }
        
    }//GEN-LAST:event_downLoadFileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        user.logOut();
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

       About about = new About();
       about.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteFile;
    private javax.swing.JButton downLoadFile;
    private javax.swing.JTextField filePath;
    private javax.swing.JTable fileTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchFile;
    // End of variables declaration//GEN-END:variables
}
