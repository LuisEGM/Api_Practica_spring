package com.escuela.api.profesores.dominio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProfesorDaoApi extends CrudRepository<Profesor,String> {

    @Query(value = "SELECT * FROM Profesores WHERE nombres = ?1", nativeQuery = true)
    Profesor ObtenerProfesorPorNombre(String nombre);

}