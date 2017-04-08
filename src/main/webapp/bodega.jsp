<%-- 
    Document   : bodega
    Created on : 08-abr-2017, 10:52:51
    Author     : Estudiante
--%>

<%@page import="com.udb.sv.controlador.BodegaCtrl"%>
<%@page import="com.udb.sv.modelo.Bodega"%>
<%@page import="com.udb.sv.controlador.PiezasCtrl"%>
<%@page import="com.udb.sv.modelo.Piezas"%>
<%@page import="com.udb.sv.controlador.ProveedoresCtrl"%>
<%@page import="com.udb.sv.modelo.Proveedores"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Guía 08 :::: POO1</title>
            <link rel='stylesheet' href='webjars/materialize/0.97.3/dist/css/materialize.min.css'>
             <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
            <script type="text/javascript" src="webjars/materialize/0.97.3/dist/js/materialize.min.js"></script>
    </head>
    <body>
         <div class="container">
              <nav>
                <div class="nav-wrapper">
                  <a href="#" class="brand-logo">Logo</a>
                  <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="proveedores.jsp">Proveedores</a></li>
                    <li><a href="index.jsp">Piezas</a></li>
                    <li><a href="bodega.jsp">Bodega</a></li>
                  </ul>
                </div>
              </nav>
             <h5>Datos Proveedores</h5>
        <form method="POST" action="bodegaServ" name="Demo">
                <label>Id:</label>
                <input type="text" name="codi" id="codi" value="${codi}"/><br/>
                
                <div class="row">
                <label>Proveedor:</label>
                <select name="prov" id="prov">
                    <%
                         for(Proveedores temp : new ProveedoresCtrl().consTodo())
                     {
                    %>
                     <option value="<%=temp.getIdProv()%>"><%=temp.getNombProv()%></option>
                     <%
                      }
                     %>
                 </select>
                </div>
                 <div class="row">
                <label>Piezas:</label>
                <select name="piez" id="piez">
                    <%
                         for(Piezas temp : new PiezasCtrl().consTodo())
                     {
                    %>
                     <option value="<%=temp.getIdPieza()%>"><%=temp.getNombPieza()%></option>
                     <%
                      }
                     %>
                 </select>
                 </div>
                <label>Cantidad:</label>
                <input type="text" name="cant" id="cant" value="${cant}"/><br/>
                
                 <label>Fecha:</label>
                <input type="text" name="fecha" id="fecha" value="${fecha}"/><br/>
                
                <button class="btn waves-effect waves-light" type="submit" name="btnBodega" value="Guardar">Guardar
                        <i class="material-icons right">send</i>
                 </button>
                 <button class="btn waves-effect waves-light" type="submit" name="btnBodega" value="Modificar">Modificar
                        <i class="material-icons right">send</i>
                 </button>
            </form>
                 <h5>Tabla</h5>
         <form method="POST" action="bodegaServ" name="Tabla">                                                                                  
                 <table>
                    <thead>
                      <tr>
                          <th>Seleccion:</th>
                          <th>Proveedor:</th>
                          <th>Pieza:</th>
                          <th>Cantidad:</th>
                          <th>Fecha:</th>
                      </tr>
                    </thead>

                    <tbody>
                       </tr>
                            <%
                             for(Bodega temp : new BodegaCtrl().consTodo())
                             {
                            %>        
                            <tr>
                                 
                                <td><p><input name="codiProve"  type="radio" value="<%=temp.getIdBodega()%>" id="<%=temp.getIdBodega()%>"/>
                                        <label for="<%=temp.getIdBodega()%>"></label></p></td>
                                <td><%=temp.getNombPiez()%></td>
                                <td><%=temp.getNombProv()%></td>
                                <td><%=temp.getCant()%></td>
                                 <td><%=temp.getFecha()%></td>
                            </tr>
                            <%
                             }
                            %>
                    </tbody>
                  </table>
                    <br>
                     <button class="btn waves-effect waves-light" type="submit" name="btnBodega" value="Consultar">Consultar
                        <i class="material-icons right">send</i>
                     </button>
                    <button class="btn waves-effect waves-light" type="submit" name="btnBodega" value="Eliminar">Eliminar
                        <i class="material-icons right">delete</i>
                     </button>
             </form>
                    </div>
                    <script>
                 $(document).ready(function() {
                    $('select').material_select();
                  });
            </script>
    </body>
</html>
