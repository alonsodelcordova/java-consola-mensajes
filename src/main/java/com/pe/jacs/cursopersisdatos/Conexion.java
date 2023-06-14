package com.pe.jacs.cursopersisdatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static Connection connection;
    
    public static Connection conectDB(){
        try{
            if(connection==null || connection.isClosed()){
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
                if(connection!=null){
                    System.out.println("Conectado a DB");
                }
            }
        }catch(SQLException e){
            System.out.println("Error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error"+ex.getMessage());
        }
        return connection;
    }
}
