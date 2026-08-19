package com.xyz.transporte.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "conductores")
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del conductor es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El documento del conductor es obligatorio")
    @Column(nullable = false, unique = true)
    private String documento;

    @OneToOne(mappedBy = "conductor")
    @JsonIgnoreProperties("conductor")
    private Camion camion;

    public Conductor() {
    }

    public Conductor(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }
}
