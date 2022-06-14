<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SpotiFake</title>
    <link rel="shortcut icon" href="https://i.imgur.com/1TKNPK4.png">	
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {

            background: url("resources/src/wallpapperLogin.jpg");

            background-size: cover;
            background-position: center;
        }

        .card {
            background-color: rgba(207, 206, 206, 0.852);
        }
    </style>
</head>
<body>
	
	<div class="row">
        <div class="card col-8" style="padding: 1%; margin-left: 17%; margin-top: 10%;">
            <h2 class="text-center">Registrar Usuario</h2>
            <br>
            <div style="margin-top: 10px;">
	            <form:form method="POST" action="guardarUsuario" modelAttribute="usuario">
	                <div class="row container" style="margin: 0%;">
	                    <div class="form-group col-6" style="padding: 0%; margin: 0%;">
	                        <label for="nombre">Nombres</label>
	                        <form:input type="text" path="nombres" class="form-control" placeholder="Ingresar nombres" required="required"/>
	                    </div>
	                    <div class="form-group col-6 style=" margin: 0%; padding: 0%;">
	                        <label for="apellido">Apellidos</label>
	                        <form:input type="text" path="apellidos" class="form-control" placeholder="Ingresar apellidos" required="required"/>
	                    </div>
	                </div>
	                <div class="row container" style="margin: 0%;">
	                    <div class="form-group col-6" style="padding: 0%;">
	                        <label for="exampleInputEmail1">Correo Electrónico</label>
	                        <form:input type="email" path="correoElectronico" class="form-control" placeholder="Ingresar correo electrónico" required="required"/>
	                    </div>
	                    <div class="form-group col-6">
	                        <label for="exampleInputPassword1">Contraseña</label>
	                        <form:input type="password" path="contraseña" class="form-control" placeholder="Ingresar contraseña" required="required"/>
	                    </div>
	                </div>
	                <br>
	                <div class="container">
	                    <button type="submit" class="btn btn-secondary">Registrar</button>
	                </div>
	            </form:form>
	     	</div>	       
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
</body>
</html>