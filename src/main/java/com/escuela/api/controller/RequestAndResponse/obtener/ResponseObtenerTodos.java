package com.escuela.api.controller.RequestAndResponse.obtener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter @Setter
public class ResponseObtenerTodos {

    private String profesorId;
    private String profesorNombres;
    private String profesorMail;
    private String profesorNumeroTelefono;
    private String profesorEspecialidad;
    private Date profesorFechaNacimiento;

}
