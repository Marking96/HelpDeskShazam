/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helpdesk.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class HelpDeskDaoFactory {
    
    private static HelpDeskDaoFactory instancia;

    protected HelpDeskDaoFactory() {
    }

    private final String servidor = "jdbc:mysql://127.0.0.1:3306/helpdesk";
    private final String user = "root";
    private final String password = "";
    private final String driver = "com.mysql.jdbc.Driver";
    
    public static HelpDeskDaoFactory getintancia(){
        if(instancia == null){
            instancia = new HelpDeskDaoFactory();
        }return instancia;
    }
    
    
    public Connection getConnection(){
        
        try{
            Class.forName(driver);
            return DriverManager.getConnection(servidor, user, password);
            
        }catch( ClassNotFoundException | SQLException e){
            throw new RuntimeException("Erro na conexão",e);
        }
    }
    
    public static void closeConnection(Connection con){
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException ex) {
                Logger.getLogger(HelpDeskDaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void closeConnection(Connection con,PreparedStatement stmt){
        closeConnection(con);
        
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
                Logger.getLogger(HelpDeskDaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void closeConnection(Connection con,PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
                Logger.getLogger(HelpDeskDaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
