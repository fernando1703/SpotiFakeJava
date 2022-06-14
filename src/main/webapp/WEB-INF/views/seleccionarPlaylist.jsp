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
</head>
<body style="background-image: url('resources/src/Guitar.jpg');">

	<div class="modal fade" id="crearPlaylist" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  		<div class="modal-dialog" role="document">
    		<div class="modal-content" style="background: #272c33ed;">
	      		<div class="modal-header">
	        		<h5 class="modal-title" id="exampleModalLabel" style="color: #ffffff">Ponle un nombre a tu Playlist</h5>
	        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          			<span aria-hidden="true">&times;</span>
	        		</button>
	      		</div>
	      		<form:form method="POST" action="guardarPlaylistAgregarCancionPlaylist" modelAttribute="playlist">
		      		<div class="modal-body">
			        		<div class="form-group">
					    		<form:input style="background: #5c616996; color: #ffffff;" path="nombre" type="text" class="form-control" placeholder="Ingresa el nombre de tu nueva Playlist" required="required"/>
					  		</div>
		      		</div>
		      		<div class="modal-footer">
		        		<button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Cerrar</button>
		        		<button type="submit" class="btn btn-outline-secondary">Crear</button>
		      		</div>
		    	</form:form>
    		</div>
  		</div>
	</div>
	
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
                                <a class="nav-link" href="/SpotiFakeSolWeb/mostrarCancion">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="modal" data-target="#crearPlaylist" data-dismiss="modal">Crear Playlist</a>
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
	
	<h1 class="text-center pt-5 pb-3" style="color: #ffffff;">PLAYLIST'S</h1>
	
	<div class="container-fluid">
		<div class="row">
			<c:forEach var="playlist" items="${listaPlaylist}">
		  		<div class="col-sm-3 mb-3">
		    		<div class="card text-center border border-dark" style="background: #8a959e14;">
		      			<div class="card-body">
		        			<h5 class="card-title" style="color: #ffffff;"><c:out value="${playlist.nombre}"></c:out></h5>
		        			<p class="card-text" style="color: #ffffff;"><c:out value="${playlist.fechaCreacion}"></c:out></p>
		        			<a href="/SpotiFakeSolWeb/cancionPlaylistAgregar/${playlist.idPlaylist}" class="btn btn-outline-secondary mr-2">Agregar</a>
		      			</div>
		    		</div>
		  		</div>
		  	</c:forEach>
		</div>
	</div>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>