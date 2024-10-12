package com.intecap.Sesion2FS.Controller;

import com.intecap.Sesion2FS.Model.ProductoModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    //Metodo para listar productos
    @GetMapping("/primer")
    public ProductoModel listarProducto(){
        ProductoModel nuevoProducto = new ProductoModel();
        nuevoProducto.setNombre("Manzana");
        nuevoProducto.setCantidad(2);
        nuevoProducto.setColor("Rojo");

        return (nuevoProducto);
    }

    @GetMapping("/id/lista")
    public List<ProductoModel> listaProdusctos(){
        List<ProductoModel> listaProductos = new ArrayList<>();

        listaProductos.add(new ProductoModel(1,"Manzana", "Roja",2));
        listaProductos.add(new ProductoModel(2,"Manzana", "Verde",5));
        listaProductos.add(new ProductoModel(3,"Mandarina", "Naranja",7));

        return listaProductos;
    }

    @GetMapping("/{id}")
    public ProductoModel listarProductoXId(@PathVariable("Id") int idProducto){
        List<ProductoModel> listaProductos = new ArrayList<>();
        listaProductos.add(new ProductoModel(1,"Manzana", "Roja",2));
        listaProductos.add(new ProductoModel(2,"Manzana", "Verde",5));
        listaProductos.add(new ProductoModel(3,"Mandarina", "Naranja",7));

        return listaProductos.stream()
                .filter(producto -> producto.getId() == idProducto)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
    }

    @GetMapping("/buscar/{nombre}")
    public ProductoModel listadoProductoXID(@PathVariable("nombre") String nombreProducto){

        ProductoModel nuevoProducto = new ProductoModel();
        nuevoProducto.setId(4);
        nuevoProducto.setNombre(nombreProducto);
        nuevoProducto.setColor("Morado");
        nuevoProducto.setCantidad(5);

        return nuevoProducto;

    }


    //http://localhost:8080/producto/buscar?id=1
    @GetMapping("/buscar")
    public ProductoModel listarProductoColor(@RequestParam("id") int idProducto){
        List<ProductoModel> listaProductos = new ArrayList<>();
        listaProductos.add(new ProductoModel(1,"Manzana", "Roja",2));
        listaProductos.add(new ProductoModel(2,"Manzana", "Verde",5));
        listaProductos.add(new ProductoModel(3,"Mandarina", "Naranja",7));

        return listaProductos.stream()
                .filter(producto -> producto.getId() == idProducto)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
    }


    //para insertar
    //http://localhost:8080/producto/insertar?id=4&nombre=pera&color=verde&cantidad=3
    @GetMapping("/insertar")
    public ProductoModel insertProducto(@RequestParam("id") int id,
                                        @RequestParam("nombre") String nombre,
                                        @RequestParam("color") String color,
                                        @RequestParam("cantidad") int cantidad){
        ProductoModel nuevoProducto = new ProductoModel();
        nuevoProducto.setId(id);
        nuevoProducto.setNombre(nombre);
        nuevoProducto.setColor(color);
        nuevoProducto.setCantidad(cantidad);

        return nuevoProducto;
    }



}
