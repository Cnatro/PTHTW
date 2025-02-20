package com.cnatro.services;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class jdbcUtils {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbcUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConn() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost/englishdb", "root", "root");
    }
}
