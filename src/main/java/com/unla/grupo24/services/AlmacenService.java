package com.unla.grupo24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo24.entities.Almacen;
import com.unla.grupo24.repositories.AlmacenRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenService {

    @Autowired
    private AlmacenRepository almacenRepository;

    public List<Almacen> findAll() {
        return almacenRepository.findAll();
    }

    public Optional<Almacen> findById(Long id) {
        return almacenRepository.findById(id);
    }

    public Almacen save(Almacen almacen) {
        return almacenRepository.save(almacen);
    }

    public void deleteById(Long id) {
        almacenRepository.deleteById(id);
    }
}
