package com.example.tienda.controller;

import com.example.tienda.model.Tienda;
import com.example.tienda.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    @GetMapping
    public List<Tienda> listarTiendas() {
        return tiendaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tienda> obtenerTiendaPorId(@PathVariable Long id) {
        Tienda tienda = tiendaService.obtenerPorId(id);
        return ResponseEntity.ok(tienda);
    }

    @PostMapping
    public ResponseEntity<Tienda> agregarTienda(@RequestBody Tienda tienda) {
        Tienda nuevaTienda = tiendaService.guardarTienda(tienda);
        return ResponseEntity.ok(nuevaTienda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tienda> actualizarTienda(@PathVariable Long id, @RequestBody Tienda tienda) {
        Tienda tiendaActualizada = tiendaService.actualizarTienda(id, tienda);
        return ResponseEntity.ok(tiendaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTienda(@PathVariable Long id) {
        tiendaService.eliminarTienda(id);
        return ResponseEntity.noContent().build();
    }
}