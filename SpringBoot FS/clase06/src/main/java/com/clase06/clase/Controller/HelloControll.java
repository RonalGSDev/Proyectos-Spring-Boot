package com.clase06.clase.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloControll {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hola buenos dias";
    }
    
}
