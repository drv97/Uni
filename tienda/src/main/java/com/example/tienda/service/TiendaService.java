package com.example.tienda.service;

import com.example.tienda.model.Tienda;
import com.example.tienda.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    public List<Tienda> listarTodas() {
        return tiendaRepository.findAll();
    }

    public Tienda obtenerPorId(Long id) {
        return tiendaRepository.findById(id).orElse(null);
    }

    public Tienda guardarTienda(Tienda tienda) {
        return tiendaRepository.save(tienda);
    }

    public Tienda actualizarTienda(Long id, Tienda tienda) {
        Optional<Tienda> tiendaExistente = tiendaRepository.findById(id);
        if (tiendaExistente.isPresent()) {
            Tienda actualizada = tiendaExistente.get();
            actualizada.setNombre(tienda.getNombre());
            actualizada.setDireccion(tienda.getDireccion());
            return tiendaRepository.save(actualizada);
        }
        return null;
    }

    public void eliminarTienda(Long id) {
        tiendaRepository.deleteById(id);
    }
}