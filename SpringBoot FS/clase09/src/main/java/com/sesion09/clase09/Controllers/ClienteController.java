package com.sesion09.clase09.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sesion09.clase09.Models.ClienteModel;
import com.sesion09.clase09.Repositories.ClienteRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    private final ClienteRepository clienteRepository;
    
    public ClienteController(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/guardar")
    @ResponseBody
    public String guardarCliente(@RequestBody ClienteModel clienteModel) {
        clienteRepository.save(clienteModel);
        return "Cliente guardado con exito";
    }
    
}
