package com.unla.grupo24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo24.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
