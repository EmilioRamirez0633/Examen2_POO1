/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.vista;

import com.udb.sv.controlador.BodegaCtrl;
import com.udb.sv.modelo.Bodega;
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
@WebServlet(name = "bodegaServ", urlPatterns = {"/bodegaServ"})
public class bodegaServ extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        boolean esValido = request.getMethod().equals("POST");
            String mens = "";
            if(!esValido){
                response.sendRedirect(request.getContextPath() + "/bodega.jsp");
            }
            else{
                String CRUD = request.getParameter("btnBodega");
                if(CRUD.equals("Guardar"))
                {      
                    Bodega obje = new Bodega();
                    obje.setCodiPiez(Integer.parseInt(request.getParameter("piez")));
                    obje.setCodiProv(Integer.parseInt(request.getParameter("prov")));
                    obje.setCant(Integer.parseInt(request.getParameter("cant")));
                    obje.setFecha(request.getParameter("fecha"));
                    if(new BodegaCtrl().guar(obje))
                    {
                        mens = "Datos guardados";
                    }
                    else
                    {
                        mens = "Error al guardar";
                    } 
                }
                 request.setAttribute("mensAler",mens);
            request.getRequestDispatcher("/bodega.jsp").forward(request, response);
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
