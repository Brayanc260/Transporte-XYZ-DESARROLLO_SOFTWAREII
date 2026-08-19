package com.xyz.transporte.controller;

import com.xyz.transporte.dto.ConductorRequest;
import com.xyz.transporte.model.Conductor;
import com.xyz.transporte.service.ConductorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    private final ConductorService conductorService;

    public ConductorController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    // Solo ADMIN (ver SecurityConfig)
    @PostMapping
    public ResponseEntity<Conductor> crear(@Valid @RequestBody ConductorRequest request) {
        Conductor creado = conductorService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // ADMIN y SUPERVISOR
    @GetMapping
    public ResponseEntity<List<Conductor>> listar() {
        return ResponseEntity.ok(conductorService.listar());
    }

    // ADMIN y SUPERVISOR
    @GetMapping("/{id}")
    public ResponseEntity<Conductor> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(conductorService.obtenerPorId(id));
    }
}
