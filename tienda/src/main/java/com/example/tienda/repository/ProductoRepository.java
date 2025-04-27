package com.example.tienda.repository;

import com.example.tienda.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // 🔹 Buscar productos por nombre
    List<Producto> findByNombre(String nombre);

    // 🔹 Buscar productos con cantidad mayor a un valor específico
    List<Producto> findByCantidadGreaterThan(Integer cantidad);

    // 🔹 Buscar productos por tienda ID
    List<Producto> findByTiendaId(Long tiendaId);
}
