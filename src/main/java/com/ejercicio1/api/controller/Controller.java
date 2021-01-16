package com.ejercicio1.api.controller;

import com.ejercicio1.api.model.Profesor;
import com.ejercicio1.api.services.ProfesorServiceApi;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api-prof/v1")
public class Controller {

    @Autowired
    private ProfesorServiceApi profesorServiceApi;



    @GetMapping(value = "/profesores")
    @ApiOperation("Obtener la información de todos los profesores.")
    public List<Profesor> obtenerTodos(){
        return profesorServiceApi.getAll();
    }



    @GetMapping(value = "/obtener_prof/{id}")
    @ApiOperation("Obtener la información de un profesor dado su id.")
    public ResponseEntity<Profesor> obtenerUno(
            @ApiParam(value = "El id del profesor a buscar", required = true, example = "1")
            @PathVariable Integer id
    ){
        Profesor obj = profesorServiceApi.get(id);
        if(obj != null){
            return new ResponseEntity<>(obj,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
        }

    }





    @PatchMapping(value = "/editar_prof")
    @ApiOperation("Editar la información de un profesor, el id se envia en el json junto a el resto de datos.")
    public ResponseEntity<Profesor> editar(@RequestBody Profesor profesor){
        //System.out.println(profesor.getId());
        Profesor obj = profesorServiceApi.get(profesor.getId());
        if(obj != null){
            //System.out.println("Lo encuentra");
            Profesor obj2 = profesorServiceApi.save(profesor);
            return new ResponseEntity<>(obj2,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
        }
    }




    @PostMapping(value = "/profesores")
    @ApiOperation("Guarda la información de un nuevo profesor en la DB.")
    public ResponseEntity<Profesor> guardarPorfesor(@RequestBody Profesor profesor){
        Profesor obj = profesorServiceApi.save(profesor);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }




    @DeleteMapping(value = "/eliminar_prof/{id}")
    @ApiOperation("Eliminar la información de un profesor dado su id.")
    public ResponseEntity<Profesor> eliminar(
            @ApiParam(value = "El id del profesor a eliminar", required = true, example = "1")
            @PathVariable Integer id
    ){
        Profesor obj = profesorServiceApi.get(id);
        if(obj != null){
            profesorServiceApi.delete(id);
            return new ResponseEntity<>(obj,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
        }

    }

}
