<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AGENDA TELEFONICA</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>

</head>
<body>
 <div class="container">
 <div class="row text-center" style="color: tomato;">
  <h2>AGENDA TELEFONICA</h2>
 </div>
 <hr>
  <div class="row col-md-10 col-md-offset-3"> 
   
   <div class="card card-body">
   
    <h2>CREAR CUENTA</h2>
    <div class="col-md-8 col-md-offset-3">

     <form action="<%=request.getContextPath()%>/registro" method="post">

      <div class="form-group">
       <label for="uname">Cedula:</label> <input type="text"
        class="form-control" id="uname" placeholder="cedula"
        name="cedula" required>
      </div>
      
      <div class="form-group">
       <label for="uname">Nombre:</label> <input type="text"
        class="form-control" id="uname" placeholder="nombre"
        name="nombre" required>
      </div>

      <div class="form-group">
       <label for="uname">Apellido:</label> <input type="text"
        class="form-control" id="uname" placeholder="apellido"
        name="apellido" required>
      </div>

      <div class="form-group">
       <label for="uname">Correo :</label> <input type="text"
        class="form-control" id="correo" placeholder="correo"
        name="correo" required>
      </div>

      <div class="form-group">
       <label for="uname">Password:</label> <input type="password"
        class="form-control" id="password" placeholder="Password"
        name="password" required>
      </div>

      <button type="submit" class="btn btn-primary">Registrar</button>
       <button onclick="location.href = 'login.jsp';">Atras</button>

     </form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>