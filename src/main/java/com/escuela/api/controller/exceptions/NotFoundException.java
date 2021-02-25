package com.escuela.api.controller.exceptions;

public class NotFoundException extends RuntimeException{

    private static final String Title = "Not Found (404)";

    public NotFoundException(String detalle){
        super(Title+", => "+detalle);
    }

}
