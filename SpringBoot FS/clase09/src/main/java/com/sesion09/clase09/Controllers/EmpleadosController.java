package com.sesion09.clase09.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesion09.clase09.Models.EmpleadosModel;
import com.sesion09.clase09.Repositories.EmpleadosRepositoty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/empleados")
public class EmpleadosController {
    
    private final EmpleadosRepositoty empleadosRepositoty;

    public EmpleadosController(EmpleadosRepositoty empleadosRepositoty){
        this.empleadosRepositoty = empleadosRepositoty; 
    }

    @PostMapping("/guardar")
    public String guardarEmpleados(@RequestBody EmpleadosModel empleadosModel) {
        empleadosRepositoty.save(empleadosModel);
        return "Empleado guardado con exito";
    }
    
}
