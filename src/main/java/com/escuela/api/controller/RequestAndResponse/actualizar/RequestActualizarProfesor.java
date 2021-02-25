package com.escuela.api.controller.RequestAndResponse.actualizar;

import com.escuela.api.model.Profesor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class RequestActualizarProfesor {

    private String profesorNombre;
    private String profesorEmail;
    private String profesorTelefono;
    private String profesorEspecialidad;
    private Date profesorFechaNacimiento;

    public Boolean mapearPropiedades(Profesor p){

        if(this.validarFechaNacimiento()){
            p.setNombres(this.profesorNombre);
            p.setEmail(this.profesorEmail);
            p.setTelefono(this.profesorTelefono);
            p.setEspecialidad(this.profesorEspecialidad);
            p.setFechaNacimiento(this.profesorFechaNacimiento);
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean validarFechaNacimiento(){
        Date fechaActual = new Date();
        return this.profesorFechaNacimiento.before(fechaActual);
    }

}
