<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>SpotiFake</title>
    <link rel="shortcut icon" href="https://i.imgur.com/1TKNPK4.png">	
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <style>
        body {

            background: url("resources/src/wallpapperLogin.jpg");
            
            background-size: cover;
            background-position: center;
        }

        .card {
            background-color: rgba(207, 206, 206, 0.852);
        }
        body
        
    </style>
</head>
<body>
	<div class="card col-8 " style="padding: 0%; margin-left: 17%; margin-top: 10%;">
        <div class="row no-gutters ">
            <div class="col-md-8 bg-dark text-white">
                <img src="resources/src/TornQualifiedCoypu-mobile.gif" class="card-img" alt="...">
                <div class="card-img-overlay">
                    <h2 class="card-title">SpotiFake</h2>
                    <p class="card-text">Toda la música que buscas nosotros la tenemos y más.</p>
                    <p class="card-text"></p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card-body">
                    <h2 style="font: oblique bold 300% cursive;">Iniciar Sesión</h2>
                    
                    <div style="margin-top: 40px;">
	                    <form:form method="POST" action="verificarUsuarioLogin" modelAttribute="usuario">   
	                        <div class="form-group">
		    					<label for="exampleInputEmail1">Correo electrónico</label>
		    					<form:input type="email" path="correoElectronico" class="form-control" placeholder="Ingresar correo electrónico" required="required"/>
		  					</div>
		                    <div class="form-group">
		    					<label for="exampleInputEmail1">Contraseña</label>
		    					<form:input type="password" path="contraseña" class="form-control" placeholder="Ingresar contraseña" required="required"/>
		  					</div>  	
		                  	<div class="container">
		                    	<div class="row">
		                    		<div class="col-md-6 col-sm-6">
				                        <button type="submit" class="btn btn-secondary">Iniciar sesión</button>
				                    </div>
				                      <div class="col-md-6 col-sm-6">
				                        <a class="btn btn-outline-dark" href="/SpotiFakeSolWeb/registrarUsuario">Registarse</a>
				                	</div>
			                  	</div>      
	                        </div>
                    	</form:form>
					</div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>