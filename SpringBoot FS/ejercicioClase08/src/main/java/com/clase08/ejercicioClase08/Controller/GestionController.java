package com.clase08.ejercicioClase08.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.clase08.ejercicioClase08.Model.ProductosModel;

@RestControllerAdvice
public class GestionController {
    
    private ProductosModel obtenerUsuarioActual(){
        return new ProductosModel();

    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String, Object>> (NoHandlerFoundException ex){

    }

}
