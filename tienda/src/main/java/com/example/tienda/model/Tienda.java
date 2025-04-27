package com.example.tienda.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL)
    @JsonIgnore  // 🔹 Evita la referencia cíclica
    private List<Producto> productos;

    public Tienda() {}

    public Tienda(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // ✅ Getters y Setters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }
}