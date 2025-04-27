package com.example.tienda.controller;

import com.example.tienda.model.Producto;
import com.example.tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // 🔹 Obtener todos los productos
    @GetMapping("")
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
    return ResponseEntity.ok(productoRepository.findAll());
}


    // 🔹 Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 🔹 Insertar un nuevo producto
    @PostMapping("/")
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoRepository.save(producto);
        return ResponseEntity.ok(nuevoProducto);
}

    // 🔹 Actualizar producto (cantidad, precio, etc.)
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            Producto p = producto.get();
            p.setNombre(productoActualizado.getNombre());
            p.setPrecio(productoActualizado.getPrecio());
            p.setCantidad(productoActualizado.getCantidad());
            return ResponseEntity.ok(productoRepository.save(p));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Borrar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}