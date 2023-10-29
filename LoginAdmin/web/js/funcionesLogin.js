/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function borrarDatos(){
    
    var txtPropietario = document.getElementById("txtPropietario");
    txtPropietario.value = "";
    
    document.getElementById("txtContrasena").value = "";
}

function resetearFormularioLogin(){
    document.getElementById("formularioLogin").reset();
}
