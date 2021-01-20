package com.ejercicio1.api.DaoApi;

import com.ejercicio1.api.model.Profesor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProfesorDaoApi extends CrudRepository<Profesor,String> {

    @Query(value = "SELECT * FROM Profesores WHERE nombres = ?1", nativeQuery = true)
    Profesor ObtenerProfesorPorNombre(@Param("param_nombre") String nombre);

}