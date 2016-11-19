/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author BLABPC23
 */
public class ModelTransacciones {
    private String sql;
    private int numeroColumnas;
    private String transaccion;
    
    /**
     * @return the sql
     */
    public String getSql() {
        return sql;
    }

    /**
     * @param sql the sql to set
     */
    public void setSql(String sql) {
        this.sql = sql;
    }

    /**
     * @return the numeroColumnas
     */
    public int getNumeroColumnas() {
        return numeroColumnas;
    }

    /**
     * @param numeroColumnas the numeroColumnas to set
     */
    public void setNumeroColumnas(int numeroColumnas) {
        this.numeroColumnas = numeroColumnas;
    }

    /**
     * @return the transaccion
     */
    public String getTransaccion() {
        return transaccion;
    }

    /**
     * @param transaccion the transaccion to set
     */
    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }
}
