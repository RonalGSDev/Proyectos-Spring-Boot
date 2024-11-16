package com.clase08.ejercicioClase08.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.clase08.ejercicioClase08.Model.ProductosModel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    private List<ProductosModel> productos = new ArrayList<>();

    @GetMapping
    public ResponseEntity<?> listarProductos() {
        try {
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                                 .body("Error al listar los productos.");
        }
    }

    @PostMapping
    public ResponseEntity<?> agregarProducto(@RequestBody ProductosModel nuevoProducto) {
        try {
            productos.add(nuevoProducto); 
            return ResponseEntity.status(201)
                                 .body("Producto agregado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                                 .body("Error al agregar el producto.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable Long id) {
        try {
            ProductosModel producto = productos.stream()
                                               .filter(p -> p.getId().equals(id))
                                               .findFirst()
                                               .orElse(null);
            if (producto != null) {
                return ResponseEntity.ok(producto);
            } else {
                return ResponseEntity.badRequest()
                                     .body("Producto con ID " + id + " no encontrado.");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                                 .body("Error al obtener el producto.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        try {
            boolean removed = productos.removeIf(p -> p.getId().equals(id));
            if (removed) {
                return ResponseEntity.ok("Producto eliminado con éxito.");
            } else {
                return ResponseEntity.badRequest()
                                     .body("Producto con ID " + id + " no encontrado.");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                                 .body("Error al eliminar el producto.");
        }
    }
}
