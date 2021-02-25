package com.escuela.api.controller;

import com.escuela.api.controller.RequestAndResponse.crear.RequestCrearProfesor;
import com.escuela.api.controller.RequestAndResponse.crear.ResponseCrearProfesor;
import com.escuela.api.controller.RequestAndResponse.obtener.ResponseObtenerProfesor;
import com.escuela.api.model.Profesor;
import com.escuela.api.services.ProfesorServiceApi;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api-profesores/v1")
public class Controller {


    @Autowired
    private ProfesorServiceApi profesorServiceApi;


    @GetMapping
    @ApiOperation("Obtener la información de todos los profesores.")
    public List<Profesor> obtenerTodos(){
        return profesorServiceApi.getAll();
    }


    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener la información de un profesor dado su id.")
    public ResponseEntity<ResponseObtenerProfesor> obtenerUno(
            @ApiParam(value = "El id del profesor a buscar", required = true)
            @PathVariable String id
    ){
        Profesor obj = profesorServiceApi.get(id);

        //Seteo la respuesta
        ResponseObtenerProfesor res = new ResponseObtenerProfesor();

        if(obj != null){
            res.mapearPropiedades(obj);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping(value = "/findByName/{nombre}")
    @ApiOperation("Obtener la información de un profesor dado su nombre")
    public ResponseEntity<Profesor> obtenerProfesorPorNombre(@PathVariable String nombre){
        Profesor obj = profesorServiceApi.findByName(nombre);
        if(obj != null){
            return new ResponseEntity<>(obj,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @PatchMapping
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


    @PostMapping
    @ApiOperation("Guarda la información de un nuevo profesor en la DB.")
    public ResponseEntity<ResponseCrearProfesor> guardarPorfesor(@RequestBody RequestCrearProfesor profesorParam){

        //Creando el objeto profesor a guardar
        Profesor profesor = new Profesor();

        //Seteando los valores
        if(profesorParam.mapearPropiedades(profesor)){
            //guardanoo en la db
            Profesor obj = profesorServiceApi.save(profesor);

            //Seteando respuesta
            ResponseCrearProfesor res = new ResponseCrearProfesor();
            res.setId(obj.getId());
            res.setNombres((obj.getNombres()));

            return new ResponseEntity<>(res,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }


    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar la información de un profesor dado su id.")
    public ResponseEntity<Profesor> eliminar(
            @ApiParam(value = "El id del profesor a eliminar", required = true, example = "1")
            @PathVariable String id
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
