package com.ejercicio1.api.services;

import com.ejercicio1.api.commons.GenericServiceApi;
import com.ejercicio1.api.model.Profesor;

public interface ProfesorServiceApi extends GenericServiceApi<Profesor,String> {

    Profesor findByName(String nombre);

}