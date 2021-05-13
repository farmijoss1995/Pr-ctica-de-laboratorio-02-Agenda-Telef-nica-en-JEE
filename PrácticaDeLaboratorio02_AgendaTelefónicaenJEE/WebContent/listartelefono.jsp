<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>User Management Application</title>
</head>
<body>
 <center>
  <h1>User Management</h1>
        <h2>
         <a href="nuevo">Add New User</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Users</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Listar telefonos</h2></caption>
            <tr>
                <th>ID</th>
                <th>cedula</th>
                <th>numero</th>
                <th>tipoy</th>
                <th>aoperadora</th>
            </tr>
            <c:forEach var="telefono" items="${listartelefono}">
                <tr>
                    <td><c:out value="${telefono.id}" /></td>
                    <td><c:out value="${telefono.cedula}" /></td>
                    <td><c:out value="${telefono.numero}" /></td>
                    <td><c:out value="${telefono.tipo}" /></td>
                    <td><c:out value="${telefono.aoperadora}" /></td>
                    <td>
                     <a href="editar?id=<c:out value='${telefono.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="eliminar?id=<c:out value='${telefono.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>