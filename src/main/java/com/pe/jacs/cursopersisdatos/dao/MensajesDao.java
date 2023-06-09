package com.pe.jacs.cursopersisdatos.dao;

import com.pe.jacs.cursopersisdatos.Conexion;
import com.pe.jacs.cursopersisdatos.models.Mensajes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MensajesDao {
    
    public static int crearMensajeDB(Mensajes mensaje){
        int rowCre = 0;
        try(Connection cn = Conexion.conectDB()){
            String sql = "INSERT INTO mensaje (mensaje, autor) "+
                    " VALUES (?,?) ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAutor());
            rowCre = ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return rowCre;
    }
    
    public static List<Mensajes> leerMensajesDB(){
        List<Mensajes> lista = new ArrayList<>();
        try(Connection cn = Conexion.conectDB()){
            String sql = "SELECT * FROM mensaje ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Mensajes mensaj = new Mensajes();
                mensaj.setId(rs.getInt("id"));
                mensaj.setMensaje(rs.getString("mensaje"));
                mensaj.setAutor(rs.getString("autor"));
                mensaj.setFecha(rs.getDate("fecha"));
                lista.add(mensaj);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public static int borrarMensajeDB(int idMensaje){
        int rowsAff = 0;
        try(Connection cn = Conexion.conectDB()){
            String sql = "DELETE FROM mensaje WHERE id= ? ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idMensaje);
            rowsAff = ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAff;
    }
    
    public static int actualizarMensajeDB(Mensajes mensaje){
        int rowsAff = 0;
        try(Connection cn = Conexion.conectDB()){
            String sql = "UPDATE mensaje SET mensaje=? WHERE id= ? ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, mensaje.getMensaje());
            ps.setInt(2, mensaje.getId());
            rowsAff = ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAff;
    }
}
