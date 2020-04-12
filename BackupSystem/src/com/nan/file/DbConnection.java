/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nan.file;

import java.sql.*;

public class DbConnection {
    
    private Connection connector;
    
    public Connection getConnection() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connector = DriverManager.getConnection("jdbc:mysql://localhost:3306"
                    +"/backupsystem","root","");
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("No se pudo conectar con la base de datos");
        }
        
        return this.connector;
    }
    
}
