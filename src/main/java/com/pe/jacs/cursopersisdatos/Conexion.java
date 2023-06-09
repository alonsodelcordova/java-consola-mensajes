package com.pe.jacs.cursopersisdatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public Connection conectDB(){
        Connection cn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
            if(cn!=null){
                System.out.println("Conectado");
            }
        }catch(SQLException e){
            System.out.println("Error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Errpr"+ex.getMessage());
        }
        return cn;
    }
}
