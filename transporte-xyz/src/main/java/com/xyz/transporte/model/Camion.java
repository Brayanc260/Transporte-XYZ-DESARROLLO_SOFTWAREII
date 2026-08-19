package com.xyz.transporte.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "camiones")
public class Camion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La placa es obligatoria")
    @Column(nullable = false, unique = true)
    private String placa;

    @NotBlank(message = "El tipo de vehiculo es obligatorio")
    @Column(nullable = false)
    private String tipoVehiculo;

    @OneToOne
    @JoinColumn(name = "conductor_id")
    @JsonIgnoreProperties("camion")
    private Conductor conductor;

    public Camion() {
    }

    public Camion(String placa, String tipoVehiculo) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}
