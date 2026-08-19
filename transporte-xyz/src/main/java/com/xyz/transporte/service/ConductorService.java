package com.xyz.transporte.service;

import com.xyz.transporte.dto.ConductorRequest;
import com.xyz.transporte.model.Conductor;
import com.xyz.transporte.repository.ConductorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorService {

    private final ConductorRepository conductorRepository;

    public ConductorService(ConductorRepository conductorRepository) {
        this.conductorRepository = conductorRepository;
    }

    public List<Conductor> listar() {
        return conductorRepository.findAll();
    }

    public Conductor obtenerPorId(Long id) {
        return conductorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Conductor no encontrado con id " + id));
    }

    public Conductor crear(ConductorRequest request) {
        if (conductorRepository.findByDocumento(request.getDocumento()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un conductor con el documento " + request.getDocumento());
        }
        Conductor conductor = new Conductor(request.getNombre(), request.getDocumento());
        return conductorRepository.save(conductor);
    }
}
