<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>SpotiFake</title>
	<link rel="shortcut icon" href="https://i.imgur.com/1TKNPK4.png">	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body style="background: url('resources/src/Fondo2.jpg');">

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
                                <a class="nav-link" href="/SpotiFakeSolWeb/playlistRedirect">Playlist's</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/SpotiFakeSolWeb/logoffRedirect">Cerrar Sesi�n</a>
                            </li>
                        </ul>
                    </div>
              	</ul>
            </div>
        </nav>
    </main>
		
	<div>
		<hr style="border:2px;">
	</div>
	
	<div class="card-deck">
		<c:forEach var="cancion" items="${listaCanciones}">
			<div class="col-sm-3 mb-3">
			  	<div class="card border border-dark" style="background: #7676761f;">
			  		<div class="embed-responsive embed-responsive-16by9">
			    		<iframe width="421" height="240" src="${cancion.url}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			    	</div>
			    	<div class="card-body" style="text-align: center;">
			      		<h5 class="card-title text-center" style="color: #ffffff;"><c:out value="${cancion.nombre}"></c:out></h5>
			      		<p class="card-text text-center" style="color: #ffffff;"><c:out value="${cancion.album}"></c:out></p>
			      		<p class="card-text text-center" style="color: #ffffff;"><c:out value="${cancion.artista}"></c:out></p>  
			      		<a href="/SpotiFakeSolWeb/agregarCancionAPlaylistRedirect/${cancion.idCancion}" class="btn btn-outline-secondary">Agregar a Playlist</a>
			    	</div>
			  	</div>
			  </div>
		  </c:forEach>
	</div>
	
	<script type="text/javascript">
		function obtenerId(id) {
			alert(id);
		}
		
		function crearPlaylist(){
			var nombrePlaylist = $('#nombreNuevaPlaylist').val();
			var playlist = {
				nombre: nombrePlaylist,	
				fechaCreacion: "17-03-1997",
				idUsuario: 1
			};
			
			$.ajax({
				type: "POST",
				url: 'nuevaPlaylist',
				data: playlist,
				success: function(data){
					alert(nombre);
				}
			});
		}
		
	</script>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
</body>
</html>