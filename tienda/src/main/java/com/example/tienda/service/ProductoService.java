package com.example.tienda.service;

import com.example.tienda.model.Producto;
import com.example.tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto producto) {
        Optional<Producto> productoExistente = productoRepository.findById(id);
        if (productoExistente.isPresent()) {
            Producto actualizado = productoExistente.get();
            actualizado.setNombre(producto.getNombre());
            actualizado.setPrecio(producto.getPrecio());
            actualizado.setCantidad(producto.getCantidad());
            return productoRepository.save(actualizado);
        }
        return null;
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}