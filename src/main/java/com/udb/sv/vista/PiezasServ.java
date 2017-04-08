/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.vista;

import com.udb.sv.modelo.Piezas;
import com.udb.sv.controlador.PiezasCtrl;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Estudiante
 */
@WebServlet(name = "PiezasServ", urlPatterns = {"/PiezasServ"})
public class PiezasServ extends HttpServlet {

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
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
            else{
                String CRUD = request.getParameter("btnMarca");
                if(CRUD.equals("Guardar"))
                {      
                    Piezas obje = new Piezas();
                    obje.setNombPieza(request.getParameter("nomb"));
                    obje.setTipoPieza(request.getParameter("tip"));
                    obje.setMarcPieza(request.getParameter("marc"));
                    if(new PiezasCtrl().guar(obje))
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
                    int codi = Integer.parseInt(request.getParameter("codiPiezaRadi").isEmpty() ? "-1" : request.getParameter("codiPiezaRadi"));
                    Piezas obje = new PiezasCtrl().cons(codi);
                    if(obje != null)
                    {
                        request.setAttribute("codi", obje.getIdPieza());
                        request.setAttribute("nomb", obje.getNombPieza());
                        request.setAttribute("tip", obje.getTipoPieza());
                        request.setAttribute("marc", obje.getMarcPieza());
                    }
                    else
                    {
                        mens = "Error al consultar";
                    }
                }
                else if(CRUD.equals("Eliminar"))
                {
                     Piezas obje = new Piezas();
                    int codi = Integer.parseInt(request.getParameter("codiPiezaRadi").isEmpty() ? "-1" : request.getParameter("codiPiezaRadi"));
                    obje.setIdPieza(codi);
                    if(new PiezasCtrl().elim(obje))
                    {mens = "Datos eliminados";

                    }
                    else
                    {
                        mens = "Error al consultar";
                    }
                }
                else if(CRUD.equals("Modificar"))
                {
                     Piezas obje = new Piezas();
                    obje.setIdPieza(Integer.parseInt(request.getParameter("codi")));
                    obje.setNombPieza(request.getParameter("nomb"));
                    obje.setTipoPieza(request.getParameter("tip"));
                    obje.setMarcPieza(request.getParameter("marc"));
                    if(new PiezasCtrl().modi(obje))
                    {mens = "Datos modifcados";

                    }
                    else
                    {
                        mens = "Error al modificar";
                    }
                }
                request.setAttribute("mensAler",mens);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
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
