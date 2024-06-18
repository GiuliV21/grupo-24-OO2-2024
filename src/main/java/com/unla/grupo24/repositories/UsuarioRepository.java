package com.unla.grupo24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo24.entities.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombreUsuario(String nombreUsuario);
}

