package com.escuela.api.controller.exceptions;

public class BadRequestException extends RuntimeException{

    private static final String Title = "Bad Request (400)";

    public BadRequestException(String detalle){
        super(Title+", => "+detalle);
    }

}
