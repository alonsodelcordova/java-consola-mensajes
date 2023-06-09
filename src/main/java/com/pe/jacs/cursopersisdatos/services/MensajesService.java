package com.pe.jacs.cursopersisdatos.services;

import com.pe.jacs.cursopersisdatos.dao.MensajesDao;
import com.pe.jacs.cursopersisdatos.models.Mensajes;
import java.util.List;
import java.util.Scanner;

public class MensajesService {
    
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Escribe tu nombre");
        String nombre = sc.nextLine();
        
        Mensajes mensObj = new Mensajes(mensaje, nombre);
        int res = MensajesDao.crearMensajeDB(mensObj);
        if(res>0){
            System.out.println("Mensaje Creado");
        }else{
            System.out.println("No se puede crear su mensaje");
        }
    }
    
    public static void leerMensaje(){
        List<Mensajes> lista = MensajesDao.leerMensajesDB();
        lista.forEach(msj ->{
            System.out.println(
                "------------------------\n"+
                "Mensaje #"+msj.getId()+": \n"+
                msj.getMensaje()+"\n"+
                "Autor : "+msj.getAutor()
            );
        });
    }
    
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el ID del mensaje a Eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        int res = MensajesDao.borrarMensajeDB(id);
        if(res>0){
            System.out.println("Mensaje Eliminado");
        }else{
            System.out.println("No se puede eliminar el mensaje o no existe");
        }
    }
     
    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el ID del mensaje ad editar: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Escribe el mensaje");
        String mensaje = sc.nextLine();
        Mensajes msj = new Mensajes();
        msj.setId(id);
        msj.setMensaje(mensaje);
        int res = MensajesDao.actualizarMensajeDB(msj);
        if(res>0){
            System.out.println("Mensaje Actualizado ");
        }else{
            System.out.println("No se puede actualizar el mensaje");
        }
    }
    
    
    
}
