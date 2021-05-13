<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title> Management Application</title>
</head>
<body>
 <center>
  <h1> Management</h1>
        <h2>
         <a href="new">Nuevo Telefono</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">Listar Telefonos</a>
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${tel != null}">
   <form action="update" method="post">
        </c:if>
        <c:if test="${tel == null}">
   <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${tel != null}">
               Editar telefono
              </c:if>
              <c:if test="${tel == null}">
               Add Nuevo telefono
              </c:if>
             </h2>
            </caption>
          <c:if test="${tel != null}">
           <input type="hidden" name="id" value="<c:out value='${tel.id}' />" />
          </c:if>            
            <tr>
                <th>Cedula: </th>
                <td>
                 <input type="text" name="cedula" size="45"
                   value="<c:out value='${tel.cedula}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Numero: </th>
                <td>
                 <input type="text" name="numero" size="45"
                   value="<c:out value='${tel.numero}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Tipo: </th>
                <td>
                 <input type="text" name="tipo" size="15"
                   value="<c:out value='${tel.tipo}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Operadora: </th>
                <td>
                 <input type="text" name="aoperadora" size="15"
                   value="<c:out value='${tel.aoperadora}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>