package com.unla.grupo24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo24.entities.RolUsuario;
import com.unla.grupo24.repositories.RolUsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RolUsuarioService {

    @Autowired
    private RolUsuarioRepository rolUsuarioRepository;

    public List<RolUsuario> findAll() {
        return rolUsuarioRepository.findAll();
    }

    public Optional<RolUsuario> findById(int id) {
        return rolUsuarioRepository.findById(id);
    }

    public RolUsuario save(RolUsuario rolUsuario) {
        return rolUsuarioRepository.save(rolUsuario);
    }

    public void deleteById(int id) {
        rolUsuarioRepository.deleteById(id);
    }
}
