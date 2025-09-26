package com.ims.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_herramienta")
public class Herramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_herramienta")
    private Long idHerramienta;

    @Column(nullable = false, length = 100)
    private String nombre;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public Herramienta() {}

    public Herramienta(String nombre) {
        this.nombre = nombre;
    }

    // getters y setters
    public Long getIdHerramienta() { return idHerramienta; }
    public void setIdHerramienta(Long idHerramienta) { this.idHerramienta = idHerramienta; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
