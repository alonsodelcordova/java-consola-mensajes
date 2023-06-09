package com.pe.jacs.cursopersisdatos;

import com.pe.jacs.cursopersisdatos.services.MensajesService;
import java.util.Scanner;

public class CursoPersisDatos {

    public static void main(String[] args) {
        
        //entrada
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println(
                "----------------\n"+
                "Aplicación de mensajes\n"+
                "1. Crear Mensajes\n"+
                "2. Listar Mensajes\n"+
                "3. Editar Mensaje\n"+
                "4. Eliminar Mensaje\n"+
                "5. Salir" 
            );
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.leerMensaje();
                    break;
                case 3:
                    MensajesService.editarMensaje();
                    break;
                case 4:
                    MensajesService.borrarMensaje();
                    break;
                default:
                    break;
            }
            
        }while(opcion!=5);
        
    }
}
