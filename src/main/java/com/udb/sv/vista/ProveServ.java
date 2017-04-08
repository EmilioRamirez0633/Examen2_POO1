/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.vista;

import com.udb.sv.controlador.ProveedoresCtrl;
import com.udb.sv.modelo.Proveedores;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Estudiante
 */
@WebServlet(name = "ProveServ", urlPatterns = {"/ProveServ"})
public class ProveServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             boolean esValido = request.getMethod().equals("POST");
        String mens = "";
            if(!esValido){
                response.sendRedirect(request.getContextPath() + "/proveedores.jsp");
            }
            else{
                String CRUD = request.getParameter("btnProve");
                if(CRUD.equals("Guardar"))
                {      
                    Proveedores obje = new Proveedores();
                    obje.setNombProv(request.getParameter("nomb"));
                    obje.setDireProv(request.getParameter("dire"));
                    obje.setTeleProv(request.getParameter("tele"));
                    if(new ProveedoresCtrl().guar(obje))
                    {
                        mens = "Datos guardados";
                    }
                    else
                    {
                        mens = "Error al guardar";
                    } 
                }
                else if(CRUD.equals("Consultar"))
                {
                    int codi = Integer.parseInt(request.getParameter("codiProve").isEmpty() ? "-1" : request.getParameter("codiProve"));
                    Proveedores obje = new ProveedoresCtrl().cons(codi);
                    if(obje != null)
                    {
                        request.setAttribute("codi", obje.getIdProv());
                        request.setAttribute("nomb", obje.getNombProv());
                        request.setAttribute("dire", obje.getDireProv());
                        request.setAttribute("tele", obje.getTeleProv());
                    }
                    else
                    {
                        mens = "Error al consultar";
                    }
                }
                else if(CRUD.equals("Eliminar"))
                {
                     Proveedores obje = new Proveedores();
                    int codi = Integer.parseInt(request.getParameter("codiProve").isEmpty() ? "-1" : request.getParameter("codiProve"));
                    obje.setIdProv(codi);
                    if(new ProveedoresCtrl().elim(obje))
                    {mens = "Datos eliminados";

                    }
                    else
                    {
                        mens = "Error al consultar";
                    }
                }
                else if(CRUD.equals("Modificar"))
                {
                     Proveedores obje = new Proveedores();
                    obje.setIdProv(Integer.parseInt(request.getParameter("codi")));
                    obje.setNombProv(request.getParameter("nomb"));
                    obje.setDireProv(request.getParameter("dire"));
                    obje.setTeleProv(request.getParameter("tele"));
                    if(new ProveedoresCtrl().modi(obje))
                    {mens = "Datos modifcados";

                    }
                    else
                    {
                        mens = "Error al modificar";
                    }
                }
                request.setAttribute("mensAler",mens);
                request.getRequestDispatcher("/proveedores.jsp").forward(request, response);
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
