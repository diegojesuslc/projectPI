/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DIEGO
 */
public class MetodosSQL {
    
    private Connection conexion;
    private PreparedStatement sentenciaPreparada;
    private ResultSet resultado;
    
    public boolean registrarPropietario(String id, String nombre, String apellidos, String contrasena, String propietarioGeneradoAutomaticamente){
        boolean registro = false;
        
        try {
            conexion = ConexionBD.conectar();
            String consulta = "INSERT INTO propietarios (id,nombre,apellidos,contrasena,propietario_generado_automaticamente) VALUES(?,?,?,?,?)";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1,id);
            sentenciaPreparada.setString(2,nombre);
            sentenciaPreparada.setString(3,apellidos);
            sentenciaPreparada.setString(4,contrasena);
            sentenciaPreparada.setString(5,propietarioGeneradoAutomaticamente);
            
            int resultadoInsercion = sentenciaPreparada.executeUpdate();
            
            if(resultadoInsercion > 0){
                registro = true; //El propietario se ha registrado
                System.out.println("Se realizo el alta del propietario");
            }else{
                registro = false; //El propietario NO se ha registrado
                System.out.println("NO se realizo el alta del propietario");
            }
          
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error; " + e);
        }finally {
            try {
                conexion.close();
            }catch (SQLException e){
                System.out.println("Error; " + e);
            }
        }
        
        System.out.println("Valor del Registro: " + registro);
        return registro;
        
    }
    
    
    public boolean buscarPropietarioRepetidoBD(String id){
        boolean propietarioRepetido = false;
        try {
            conexion = ConexionBD.conectar();
            String consulta = "SELECT id FROM propietarios WHERE id = ?";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, id);
            resultado = sentenciaPreparada.executeQuery();
            
            if(resultado.next()){
                propietarioRepetido = true; //El propietario esta registrado en la BD
            }else{
                propietarioRepetido = false; //El propietario no esta registrado en la BD
            }
            
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }finally{
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
        
        System.out.println("El valor del propietario repetido en el metodo es: " + propietarioRepetido);
        return propietarioRepetido;
        
        
    } 
    
    
    public boolean buscarPropietarioInicioSesion(String propietario, String contrasena){
        boolean iniciarSesion = false;
        
        try {
            conexion = ConexionBD.conectar();
            String consulta = "SELECT propietario_generado_automaticamente,password FROM propietarios WHERE propietario_generado_automaticamente = ? AND password = ?";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, propietario);
            sentenciaPreparada.setString(1, contrasena);
            resultado = sentenciaPreparada.executeQuery();
            if(resultado.next()){
                iniciarSesion = true; //El propietario puede iniciar sesion porque esta registrado en la BD
            }else{
                iniciarSesion = false; //El propietario NO puede iniciar sesion porque esta registrado en la BD
            }
            conexion.close();
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        
        System.out.println("El valor de iniciarSesion en el metodo es: " + iniciarSesion);
        return iniciarSesion;
       } 
    
    
    public String buscarNombre(String propietario){
        String nombre = null;
        try {
            conexion = ConexionBD.conectar();
            String consulta = "SELECT nombre FROM propietarios WHERE propietario_generado_automaticamente = ?";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, propietario);
            resultado = sentenciaPreparada.executeQuery();
            if(resultado.next()){ //El propietario fue hallado y obtenemos el nombre
                nombre = resultado.getString("nombre");
                
            }else{
                nombre = null; //El propietario NO fue hallado y NO obtuvimos el nombre 
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }finally{
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
        
        System.out.println("El valor del nombre en los Metodos SQL es: " +nombre);
        return nombre;
       }
    }
