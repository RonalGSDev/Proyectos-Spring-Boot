package com.sesion07.clase07.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.sesion07.clase07.Model.UsuarioModel;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
public class DemoController {
    
    private List<UsuarioModel> usuarios = new ArrayList<>();

    @PostMapping("/suma")
    public String sumarNumeros() {
        try{
            int num1 = 0;
            int num2 = 0;
            int division = num1 / num2;
            return String.valueOf(division);
        }catch(Exception ex){
            return ex.getMessage();
        } finally{
            
        }
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> obtenerUusuario(@PathVariable Long id){
        
        usuarios.add(new UsuarioModel(1, "Ronal","ronal@gmail.com"));
        usuarios.add(new UsuarioModel(2, "Luis","luis@gmail.com"));
        usuarios.add(new UsuarioModel(3, "Gelder","gelder@gmail.com"));

        UsuarioModel usuario = usuarios.stream()
            .filter(u -> id == u.getId())
            .findFirst()
            .orElse(null);
        

        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    //tradicional
    public int suma(int a, int b){
        return a+b;
    }

    //handler cerrado
    @PostMapping("/sumar")
    public ResponseEntity<Integer> sumar(@RequestBody int a, @RequestBody int b) {
        int resultado = a+b;
        return ResponseEntity.ok(resultado);
    }
    
    
    
}
