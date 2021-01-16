package com.ejercicio1.api.DaoApi;

import com.ejercicio1.api.model.Profesor;
import org.springframework.data.repository.CrudRepository;

public interface ProfesorDaoApi extends CrudRepository<Profesor,Integer> {
}