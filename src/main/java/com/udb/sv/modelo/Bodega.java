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
public class Bodega {
    private int idBodega;
    private int codiPiez;
    private int codiProv;
    private String nombProv;
    private String nombPiez;
    private int cant;
    private String fecha;

    public String getNombProv() {
        return nombProv;
    }

    public void setNombProv(String nombProv) {
        this.nombProv = nombProv;
    }

    public String getNombPiez() {
        return nombPiez;
    }

    public void setNombPiez(String nombPiez) {
        this.nombPiez = nombPiez;
    }

    public Bodega(int idBodega, int codiPiez, int codiProv, String nombProv, String nombPiez, int cant, String fecha) {
        this.idBodega = idBodega;
        this.codiPiez = codiPiez;
        this.codiProv = codiProv;
        this.nombProv = nombProv;
        this.nombPiez = nombPiez;
        this.cant = cant;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return this.fecha;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public int getCodiPiez() {
        return codiPiez;
    }

    public void setCodiPiez(int codiPiez) {
        this.codiPiez = codiPiez;
    }

    public int getCodiProv() {
        return codiProv;
    }

    public void setCodiProv(int codiProv) {
        this.codiProv = codiProv;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    

    public Bodega() {
    }
}
