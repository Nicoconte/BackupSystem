/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nan.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import javafx.util.Pair;
import javax.swing.*;
import javax.swing.filechooser.*;
import net.proteanit.sql.DbUtils;

public class UsersOperation {
    
    public static String currentUser;
    JButton button;
    
    public void createUser(Connection conn, String name, String password) {
        try {
            
            String query = "INSERT INTO userinfo VALUES(?,?)";
            PreparedStatement sql = conn.prepareStatement(query);
            sql.setString(1,name); //I only accept names in lower case to facilitate the verification
            sql.setString(2,password);
            
            sql.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Usuario creado!");
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo crear el usuario,"
                    + " revise sus datos");
        }
    }
    
    public Pair<String, Boolean> logUser(ResultSet rs, Connection conn, String name, String password) {
        
        Boolean accessToAplication = false;
        
        try {
            
            String query = "SELECT userName, userPassword FROM userinfo WHERE userName='"+name+"' && userpassword='"+password+"'";
            PreparedStatement sql = conn.prepareStatement(query);
            rs = sql.executeQuery();
            
            if(rs.next()) {
                
                accessToAplication = true;
                this.currentUser = name;
                
            } else {
                accessToAplication = false;
            }
             
            rs.close();//Close database connection
            
        } catch(Exception e) {
           
            JOptionPane.showMessageDialog(null,"Puede ser que la app no funcione correctamente");
        }
        
        return new Pair<String, Boolean>(this.currentUser, accessToAplication);
    }
    
    
    public Boolean ifUserExist(ResultSet rs, Connection conn, String name) {
        
        
        String query  = "SELECT userName from userinfo";
        Boolean exist = false;
        ArrayList <String> users = new <String> ArrayList();
        
        try {
            PreparedStatement sql = conn.prepareStatement(query);
            rs = sql.executeQuery();
            
            while(rs.next()) {
                users.add(rs.getString("userName"));
            }
            
            exist = (users.contains(name)) ? true : false;
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Parece que la app no funciona correctamente");
        }
        
        return exist;
    }
    
    
    public void searchFile(JTextField t){
        
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter(
                "PNG & JPG & JPEG Files","png","jpg","jpeg");
        fileChooser.setFileFilter(fileFilter);
        
        int fileSelector = fileChooser.showOpenDialog(button);
        if(fileSelector != JFileChooser.CANCEL_OPTION) {
            File fileName = fileChooser.getSelectedFile();
            
            if((fileName == null) || (fileName.getName().equals(""))) {
                t.setText("...");
            } else {
                t.setText(fileName.getAbsolutePath());
            }
        
        } else {
            int exit = JFileChooser.ABORT;
        }
    }

    
    public Boolean saveFile(Connection conn, String author, String name, String path) {
        
        Boolean success = false;
        String query    = "INSERT INTO fileinfo VALUES(?,?,?)";
        File f = new File(path);
        FileInputStream stream; //We need this to read the file
        
        try {
            PreparedStatement sql = conn.prepareStatement(query);
            sql.setString(1,author);
            sql.setString(2,name);
            sql.setBlob(3,stream = new FileInputStream(f), f.length());
            sql.executeUpdate();
            
            success = true;
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"La app no pudo guardar su archivo");
        }
             
        return success;
    }
    
    
    public void showSavedFiles(ResultSet rs, Connection conn,String name, JTable table) {
        
        String query = "SELECT fileName FROM fileinfo INNER JOIN userinfo ON fileinfo.fileAuthor=userinfo.userName WHERE fileinfo.fileAuthor='"+name+"'";
        
        try {
            PreparedStatement sql = conn.prepareStatement(query);
            rs = sql.executeQuery();
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            rs.close();//Close database connection
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Parece que la app no puede mostrar los datos");
        
        }
    }
    
    
    public Boolean deleteFile(Connection conn, String name, String author) {
        
        Boolean success = false;
        String query = "DELETE FROM fileinfo WHERE (fileName='"+name+"' && fileAuthor='"+author+"')";
        
        try {
            PreparedStatement sql = conn.prepareStatement(query);
            sql.executeUpdate();
            
            success = true;
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"La app no pudo eliminar el archivo");
        }
        
        return success;
    }
    
    
    public Boolean DownloadFile(ResultSet rs, Connection conn, String name) {
        
        Boolean success   = false;
        String query      = "SELECT fileName,fileContent FROM fileinfo WHERE fileName='"+name+"'";
        String outputPath = "C:/Users/"+System.getProperty("user.name")+"/Downloads/";
        
        try {
            PreparedStatement sql = conn.prepareStatement(query);
            rs = sql.executeQuery();
            
            while(rs.next()) {
                String fileName = rs.getString("fileName");
                File file = new File(fileName); //Get the file
                
                //Create an output 
                try(FileOutputStream output = new FileOutputStream(outputPath + file)){
                    
                    //It use 1024 bytes long because it doesnt know what is the length of input
                    byte[] buffer = new byte[1024];
                    InputStream input = rs.getBinaryStream("fileContent");
                    
                    while(input.read(buffer) > 0) { 
                        output.write(buffer);
                    }
                    
                    //Close I/O
                    output.close();
                    input.close();
                    
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            
            success = true;
            rs.close(); //Close database connection
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"La app tuvo problemas al descargar el archivo");
        }
        
        return success;
    }
    
    
    public String logOut() {
        return this.currentUser = "";
    }
    
}