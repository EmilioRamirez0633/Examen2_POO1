/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.controlador;

import com.sv.udb.recursos.Conexion;
import com.udb.sv.modelo.Piezas;
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
public class PiezasCtrl {
    public boolean guar(Piezas obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("INSERT INTO piezas VALUES(NULL,?,?,?)");
            cmd.setString(1, obje.getNombPieza());
            cmd.setString(2, obje.getTipoPieza());
            cmd.setString(3, obje.getMarcPieza());
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
    public boolean elim(Piezas obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("Delete from piezas where codi_piez = ?");
            cmd.setString(1, String.valueOf(obje.getIdPieza()));
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al eliminar la pieza " + ex.getMessage());
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
    public boolean modi(Piezas obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("update piezas set nomb_piez = ?, tipo_piez = ?, marc_piez = ? where codi_piez = ?");
            cmd.setString(1, String.valueOf(obje.getNombPieza())); 
            cmd.setString(2, String.valueOf(obje.getTipoPieza()));
            cmd.setString(3, String.valueOf(obje.getMarcPieza()));
            cmd.setString(4, String.valueOf(obje.getIdPieza()));
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al modificar el equipo " + ex.getMessage());
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
    public List<Piezas> consTodo()
    {
       List<Piezas> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("SELECT * FROM piezas");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Piezas(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
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
    public Piezas cons(int id)
    {
       Piezas resp = null;
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("SELECT * FROM piezas where codi_piez=?");
            cmd.setString(1, String.valueOf(id)); 
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = (new Piezas(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
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
