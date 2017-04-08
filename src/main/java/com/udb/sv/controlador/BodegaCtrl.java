/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.controlador;

import com.sv.udb.recursos.Conexion;
import com.udb.sv.modelo.Bodega;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class BodegaCtrl {
    public boolean guar(Bodega obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("INSERT INTO bodega VALUES(NULL,?,?,?,?)");
            cmd.setString(1, String.valueOf(obje.getCodiPiez()));
            cmd.setString(2, String.valueOf(obje.getCodiProv()));
            cmd.setString(3, String.valueOf(obje.getCant()));
            cmd.setString(4, String.valueOf(obje.getFecha()));
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al guardar Equipos: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
    public List<Bodega> consTodo()
    {
       List<Bodega> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select codi_bode, bodega.codi_piez, bodega.codi_prov, piezas.nomb_piez, proveedores.nomb_prov, cant, fech from bodega, piezas, proveedores where bodega.codi_piez = piezas.codi_piez and bodega.codi_prov = proveedores.codi_prov");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Bodega(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7)));
            }
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    } 
}
