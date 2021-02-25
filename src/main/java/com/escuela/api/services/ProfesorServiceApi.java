package com.escuela.api.services;

import com.escuela.api.commons.GenericServiceApi;
import com.escuela.api.model.Profesor;

public interface ProfesorServiceApi extends GenericServiceApi<Profesor,String> {

    Profesor findByName(String nombre);

}