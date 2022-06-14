<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>SpotiFake</title>
	<link rel="shortcut icon" href="https://i.imgur.com/1TKNPK4.png">	
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" href="spofyfake.png" />

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
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
                                <a class="nav-link" href="/SpotiFakeSolWeb/registrarUsuario">Registrate</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/SpotiFakeSolWeb/login">Inicia Sesión</a>
                            </li>
                        </ul>
                    </div>
              	</ul>
            </div>
        </nav>
    </main>

    <section>
        <div class="bd-example" style="background: linear-gradient(#F037A5 -60%, #FAE62D 140%);">
            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active" data-interval="4000">
                        <img src="resources/src/1.jpg" class="d-block w-100" alt="..." ">
                        <div class=" carousel-caption d-md-block">
                        <h1>Diviértete</h1>
                        <h5>Diviértete con la variedad de canciones que tenemos para tí.</h5>
                    </div>
                </div>
                <div class="carousel-item" data-interval="4000">
                    <img src="resources/src/2.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <h1>Escucha</h1>
                        <h5>Escucha tus rolas favoritas y agrégalas a tus Playlist's.</h5>
                    </div>
                </div>
                <div class="carousel-item" data-interval="4000">
                    <img src="resources/src/3.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <h1>Baila</h1>
                        <h5>Baila al ritmo de la mejor música que tenemos para tí.</h5>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        </div>
    </section>

    <section style="background-color: #F037A5;
    background: -webkit-gradient(linear, left top, left bottom, color-stop(-60%, #F037A5), color-stop(140%, #FAE62D));
    background: linear-gradient(#F037A5 -60%, #FAE62D 140%);">
        <div class="container">
            <br />
            <h1 class="text-center">Desarrolladores</h1>
            <br />
            
            <div class="row " style="background: url(hero-burst.svg) no-repeat;">
                <div class="col-12 col-md-6">
                    <div class="card mb-3" style="max-width: 540px;">
                        <div class="row no-gutters">
                            <div class="col-md-4">
                                <img src="resources/src/d1.jpg" class="card-img" alt="...">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h3 class="card-title">OMAR MORALES MUÑOZ</h3>
                                    <h6 class="card-text">Ingeniero en Sistemas Computacionales</h6>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                
                <div class="col-12 col-md-6">
                    <div class="col-ms-3">
                        <div class="card mb-2" style="max-width: 540px;">
                            <div class="row no-gutters">
                                <div class="col-md-4">
                                    <img src="resources/src/d2.jpg" class="card-img" alt="...">
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <h3 class="card-title">FERNANDO CARRASCO TERAN</h3>
                                        <h6 class="card-text">Ingeniero en Sistemas Computacionales</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="col-12 col-md-6">
                    <div class="card mb-2" style="max-width: 540px;">
                        <div class="row no-gutters">
                            <div class="col-md-4">
                                <img src="resources/src/d3.jpg" class="card-img" alt="...">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h3 class="card-title">KEVIN RUDAS CASTAÑEDA</h3>
                                    <h6 class="card-text">Ingeniero en Sistemas Computacionales</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-md-6">
                    <div class="card mb-2" style="max-width: 540px;">
                        <div class="row no-gutters">
                            <div class="col-md-4">
                                <img src="resources/src/d4.jpg" class="card-img" alt="...">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h3 class="card-title">JHAN NOVILLO ALEJANDRIA</h3>
                                    <h6 class="card-text">Ingeniero en Sistemas Computacionales</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="col-12 col-md-6">
	               	<div class="card mb-2" style="max-width: 540px;">
	              		<div class="row no-gutters">
	                    	<div class="col-md-4">
	                        	<img src="resources/src/d5.jpg" class="card-img" alt="...">
	                      	</div>
	                     	<div class="col-md-8">
	                      		<div class="card-body">
	                      			<h3 class="card-title">ANDERSON CORAL ZAMORA</h3>
	                      			<h6 class="card-text">Ingeniero en Sistemas Computacionales</h6>
	                      		</div>
	                   		</div>
	               		</div>
	                </div>
                </div>
            </div>
            
        </div>
    </section>

    <section style="background: #000;">
        <br />
        <br />
        <div class="container">
            <div class="row">
                <div class="col-6 col-md-6">
                    <a style="color:white;" class="ml-5 mr-5 " href="#">
                        <img src="resources/src/spofyfake.png" width="30" height="30"  alt="">
                        SpotiFake
                    </a>
                </div>
                <div class="col-6 col-md-6">
                    <h6 class="ml-5 mr-5 " style="color: white;">© 2019 Spotifake</h6>
                </div>
            </div>
        </div>
        <br>
    </section>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
