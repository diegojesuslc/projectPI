/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DIEGO
 */
public class ConexionBD {
    
    private static String url = "jdbc:mysql://127.0.0.1:3306/proyectopi";
    private static String usuario = "root";
    private static String contrasena = "mysql";
    
    private static Connection conexion;
    private static PreparedStatement sentenciaPreparada;
    private static ResultSet resultado;
    
    public static Connection conectar(){
        Connection conexion = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("Error: " + e);
        }
        
        return conexion;
    }
    
    public static void main(String [] args){
        
        try{
            conexion = conectar();
            String consulta = "INSERT INTO propietario(id,nombre,apellidos,contrasena,propietario_generado_automaticamente) VALUES('002', 'Diego','Lavado','abc','abc@sproviders.com')";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            int i = sentenciaPreparada.executeUpdate();
            
            if(i > 0){
                System.out.println("Se guardaron los datos");
            }else{
                System.out.println("NO se guardaron los datos");
            }
            conexion.close();
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
}
