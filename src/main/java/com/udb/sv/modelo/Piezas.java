/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.modelo;

/**
 *
 * @author Estudiante
 */
public class Piezas {
    private int idPieza;
    private String nombPieza;
    private String tipoPieza;
    private String marcPieza;

    @Override
    public String toString() {
        return this.nombPieza;
    }

    public int getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(int idPieza) {
        this.idPieza = idPieza;
    }

    public String getNombPieza() {
        return nombPieza;
    }

    public void setNombPieza(String nombPieza) {
        this.nombPieza = nombPieza;
    }

    public String getTipoPieza() {
        return tipoPieza;
    }

    public void setTipoPieza(String tipoPieza) {
        this.tipoPieza = tipoPieza;
    }

    public String getMarcPieza() {
        return marcPieza;
    }

    public void setMarcPieza(String marcPieza) {
        this.marcPieza = marcPieza;
    }

    public Piezas(int idPieza, String nombPieza, String tipoPieza, String marcPieza) {
        this.idPieza = idPieza;
        this.nombPieza = nombPieza;
        this.tipoPieza = tipoPieza;
        this.marcPieza = marcPieza;
    }

    public Piezas() {
    }
}
