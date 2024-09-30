package com.example.intecap1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intecap1.models.productosModel;
import com.example.intecap1.service.productosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/productos")
public class productosController {
    
    @Autowired
    private productosService productosService;

    @GetMapping("/listar")
    public Iterable<productosModel> getProductos() {
        return this.productosService.findAll();
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> saveProductos(@RequestBody productosModel entity ) {  
        try {
            this.productosService.save(entity);
            return ResponseEntity.ok("Producto guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }
        
    }

    @DeleteMapping("/eliminar/{idProducto}")
    public ResponseEntity<String> deleteProductos(@PathVariable int idProducto ) {  
        try {
            this.productosService.deleteById(idProducto);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }
        
    }

    @PutMapping("editar/{idProducto}")
    public ResponseEntity<String> updateProductos(@PathVariable int idProducto, @RequestBody productosModel entities) {
        try {
            entities.setId(idProducto);
            this.productosService.save(entities);
            return ResponseEntity.ok("Producto editado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }
        
    }
    


}
