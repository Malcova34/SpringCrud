package com.crudgabriela.app.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name="agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty(message = "El nombre del equipo es obligatorio")
    private String nombre;

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El ID del equipo debe ser alfanumérico")
    @Column(name = "equipo_id")
    private String equipoId;

    @NotEmpty(message = "La categoría es obligatoria")
    private String categoria;

    private String marca;

    @PastOrPresent(message = "La fecha debe ser pasada o actual")
    @Column(name = "fecha_adquisicion")
    private LocalDate fechaAdquisicion;

    @PositiveOrZero(message = "El precio debe ser mayor o igual a cero")
    private Double precio;

    private String estado;

    private String observaciones;

    // Getters y setters

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(String equipoId) {
        this.equipoId = equipoId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}