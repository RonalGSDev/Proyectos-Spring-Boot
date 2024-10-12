package com.intecap.Sesion2FS.Controller;

import com.intecap.Sesion2FS.Model.ClienteModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping
    public List<ClienteModel> listarClientes(){

        List<ClienteModel> clientes = new ArrayList<>();

        clientes.add(new ClienteModel("1234","Ronal Vinicio","Gómez Santos", 77234512));
        clientes.add(new ClienteModel("1256","Jose Carlos","Gómez Marroquín", 55448794));

        return clientes;
    }

    @GetMapping("insertar")
    public ClienteModel insertClientes(@RequestParam("dpi") String dpi,
                                       @RequestParam("nombres") String nombres,
                                       @RequestParam("apellidos") String apellidos,
                                       @RequestParam("telefono") int telefono){

        ClienteModel nuevoCliente = new ClienteModel();

        nuevoCliente.setDpi(dpi);
        nuevoCliente.setNombres(nombres);
        nuevoCliente.setApellidos(apellidos);
        nuevoCliente.setTelefono(telefono);

        return nuevoCliente;

    }
}
