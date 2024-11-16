package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.LibrosModel;
import com.example.demo.Repository.LibroRepository;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroController {
    
    private final LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardarlibro(@RequestBody LibrosModel librosModel) {
        try {
            libroRepository.save(librosModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Libro guardado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al guardar el libro: " + e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarLibros() {
        try {
            List<LibrosModel> libros = libroRepository.findAll();
            return ResponseEntity.ok(libros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al listar los libros: " + e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable int id) {
        try {
            LibrosModel libro = libroRepository.findById(id).orElse(null);   
            if (libro == null) {        
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                        .body("Libro no encontrado con el ID: " + id);
            }
            
            return ResponseEntity.ok(libro);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al buscar el libro: " + e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable int id, @RequestBody LibrosModel librosModel) {
        try {
            if (!libroRepository.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                     .body("Libro no encontrado con el ID: " + id);
            }
            
            librosModel.setId(id);
            libroRepository.save(librosModel);
            return ResponseEntity.status(HttpStatus.OK).body("Libro actualizado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al editar el libro: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        try {
            if (!libroRepository.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                     .body("Libro no encontrado con el ID: " + id);
            }
            
            libroRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Libro eliminado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al eliminar el libro: " + e.getMessage());
        }
    }
}
