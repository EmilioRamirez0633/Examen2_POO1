<%@page import="com.udb.sv.controlador.PiezasCtrl"%>
<%@page import="com.udb.sv.modelo.Piezas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

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
                    <li><a href="index.jsp">Pieza</a></li>
                    <li><a href="bodega.jsp">Bodega</a></li>
                  </ul>
                </div>
              </nav>
             <h5>Datos Piezas</h5>
        <form method="POST" action="PiezasServ" name="Demo">
                <label>Id:</label>
                <input type="text" name="codi" id="codi" value="${codi}"/><br/>
                 <label>Nombre pieza:</label>
                <input type="text" name="nomb" id="nomb" value="${nomb}"/><br/>
                 <label>Tipo:</label>
                <input type="text" name="tip" id="tip" value="${tip}"/><br/>
                <label>Marca:</label>
                <input type="text" name="marc" id="marc" value="${marc}"/><br/>
                
                <button class="btn waves-effect waves-light" type="submit" name="btnMarca" value="Guardar">Guardar
                        <i class="material-icons right">send</i>
                 </button>
                 <button class="btn waves-effect waves-light" type="submit" name="btnMarca" value="Modificar">Modificar
                        <i class="material-icons right">send</i>
                 </button>
            </form>
                 <h5>Tabla</h5>
         <form method="POST" action="PiezasServ" name="Tabla">                                                                                  
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
                             for(Piezas temp : new PiezasCtrl().consTodo())
                             {
                            %>        
                            <tr>
                                 
                                <td><p><input name="codiPiezaRadi"  type="radio" value="<%=temp.getIdPieza()%>" id="<%=temp.getIdPieza()%>"/>
                                        <label for="<%=temp.getIdPieza()%>"></label></p></td>
                                <td><%=temp.getNombPieza()%></td>
                                <td><%=temp.getTipoPieza()%></td>
                                <td><%=temp.getMarcPieza()%></td>
                            </tr>
                            <%
                             }
                            %>
                    </tbody>
                  </table>
                     <button class="btn waves-effect waves-light" type="submit" name="btnMarca" value="Consultar">Consultar
                        <i class="material-icons right">send</i>
                     </button>
                    <button class="btn waves-effect waves-light" type="submit" name="btnMarca" value="Eliminar">Eliminar
                        <i class="material-icons right">delete</i>
                     </button>
             </form>
                    </div>
    </body>
</html>
