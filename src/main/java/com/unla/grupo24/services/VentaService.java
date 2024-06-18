package com.unla.grupo24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo24.entities.Venta;
import com.unla.grupo24.repositories.VentaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
@Autowired
private VentaRepository ventaRepository;

public List<Venta> findAll() {
    return ventaRepository.findAll();
}

public Optional<Venta> findById(Long id) {
    return ventaRepository.findById(id);
}

public Venta save(Venta venta) {
    return ventaRepository.save(venta);
}

public void deleteById(Long id) {
    ventaRepository.deleteById(id);
}
}