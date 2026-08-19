package com.xyz.transporte.controller;

import com.xyz.transporte.model.Camion;
import com.xyz.transporte.service.CamionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/asociaciones")
public class AsociacionController {

    private final CamionService camionService;

    public AsociacionController(CamionService camionService) {
        this.camionService = camionService;
    }

    @PutMapping("/camiones/{camionId}/conductores/{conductorId}")
    public ResponseEntity<Camion> asociar(@PathVariable Long camionId, @PathVariable Long conductorId) {
        Camion camion = camionService.asociarConductor(camionId, conductorId);
        return ResponseEntity.ok(camion);
    }

    @DeleteMapping("/camiones/{camionId}/conductor")
    public ResponseEntity<Camion> desasociar(@PathVariable Long camionId) {
        Camion camion = camionService.desasociarConductor(camionId);
        return ResponseEntity.ok(camion);
    }
}
