package com.escuela.api.controller.RequestAndResponse.actualizar;


import com.escuela.api.model.Profesor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class ResponseActualizarProfesor {

    private String profesorNombre;
    private String profesorEmail;
    private String profedorTelefono;
    private String profedorEspecialidad;
    private Date profesorFechaNacimiento;

    public void mapearPropiedades(Profesor p){
        this.setProfesorNombre(p.getNombres());
        this.setProfesorEmail(p.getEmail());
        this.setProfedorTelefono(p.getTelefono());
        this.setProfedorEspecialidad(p.getEspecialidad());
        this.setProfesorFechaNacimiento(p.getFechaNacimiento());
    }

}
