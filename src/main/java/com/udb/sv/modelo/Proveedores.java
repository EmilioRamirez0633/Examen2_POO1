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
public class Proveedores {
    private int idProv;
    private String nombProv;
    private String direProv;
    private String teleProv;

    @Override
    public String toString() {
        return  this.nombProv;
    }

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }

    public String getNombProv() {
        return nombProv;
    }

    public void setNombProv(String nombProv) {
        this.nombProv = nombProv;
    }

    public String getDireProv() {
        return direProv;
    }

    public void setDireProv(String direProv) {
        this.direProv = direProv;
    }

    public String getTeleProv() {
        return teleProv;
    }

    public void setTeleProv(String teleProv) {
        this.teleProv = teleProv;
    }

    public Proveedores(int idProv, String nombProv, String direProv, String teleProv) {
        this.idProv = idProv;
        this.nombProv = nombProv;
        this.direProv = direProv;
        this.teleProv = teleProv;
    }

    public Proveedores() {
    }
}
