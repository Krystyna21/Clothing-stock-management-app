/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clothingstockmanagementapplication;

/**
 *
 * @author MA-MBI
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/clothing_stock_management";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static Connection getConnection() throws SQLException {
//         return DriverManager.getConnection (URL, USER, PASSWORD);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded Successfully");
        }
        catch(ClassNotFoundException e){
            System.err.println("Failed to load");
            e.printStackTrace();
        }
        
        System.out.println("Connecting to database");
        Connection connection = DriverManager.getConnection (URL, USER, PASSWORD);
        System.out.println("Connected successfully");
        
        return connection;
     }
    
}