package com.escuela.api.profesores.dominio;

import com.escuela.api.commons.GenericServiceApi;
import com.escuela.api.profesores.dominio.Profesor;

public interface ProfesorServiceApi extends GenericServiceApi<Profesor,String> {

    Profesor findByName(String nombre);

}