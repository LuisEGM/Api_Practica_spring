package com.escuela.api.controller.RequestAndResponse.crear;

import com.escuela.api.model.Profesor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter @Setter
public class RequestCrearProfesor {

    private String profesorNombres;
    private String profesorMail;
    private String profesorNumeroTelefono;
    private String profesorEspecialidad;
    private Date profesorFechaNacimiento;

    public Boolean mapearPropiedades(Profesor p){

        if(this.validarFechaNacimiento()){
            //Creando id
            String id = UUID.randomUUID().toString();
            p.setId(id);
            p.setNombres(this.profesorNombres);
            p.setEmail(this.profesorMail);
            p.setTelefono(this.profesorNumeroTelefono);
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
