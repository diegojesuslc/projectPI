/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function cargarElemento(url, elemento){
    var request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send(null);
    elemento.innerHTML = request.responseText;
}

function cargarAltaPropietario(){
    cargarElemento("altaPropietario.jsp", document.getElementById("content"));
}

function cargarLogin(){
    cargarElemento("Login.jsp", document.getElementById("content"));
}
