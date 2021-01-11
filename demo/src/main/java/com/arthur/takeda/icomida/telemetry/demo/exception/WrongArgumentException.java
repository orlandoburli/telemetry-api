package com.arthur.takeda.icomida.telemetry.demo.exception;

public class WrongArgumentException extends RuntimeException{
    public WrongArgumentException(String message){
        super(message);
    }
}
