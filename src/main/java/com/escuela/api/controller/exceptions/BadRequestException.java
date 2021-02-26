package com.escuela.api.controller.exceptions;

public class BadRequestException extends RuntimeException{


    private static final String DESCRIPTION = "Bad Request (400)";

    public BadRequestException(String detail) {
        super(DESCRIPTION+". "+detail);
    }
}
