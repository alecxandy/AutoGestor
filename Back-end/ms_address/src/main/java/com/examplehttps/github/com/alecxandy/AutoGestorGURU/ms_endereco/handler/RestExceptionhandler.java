package com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.handler;

import com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.exception.IdentifierNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionhandler {

    @RestControllerAdvice
    public class RestExceptionHandler {
        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(IdentifierNotFoundException.class)
        public Map<String, String> identifierNotException(IdentifierNotFoundException ex) {
            Map<String, String> erros = new HashMap<>();
            erros.put("DateTime", LocalDateTime.now().toString());
            erros.put("Message", ex.getMessage());
            erros.put("Status", HttpStatus.NOT_FOUND.toString());
            return erros;
        }
    }
}