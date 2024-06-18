package com.unla.grupo24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo24.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
