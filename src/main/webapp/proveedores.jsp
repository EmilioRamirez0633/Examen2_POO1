<%-- 
    Document   : proveedores
    Created on : 08-abr-2017, 10:15:33
    Author     : Estudiante
--%>

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
        <form method="POST" action="ProveServ" name="Demo">
                <label>Id:</label>
                <input type="text" name="codi" id="codi" value="${codi}"/><br/>
                 <label>Nombre Proveedore:</label>
                <input type="text" name="nomb" id="nomb" value="${nomb}"/><br/>
                 <label>Direccion:</label>
                <input type="text" name="dire" id="dire" value="${dire}"/><br/>
                <label>Telefono:</label>
                <input type="text" name="tele" id="tele" value="${tele}"/><br/>
                
                <button class="btn waves-effect waves-light" type="submit" name="btnProve" value="Guardar">Guardar
                        <i class="material-icons right">send</i>
                 </button>
                 <button class="btn waves-effect waves-light" type="submit" name="btnProve" value="Modificar">Modificar
                        <i class="material-icons right">send</i>
                 </button>
            </form>
                 <h5>Tabla</h5>
         <form method="POST" action="ProveServ" name="Tabla">                                                                                  
                 <table>
                    <thead>
                      <tr>
                          <th>Seleccion:</th>
                          <th>Nombre:</th>
                          <th>Descripcion:</th>
                      </tr>
                    </thead>

                    <tbody>
                       </tr>
                            <%
                             for(Proveedores temp : new ProveedoresCtrl().consTodo())
                             {
                            %>        
                            <tr>
                                 
                                <td><p><input name="codiProve"  type="radio" value="<%=temp.getIdProv()%>" id="<%=temp.getIdProv()%>"/>
                                        <label for="<%=temp.getIdProv()%>"></label></p></td>
                                <td><%=temp.getNombProv()%></td>
                                <td><%=temp.getDireProv()%></td>
                                <td><%=temp.getTeleProv()%></td>
                            </tr>
                            <%
                             }
                            %>
                    </tbody>
                  </table>
                    <br>
                     <button class="btn waves-effect waves-light" type="submit" name="btnProve" value="Consultar">Consultar
                        <i class="material-icons right">send</i>
                     </button>
                    <button class="btn waves-effect waves-light" type="submit" name="btnProve" value="Eliminar">Eliminar
                        <i class="material-icons right">delete</i>
                     </button>
             </form>
                    </div>
    </body>
</html>
