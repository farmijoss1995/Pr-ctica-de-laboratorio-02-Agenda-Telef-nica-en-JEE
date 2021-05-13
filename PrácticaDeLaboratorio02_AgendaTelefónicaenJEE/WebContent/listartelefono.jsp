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
         <a href="new">Add New Telelfono</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">Listar todos los telelfonos</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Listar los telelfonos</h2></caption>
            <tr>
                <th>ID</th>
                <th>Cedula</th>
                <th>Numero</th>
                <th>Tipoy</th>
                <th>Operadora</th>
            </tr>
            <c:forEach var="tel" items="${listTelelfono}">
                <tr>
                    <td><c:out value="${tel.id}" /></td>
                    <td><c:out value="${tel.cedula}" /></td>
                    <td><c:out value="${tel.numero}" /></td>
                    <td><c:out value="${tel.tipo}" /></td>
                    <td><c:out value="${tel.aoperadora}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${tel.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${tel.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>