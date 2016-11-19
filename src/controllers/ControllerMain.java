/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.ModelTransacciones;
import mysql.Conexion;
import mysql.ToString;
import views.ViewMain;

/**
 *
 * @author MarGaryIto
 */
public class ControllerMain implements ActionListener {
    ModelTransacciones modelTransacciones;
    ViewMain viewMain;
    Conexion conexion;
    int ubicacionID = -2;
    int ubicacionNombre = -1;
    int ubicacionNumero = 0;
    
    public ControllerMain(ModelTransacciones modelTransacciones,ViewMain viewMain) throws SQLException{
        this.modelTransacciones = modelTransacciones;
        this.viewMain = viewMain;
        
        viewMain.jButton_Iniciar.addActionListener(this);
        viewMain.jButton_Terminar.addActionListener(this);
        viewMain.jButton_Cancelar.addActionListener(this);
        viewMain.jButton_Aceptar.addActionListener(this);
        viewMain.jButton_Primero.addActionListener(this);
        viewMain.jButton_Anterior.addActionListener(this);
        viewMain.jButton_Siguiente.addActionListener(this);
        viewMain.jButton_Ultimo.addActionListener(this);
        viewMain.jButton_Agregar.addActionListener(this);
        viewMain.jButton_Editar.addActionListener(this);
        viewMain.jButton_Eliminar.addActionListener(this);
        
        initview();
        muestraRegistros();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==viewMain.jButton_Iniciar){
            JOptionPane.showMessageDialog(viewMain, "Transacciones iniciadas corectamente");
        }else if(source==viewMain.jButton_Terminar){
                JOptionPane.showMessageDialog(viewMain, "Transacciones finalizadas corectamente");
        }else if(source == viewMain.jButton_Agregar){
                preparaAgregar();
        }else if(source == viewMain.jButton_Primero){
            try {
                ubicacionID = -2;
                ubicacionNombre = -1;
                ubicacionNumero = 0;
                muestraRegistros();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else if(source== viewMain.jButton_Siguiente){
            try {
                ubicacionID +=3;
                ubicacionNombre += 3;
                ubicacionNumero += 3;
                muestraRegistros();
            }catch(SQLException ex) {
                ubicacionID = -2;
                ubicacionNombre = -1;
                ubicacionNumero = 0;
                System.out.println(ubicacionNumero);
            }
        }
    }
    private void muestraRegistros() throws SQLException{
        String sql = "select * from datos";
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/personas","root",""); 
        System.out.println(sql);
        PreparedStatement us = con.prepareStatement(sql);
        ResultSet rs = us.executeQuery(sql);
        if(rs.next()){
            ubicacionID+=3;ubicacionNombre+=3;ubicacionNumero+=3;
            viewMain.jTextField_ID.setText(""+rs.getObject(ubicacionID));
            viewMain.jTextField_Nombre.setText(""+rs.getObject(ubicacionNombre));
            viewMain.jTextField_Numero.setText(""+rs.getObject(ubicacionNumero));
        }
        viewMain.jTextField_ID.setText("");
    }
    private void preparaAgregar(){
        
    }
    private void initview(){
        viewMain.setVisible(true);
        viewMain.setLocationRelativeTo(null);
        viewMain.jPanel_AcepCanc.setVisible(false);
    }
    
}
