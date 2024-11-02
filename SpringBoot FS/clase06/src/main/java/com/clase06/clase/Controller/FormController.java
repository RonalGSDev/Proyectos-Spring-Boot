package com.clase06.clase.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Importación correcta
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {
    
    @GetMapping("/form")
    public String showForm(Model model) {
        String nombre = "Ronal";
        model.addAttribute("nombre", nombre);
        return "form"; 
    }
    
}
