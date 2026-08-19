package com.xyz.transporte.config;

import com.xyz.transporte.model.Rol;
import com.xyz.transporte.model.Usuario;
import com.xyz.transporte.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.findByUsername("admin").isEmpty()) {
            usuarioRepository.save(new Usuario("admin", passwordEncoder.encode("admin123"), Rol.ADMIN));
        }
        if (usuarioRepository.findByUsername("supervisor").isEmpty()) {
            usuarioRepository.save(new Usuario("supervisor", passwordEncoder.encode("supervisor123"), Rol.SUPERVISOR));
        }
    }
}
