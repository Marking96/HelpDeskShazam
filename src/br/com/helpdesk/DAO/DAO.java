/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helpdesk.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marking
 */
public class DAO {
    final String servidor = "jdbc:mysql://127.0.0.1:3306/helpdesk";
    final String user = "root";
    final String password = "";
    final String driver = "com.mysql.jdbc.Driver";
    
    public Connection conectar(){
        
        try{
            return DriverManager.getConnection(servidor, user, password);
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
