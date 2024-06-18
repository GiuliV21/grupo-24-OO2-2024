package com.unla.grupo24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo24.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
