<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>SpotiFake</title>
	<link rel="shortcut icon" href="https://i.imgur.com/1TKNPK4.png">	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body style="background-image: linear-gradient(rgba(0,0,0,0.5), rgba(0,0,0,0.5)), url('https://cutt.ly/le1KPPa');">
	
			<main>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="background-color: #e3f2fd;">
            <a class="ml-5 mr-5 navbar-brand" href="#">
                <img src="resources/src/spotifake.png" width="30" height="30" class="d-inline-block align-top" alt="">
                SpotiFake
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="ml-3 collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav mr-auto">

                </ul>
                <ul class="navbar-nav mr-5 ml-5">
                    <div>
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="/SpotiFakeSolWeb/mostrarCancionAdmin">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/SpotiFakeSolWeb/logoffRedirect">Cerrar sesión</a>
                            </li>
                        </ul>
                    </div>
              	</ul>
            </div>
        </nav>
    </main>
	
	<div class="container">	
		<div class="col-md-6 col-md-offset-3">
		    <form:form method="POST" action="/SpotiFakeSolWeb/actualizarEdicion" modelAttribute="cancion">   
		    
		    	<h1 class="text-center pt-5 pb-3" style="color: #a7896b;">Editar Canción</h1> 
		    	<hr/> 
		    	
		    	<div class="form-group">
		    		<form:input style="background: #2d1d0c8c; color: #a7896b;" type="hidden" path="idCancion" class="form-control" required="required"/>
		  		</div>
		    	 
		       	<div class="form-group">
		    		<label for="exampleInputEmail1" style="color: #a7896b;">Nombre</label>
		    		<form:input style="background: #2d1d0c8c; color: #a7896b;" type="text" path="nombre" class="form-control" required="required"/>
		  		</div>
		  			
		  		<div class="form-group">
		    		<label for="exampleInputEmail1" style="color: #a7896b;">Artista</label>
		    		<form:input style="background: #2d1d0c8c; color: #a7896b;" type="text" path="artista" class="form-control" required="required"/>
		  		</div>
		  			
		  		<div class="form-group">
		    		<label for="exampleInputEmail1" style="color: #a7896b;">Álbum</label>
		    		<form:input style="background: #2d1d0c8c; color: #a7896b;" type="text" path="album" class="form-control" required="required"/>
		  		</div>
		  			
		  		<div class="form-group">
		    		<label for="exampleInputEmail1" style="color: #a7896b;">Género</label>
		    		<form:input style="background: #2d1d0c8c; color: #a7896b;" type="text" path="genero" class="form-control" required="required"/>
		  		</div>
		  			
		  		<div class="form-group">
		    		<label for="exampleInputEmail1" style="color: #a7896b;">Fecha de Lanzamiento</label>
		    		<form:input style="background: #2d1d0c8c; color: #a7896b;" type="date" path="fechaLanzamiento" class="form-control" required="required"/>
		  		</div>
		  			
		  		<div class="form-group">
		    		<label for="exampleInputEmail1" style="color: #a7896b;">URL</label>
		    		<form:input style="background: #2d1d0c8c; color: #a7896b;" type="text" path="url" class="form-control" required="required"/>
		  		</div>
		  		
		  		<div class="form-group">
		    		<form:input style="background: #2d1d0c8c; color: #a7896b;" type="hidden" path="fechaRegistro" class="form-control" required="required"/>
		  		</div>
		  			
		  		<button type="submit" class="btn btn-dark">Guardar</button>
		  			
		     </form:form>   
		</div> 
	</div>
	
</body>
</html>