package com.example.tienda.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private Double precio;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "tienda_id")
    @JsonBackReference  // 🔹 Evita el ciclo infinito en JSON
    private Tienda tienda;

    public Producto() {}

    public Producto(String nombre, Double precio, Integer cantidad, Tienda tienda) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tienda = tienda;
    }

    // ✅ Getters y Setters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public Tienda getTienda() { return tienda; }
    public void setTienda(Tienda tienda) { this.tienda = tienda; }
}