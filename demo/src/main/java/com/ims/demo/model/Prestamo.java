package com.ims.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Long idPrestamo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_herramienta", nullable = false)
    private Herramienta herramienta;

    @Column(name = "fecha_prestamo", nullable = false)
    private LocalDateTime fechaPrestamo;

    @Column(name = "fecha_devolucion")
    private LocalDateTime fechaDevolucion;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "devuelto", nullable = false)
    private Boolean devuelto = false;

    public Prestamo() {}

    public Prestamo(Usuario usuario, Herramienta herramienta) {
        this.usuario = usuario;
        this.herramienta = herramienta;
        this.devuelto = false;
    }

    public Prestamo(Usuario usuario, Herramienta herramienta, LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion, Integer estado) {
        this.usuario = usuario;
        this.herramienta = herramienta;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
        this.devuelto = false;
    }

    // getters y setters
    public Long getIdPrestamo() { return idPrestamo; }
    public void setIdPrestamo(Long idPrestamo) { this.idPrestamo = idPrestamo; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Herramienta getHerramienta() { return herramienta; }
    public void setHerramienta(Herramienta herramienta) { this.herramienta = herramienta; }

    public LocalDateTime getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(LocalDateTime fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public Boolean getDevuelto() { return devuelto; }
    public void setDevuelto(Boolean devuelto) { this.devuelto = devuelto; }

    public LocalDateTime getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDateTime fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public Integer getEstado() { return estado; }
    public void setEstado(Integer estado) { this.estado = estado; }
}
