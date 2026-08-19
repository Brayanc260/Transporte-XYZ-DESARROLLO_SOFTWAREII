package com.xyz.transporte.dto;

import jakarta.validation.constraints.NotBlank;

public class CamionRequest {

    @NotBlank(message = "La placa es obligatoria")
    private String placa;

    @NotBlank(message = "El tipo de vehiculo es obligatorio")
    private String tipoVehiculo;

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
}
