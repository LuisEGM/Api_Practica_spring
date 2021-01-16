package com.ejercicio1.api.services;

import com.ejercicio1.api.DaoApi.ProfesorDaoApi;
import com.ejercicio1.api.commons.GenericServiceImpl;
import com.ejercicio1.api.model.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl extends GenericServiceImpl<Profesor,Integer> implements ProfesorServiceApi {

    @Autowired
    private ProfesorDaoApi profesorDaoApi;

    @Override
    public CrudRepository<Profesor, Integer> getDao() {
        return profesorDaoApi;
    }
}
