package com.arthur.takeda.icomida.telemetry.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

public class RestExceptionModel {

    private HttpStatus httpStatus;
    private String mensagem;

    public RestExceptionModel(HttpStatus httpStatus, String mensagem) {
        this.httpStatus = httpStatus;
        this.mensagem = mensagem;
    }

    public RestExceptionModel() {
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
