package com.pe.jacs.cursopersisdatos;

import java.sql.Connection;
import java.sql.SQLException;

public class CursoPersisDatos {

    public static void main(String[] args) {
        
        System.out.println("main");
        
        Conexion cn = new Conexion();
        try(Connection cnx = cn.conectDB()){
            System.out.println("Conectado");
        }catch(SQLException e){
            System.out.println("Error:" +e.getMessage());
        }
        
    }
}
