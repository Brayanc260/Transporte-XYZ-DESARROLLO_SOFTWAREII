package com.xyz.transporte.controller;

import com.xyz.transporte.dto.CamionRequest;
import com.xyz.transporte.model.Camion;
import com.xyz.transporte.service.CamionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camiones")
public class CamionController {

    private final CamionService camionService;

    public CamionController(CamionService camionService) {
        this.camionService = camionService;
    }

    // Solo ADMIN (ver SecurityConfig)
    @PostMapping
    public ResponseEntity<Camion> crear(@Valid @RequestBody CamionRequest request) {
        Camion creado = camionService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // ADMIN y SUPERVISOR
    @GetMapping
    public ResponseEntity<List<Camion>> listar() {
        return ResponseEntity.ok(camionService.listar());
    }

    // ADMIN y SUPERVISOR
    @GetMapping("/{id}")
    public ResponseEntity<Camion> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(camionService.obtenerPorId(id));
    }
}
