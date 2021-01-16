package com.ejercicio1.api.controller;

import com.ejercicio1.api.ReqAndRes.Profesor.RespuestaCrearProfesor;
import com.ejercicio1.api.ReqAndRes.Profesor.RespuestaObtenerProfesor;
import com.ejercicio1.api.model.Profesor;
import com.ejercicio1.api.services.ProfesorServiceApi;
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
    public ResponseEntity<RespuestaObtenerProfesor> obtenerUno(
            @ApiParam(value = "El id del profesor a buscar", required = true, example = "1")
            @PathVariable String id
    ){
        Profesor obj = profesorServiceApi.get(id);

        //Seteo la respuesta
        RespuestaObtenerProfesor res = new RespuestaObtenerProfesor();

        if(obj != null){
            res.setNombres(obj.getNombres());
            res.setEmail(obj.getEmail());
            res.setTelefono(obj.getTelefono());
            res.setEspecialidad(obj.getEspecialidad());
            res.setFehcaNacimiento(obj.getFechaNacimiento());
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
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
    public ResponseEntity<RespuestaCrearProfesor> guardarPorfesor(@RequestBody Profesor profesor){

        //Estableciendo id
        String id = UUID.randomUUID().toString();
        System.out.println("Num caracteres id => " + id.length());
        profesor.setId(id);

        //guardanoo en la db
        Profesor obj = profesorServiceApi.save(profesor);

        //Seteando respuesta
        RespuestaCrearProfesor res = new RespuestaCrearProfesor();
        res.setId(obj.getId());
        res.setNombres((obj.getNombres()));

        return new ResponseEntity<>(res,HttpStatus.CREATED);
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
