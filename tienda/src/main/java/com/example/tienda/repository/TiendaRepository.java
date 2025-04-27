package com.example.tienda.repository;

import com.example.tienda.model.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Long> {
}