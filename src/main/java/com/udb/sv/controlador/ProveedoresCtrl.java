/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.controlador;

import com.sv.udb.recursos.Conexion;
import com.udb.sv.modelo.Proveedores;
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
public class ProveedoresCtrl {
    public boolean guar(Proveedores obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("INSERT INTO proveedores VALUES(NULL,?,?,?)");
            cmd.setString(1, obje.getNombProv());
            cmd.setString(2, obje.getDireProv());
            cmd.setString(3, obje.getTeleProv());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al guardar proveedor: " + ex.getMessage());
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
    public boolean elim(Proveedores obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("Delete from proveedores where codi_prov = ?");
            cmd.setString(1, String.valueOf(obje.getIdProv()));
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al eliminar la proveedor " + ex.getMessage());
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
    public boolean modi(Proveedores obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("update proveedores set nomb_prov = ?, dire_prov = ?, tele_prov = ? where codi_prov = ?");
            cmd.setString(1, String.valueOf(obje.getNombProv())); 
            cmd.setString(2, String.valueOf(obje.getDireProv()));
            cmd.setString(3, String.valueOf(obje.getTeleProv()));
            cmd.setString(4, String.valueOf(obje.getIdProv()));
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al modificar el proveedor " + ex.getMessage());
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
    public List<Proveedores> consTodo()
    {
       List<Proveedores> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("SELECT * FROM proveedores");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Proveedores(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
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
    public Proveedores cons(int id)
    {
       Proveedores resp = null;
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("SELECT * FROM proveedores where codi_prov=?");
            cmd.setString(1, String.valueOf(id)); 
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = (new Proveedores(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
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
