package com.escuela.api.services;

import com.escuela.api.DaoApi.ProfesorDaoApi;
import com.escuela.api.commons.GenericServiceImpl;
import com.escuela.api.model.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl extends GenericServiceImpl<Profesor,String> implements ProfesorServiceApi {

    @Autowired
    private ProfesorDaoApi profesorDaoApi;

    @Override
    public CrudRepository<Profesor, String> getDao() {
        return profesorDaoApi;
    }

    @Override
    public Profesor findByName(String nombre) {
        return profesorDaoApi.ObtenerProfesorPorNombre(nombre);
    }

}