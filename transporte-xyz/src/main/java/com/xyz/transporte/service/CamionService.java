package com.xyz.transporte.service;

import com.xyz.transporte.dto.CamionRequest;
import com.xyz.transporte.model.Camion;
import com.xyz.transporte.model.Conductor;
import com.xyz.transporte.repository.CamionRepository;
import com.xyz.transporte.repository.ConductorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamionService {

    private final CamionRepository camionRepository;
    private final ConductorRepository conductorRepository;

    public CamionService(CamionRepository camionRepository, ConductorRepository conductorRepository) {
        this.camionRepository = camionRepository;
        this.conductorRepository = conductorRepository;
    }

    public List<Camion> listar() {
        return camionRepository.findAll();
    }

    public Camion obtenerPorId(Long id) {
        return camionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Camion no encontrado con id " + id));
    }

    public Camion crear(CamionRequest request) {
        if (camionRepository.findByPlaca(request.getPlaca()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un camion con la placa " + request.getPlaca());
        }
        Camion camion = new Camion(request.getPlaca(), request.getTipoVehiculo());
        return camionRepository.save(camion);
    }

    public Camion asociarConductor(Long camionId, Long conductorId) {
        Camion camion = obtenerPorId(camionId);
        Conductor conductor = conductorRepository.findById(conductorId)
                .orElseThrow(() -> new IllegalArgumentException("Conductor no encontrado con id " + conductorId));
        camion.setConductor(conductor);
        return camionRepository.save(camion);
    }

    public Camion desasociarConductor(Long camionId) {
        Camion camion = obtenerPorId(camionId);
        camion.setConductor(null);
        return camionRepository.save(camion);
    }
}
