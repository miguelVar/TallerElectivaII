<%-- 
    Document   : index
    Created on : 28/11/2017, 05:47:20 AM
    Author     : miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    String usuario = "";
    String pass = "";
%>
<%
    HttpSession sesionOn = request.getSession();
    if (sesionOn.getAttribute("user") == null) {
%>
<script type="text/javascript">
    //alert("Por favor inicia sesion");
    //location.href = "index.jsp";
</script>
<%} else {
        usuario = (String) sesionOn.getAttribute("user");
        pass = (String) sesionOn.getAttribute("pass");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="css/styles.css">
        <script src="scripts.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <nav>
            <div class="nav-wrapper #bf360c deep-orange darken-4">
                <!--<a href="#!" class="brand-logo">Logo</a>-->
                <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul id="mn" class="right hide-on-med-and-down">
                    <li onclick="inicarSesion()"><a href="#">Iniciar Sesión</a></li>
                    <li onclick="newUser()"><a href="#">Crear Cuenta</a></li>
                </ul>
                <ul class="side-nav" id="mobile-demo">
                    <li onclick="inicarSesion()"><a href="#">Iniciar Sesión</a></li>
                    <li onclick="newUser()"><a href="#">Crear Cuenta</a></li>
                </ul>
            </div>
        </nav>
        
        <br>
        <br>
        <br>

        <div class="container">
            <div class="row">
                <div class="col l1 m6 s6"></div>
                <div class="col l10 m6 s6" id="formNuevo">
                    <h4>Iniciar Sesión</h4>
                    Email: <input id="email" type="text">
                    Contraseña: <input id="password" type="password">
                    <button onclick="validateUser()" class="waves-effect waves-light btn">Enviar</button>
                </div>
                <div class="col l1 m6 s6"></div>
            </div>
        </div>





        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
                        $(document).ready(function () {
                            $(".button-collapse").sideNav();
                        });
        </script>
        <br>
        <br>
        <br>
        <br>
        <br>

        <footer class="page-footer #bf360c deep-orange darken-4">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">Taller Electiva II</h5>
                        <p class="grey-text text-lighten-4">Presentación del taller Manejo de Repositorios</p>
                    </div>
                    <div class="col l4 offset-l2 s12">
                        <h5 class="white-text">Integrantes</h5>
                        <p class="grey-text text-lighten-4">Caren corredor</p>
                        <p class="grey-text text-lighten-4">Miguel Angel Vargas Rodriguez</p>
                        <p class="grey-text text-lighten-4">Carlos Alberto Zambrano</p>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>
