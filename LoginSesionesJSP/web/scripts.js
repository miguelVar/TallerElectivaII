/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function newUser() {
    var contenido = document.getElementById("formNuevo");
    contenido.innerHTML = "";

    var formulario = document.createElement("form");

    var title = document.createElement("h5");
    title.appendChild(document.createTextNode("Ingrese los datos del nuevo usuario"));
    formulario.appendChild(title);
    
    formulario.appendChild(document.createTextNode("id: "));
    var txt = document.createElement("input");
    txt.setAttribute("id", "txtid");
    txt.setAttribute("placeholder", "Ingrese el id");
    formulario.appendChild(txt);
    
    formulario.appendChild(document.createTextNode("Nombre: "));
    var txt = document.createElement("input");
    txt.setAttribute("id", "txtnombre");
    txt.setAttribute("placeholder", "Ingrese el nombre");
    formulario.appendChild(txt);
    
    formulario.appendChild(document.createTextNode("Apellido: "));
    var txt = document.createElement("input");
    txt.setAttribute("id", "txtapellido");
    txt.setAttribute("placeholder", "Ingrese el Apellido");
    formulario.appendChild(txt);

    formulario.appendChild(document.createTextNode("Email: "));
    txt = document.createElement("input");
    txt.setAttribute("id", "txtemail");
    txt.setAttribute("type", "email");
    txt.setAttribute("placeholder", "Ingrese el correo electronico");
    formulario.appendChild(txt);


    formulario.appendChild(document.createTextNode("Contraseña: "));
    txt = document.createElement("input");
    txt.setAttribute("id", "txtpass");
    txt.setAttribute("placeholder", "Ingrese la contraseña");
    txt.setAttribute("type", "password")
    formulario.appendChild(txt);


    formulario.appendChild(document.createTextNode("Confirmar Contraseña: "));
    txt = document.createElement("input");
    txt.setAttribute("id", "txtpass2");
    txt.setAttribute("placeholder", "Ingrese la contraseña");
    txt.setAttribute("type", "password")
    formulario.appendChild(txt);

    var espacio = document.createElement("br");
    formulario.appendChild(espacio);
    var boton = document.createElement("button");
    boton.appendChild(document.createTextNode("Guardar"));
    boton.setAttribute("class", "waves-effect waves-light btn");
    boton.setAttribute("onclick", "validateCorreo()");

    formulario.appendChild(boton);
    contenido.appendChild(formulario);

}
function validateUser() {
    var email = document.getElementById("email").value;
    var pass = document.getElementById("password").value;

    var exp = /@/g;
    var rta = exp.test(email);
    if (rta) {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "ServletUser?email=" + email + "&pass=" + pass, true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                var out = JSON.parse(xhr.responseText);
                
                if (out == "No hay resgistros") {
                    alert("Las credenciales suministradas no estan registradas");
                    newUser();
                } else {
                    hijos(out);
                    opcmenu();
                    opcmenu2();
                }
            }
        };
        xhr.send(null);
    } else {
        alert("Dirección de correo incorrecta");
    }

}

function msm() {
    alert("bien");
}

function hijos(id) {
    var xhr2 = new XMLHttpRequest();
    xhr2.open("GET", "ServletSon?idFather=" + id, true);

    var cont = document.getElementById("formNuevo");
    cont.innerHTML = "";
    var tabla = document.createElement("table");
    tabla.setAttribute("border", "2");
    //tabla.setAttribute("class", "bordered");
    var thr = document.createElement("tr");
    var th = document.createElement("th");
    th.setAttribute("colspan", "3");
    th.appendChild(document.createTextNode("HIJOS"));
    thr.appendChild(th);
    tabla.appendChild(thr);

    thr = document.createElement("tr");
    th = document.createElement("th");
    th.appendChild(document.createTextNode("NOMBRE"));
    thr.appendChild(th);

    th = document.createElement("th");
    th.appendChild(document.createTextNode("APELLIDOS"));
    thr.appendChild(th);

    th = document.createElement("th");
    th.appendChild(document.createTextNode("FECHA NACIMIENTO"));
    thr.appendChild(th);
    tabla.appendChild(thr);

   
    xhr2.onreadystatechange = function () {

        if (xhr2.readyState === 4) {
            //alert(xhr2.responseText);
            var out = JSON.parse(xhr2.responseText);

            Object.keys(out).forEach(function (e) {
                if (this[e].id_user == id) {
                    thr = document.createElement("tr");
                    th = document.createElement("th");
                    th.appendChild(document.createTextNode(this[e].nombre));
                    thr.appendChild(th);

                    th = document.createElement("th");
                    th.appendChild(document.createTextNode(this[e].apellido));
                    thr.appendChild(th);

                    th = document.createElement("th");
                    th.appendChild(document.createTextNode(this[e].fecha_Nac));
                    thr.appendChild(th);
                    tabla.appendChild(thr);
                }
            }, out);
            
             cont.appendChild(tabla);
        }
    };
    xhr2.send(null);
}

function validateCorreo(){
    var email = document.getElementById("txtemail").value;
    var xhr=new XMLHttpRequest();
    xhr.open("GET","ServletValidateCorreo?email="+email,true);
    xhr.onreadystatechange=function (){
        if (xhr.readyState===4) {
            //alert(xhr.responseText);
            if (xhr.responseText==0) {
                insertUser();
            }else{
                alert("El correo ya esta registrado");
            }
            
        }
    };
    xhr.send(null);
}

function insertUser(){
    //alert("insertar");
        var id = document.getElementById("txtid").value;
        
        var nombre = document.getElementById("txtnombre").value;
        var apellido = document.getElementById("txtapellido").value;
        var email = document.getElementById("txtemail").value;
        var pass = document.getElementById("txtpass").value;
        var pass2 = document.getElementById("txtpass2").value;
    if (pass===pass2) {
        var xhr=new XMLHttpRequest();
        xhr.open("GET","ServletInsert?id="+id+"&nombre="+nombre+"&apellido="+apellido+"&email="+email+"&pass="+pass);
        xhr.onreadystatechange=function (){
            if (xhr.readyState===4) {
                alert("Insertado satisfactoriamente");
                inicarSesion();
            }
        };
        xhr.send(null);
    }else{
        alert("Las contraseñas no coinciden");
    }
    
    
}

function inicarSesion(){
    var cont=document.getElementById("formNuevo");
    cont.innerHTML="";
    var title=document.createElement("h4");
    title.appendChild(document.createTextNode("Iniciar Sesión"));
    cont.appendChild(title);
    var txt=document.createElement("input");
    txt.setAttribute("id","email");
    cont.appendChild(document.createTextNode("Email: "));
    cont.appendChild(txt);
    
    txt=document.createElement("input");
    txt.setAttribute("id","password");
    txt.setAttribute("type","password");
    cont.appendChild(document.createTextNode("Password: "));
    cont.appendChild(txt);
    
    var btn=document.createElement("button");
    btn.appendChild(document.createTextNode("Enviar"));
    btn.setAttribute("onclick","validateUser()");
    btn.setAttribute("class","waves-effect waves-light btn");
    cont.appendChild(btn);
}
function opcmenu(){
    var cont=document.getElementById("mn");
    cont.innerHTML="";
    var op=document.createElement("li");
    op.setAttribute("onclick","index.jsp");
    var ref=document.createElement("a");
    ref.setAttribute("href","logout.jsp");
    ref.appendChild(document.createTextNode("Cerrar Sesión"));
    op.appendChild(ref);
    cont.appendChild(op);
}

function opcmenu2(){
    var cont=document.getElementById("mobile-demo");
    cont.innerHTML="";
    var op=document.createElement("li");
    op.setAttribute("onclick","index.jsp");
    var ref=document.createElement("a");
    ref.setAttribute("href","logout.jsp");
    ref.appendChild(document.createTextNode("Cerrar Sesión"));
    op.appendChild(ref);
    cont.appendChild(op);
}