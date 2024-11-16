package com.sesion09.clase09.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesion09.clase09.Models.ProveedoresModel;
import com.sesion09.clase09.Repositories.ProveedoresRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {

    private final ProveedoresRepository proveedoresRepository;

    public ProveedoresController(ProveedoresRepository proveedoresRepository){
        this.proveedoresRepository = proveedoresRepository;
    }

    @PostMapping("/guardar")
    public String guardarProveedor(@RequestBody ProveedoresModel proveedoresModel) {
        proveedoresRepository.save(proveedoresModel);  
        return "Proveedor guardado con exito";
    }
    
    
}
