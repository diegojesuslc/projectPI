/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function resetearFormulario() {
    document.getElementById("formularioAlta").reset();
    var avisoContrasena = document.getElementById("avisoContrasena");
    var btnEnviarDatos = document.getElementById("btnEnviarDatos");
    
    btnEnviarDatos.disabled = false;
    avisoContrasena.innerHTML = "-------";
    avisoContrasena.style.color = "black";
}


function propietarioGeneradoAutomaticamente() {

    var nombre = document.getElementById("txtNombre");
    var apellidos = document.getElementById("txtApellidos");

    var propietarioGeneradoAutomaticamente = document.getElementById("txtPropietarioGeneradoAutomaticamente");


    var resultadoCombinado = nombre.value.slice(0, 3) + apellidos.value.slice(0, 3) + "@sproviders.com";

    propietarioGeneradoAutomaticamente.value = resultadoCombinado;

    if (nombre.value.length == 0 || apellidos.value.length == 0) {
        propietarioGeneradoAutomaticamente.value = "";
    }
}


function coincidirContrasena() {

    var txtContrasena = document.getElementById("txtContrasena");
    var txtRepetirContrasena = document.getElementById("txtRepetirContrasena");
    var avisoContrasena = document.getElementById("avisoContrasena");
    var btnEnviarDatos = document.getElementById("btnEnviarDatos");

    btnEnviarDatos.disabled = true; //Boton en desactivado o apagado

    if (txtContrasena.value.length == 0 || txtRepetirContrasena.value.length == 0) {
        avisoContrasena.innerHTML = "Ninguna de las contraseñas pueden quedar vacias";
        avisoContrasena.style.color = "blue";
        btnEnviarDatos.disabled = true;

    } else if (txtContrasena.value != txtRepetirContrasena.value) {
        avisoContrasena.innerHTML = "las contraseñas NO coinciden";
        avisoContrasena.style.color = "red";
        btnEnviarDatos.disabled = true;

    } else {
        avisoContrasena.innerHTML = "Las contraseñas si coinciden";
        avisoContrasena.style.color = "green";
        btnEnviarDatos.disabled = false;
    }


}