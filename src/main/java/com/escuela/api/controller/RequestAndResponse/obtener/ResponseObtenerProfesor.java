package com.escuela.api.controller.RequestAndResponse.obtener;

import com.escuela.api.model.Profesor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class ResponseObtenerProfesor {

    private String nombresProfesor;
    private String correoProfesor;
    private String numeroTelefonoProfesor;
    private String especialidadProfesor;
    private Date fechaNacimientoProfesor;

    public void mapearPropiedades(Profesor p){
        this.setNombresProfesor(p.getNombres());
        this.setCorreoProfesor(p.getEmail());
        this.setNumeroTelefonoProfesor(p.getTelefono());
        this.setEspecialidadProfesor(p.getEspecialidad());
        this.setFechaNacimientoProfesor(p.getFechaNacimiento());
    }

}
