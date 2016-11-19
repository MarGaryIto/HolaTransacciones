/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author BLABPC23
 */
public class Conexion {
    private Connection con = null;
    private final String db = "personas";
    private final String direccion = "jdbc:mysql://localhost:3306/"+db;
    private final String usuario = "root";
    private final String contrasena = "";
    public Connection conexion(){
        try{
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/personas","root","");                     

        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
        }
        return con;
    }
    public void executeUpdate(String sql) throws SQLException{
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/personas","root",""); 
        System.out.println(sql);
        Statement stmt = con.prepareStatement(sql);
        stmt.executeUpdate(sql);
    }
    
    public void executeQuery(String sql) throws SQLException{
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/personas","root",""); 
        System.out.println(sql);
        PreparedStatement us = con.prepareStatement(sql);
        us.executeQuery();
    }
    
    public ResultSet getExecuteQuery(String sql) throws SQLException{
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/personas","root",""); 
        System.out.println(sql);
        PreparedStatement us = con.prepareStatement(sql);
        ResultSet executeQuery = us.executeQuery(sql);
        return executeQuery;
    }
    
    public ResultSet getExecuteUpdate(String sql) throws SQLException{
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/personas","root",""); 
        System.out.println(sql);
        PreparedStatement us = con.prepareStatement(sql);
        ResultSet executeUpdate = us.executeQuery(sql);
        return executeUpdate;
    }
}
