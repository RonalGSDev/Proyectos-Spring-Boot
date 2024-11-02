package com.ejercicioClase7.ejercicioClase7.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import com.ejercicioClase7.ejercicioClase7.Model.Cliente;

@Controller
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();

    @GetMapping("/form")
    public String showForm(Model model) {
        return "registro"; 
    }

    @PostMapping("/registrar")
    public String registrarCliente(Cliente cliente) {
        clientes.add(cliente); 
        return "redirect:/lista"; 
    }

    @GetMapping("/lista")
    public String listaClientes(Model model) {
        model.addAttribute("clientes", clientes);
        return "lista"; 
    }
}
