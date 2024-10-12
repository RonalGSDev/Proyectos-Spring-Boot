package com.ejercicio.gestio_tareas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.gestio_tareas.Models.TareasModel;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tareas")
public class TareasController {

    private List<TareasModel> tareas = new ArrayList<>();

    @GetMapping
    public String listarTareas(Model model) {
        model.addAttribute("tareas", tareas);
        return "listarTareas"; // nombre de la vista para listar tareas
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioTarea(Model model) {
        model.addAttribute("tarea", new TareasModel());
        return "formulario"; // nombre de la vista para el formulario
    }

    @PostMapping
    public String crearTarea(@ModelAttribute TareasModel tarea, Model model) {
        // Validaciones
        if (tarea.getCode() == null || tarea.getCode().isEmpty()) {
            model.addAttribute("error", "El código es obligatorio.");
            return "formulario"; // Redirigir al formulario con mensaje de error
        }
        if (tarea.getTitulo() == null || tarea.getTitulo().isEmpty()) {
            model.addAttribute("error", "El título es obligatorio.");
            return "formulario"; // Redirigir al formulario con mensaje de error
        }
        if (tarea.getDescripcion() == null || tarea.getDescripcion().isEmpty()) {
            model.addAttribute("error", "La descripción es obligatoria.");
            return "formulario"; // Redirigir al formulario con mensaje de error
        }

        // Agregar tarea a la lista
        tareas.add(tarea);
        return "redirect:/tareas"; // Redirigir a la lista de tareas
    }

    @GetMapping("/eliminar/{code}")
    public String eliminarTarea(@PathVariable String code) {
        tareas.removeIf(tarea -> tarea.getCode().equals(code));
        return "redirect:/tareas"; // Redirigir a la lista de tareas
    }
}