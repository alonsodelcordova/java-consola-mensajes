
package com.pe.jacs.cursopersisdatos.models;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mensajes {
    int id;
    String mensaje;
    String autor;
    Date fecha;
    public Mensajes(String mensaje, String autor){
        this.mensaje = mensaje;
        this.autor = autor;
    }
}
