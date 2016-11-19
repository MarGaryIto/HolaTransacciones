/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controllers.ControllerMain;
import java.sql.SQLException;
import models.ModelTransacciones;
import views.ViewMain;

/**
 *
 * @author COMPURENT-19
 */
public class MainMain {
    public static void main(String[]gary) throws SQLException{
        ModelTransacciones modelTransacciones = new ModelTransacciones();
        ViewMain viewMain = new ViewMain();
        ControllerMain controllerMain = new ControllerMain(modelTransacciones,viewMain);
    }
}
