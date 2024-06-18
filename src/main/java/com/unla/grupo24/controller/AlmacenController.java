package com.unla.grupo24.controller;

import com.unla.grupo24.entities.Almacen;
import com.unla.grupo24.services.AlmacenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/almacenes")
public class AlmacenController {

    @Autowired
    private AlmacenService almacenService;

    @GetMapping
    public List<Almacen> getAllAlmacenes() {
        return almacenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Almacen> getAlmacenById(@PathVariable Long id) {
        Optional<Almacen> almacen = almacenService.findById(id);
        if (almacen.isPresent()) {
            return ResponseEntity.ok(almacen.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Almacen createAlmacen(@RequestBody Almacen almacen) {
        return almacenService.save(almacen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Almacen> updateAlmacen(@PathVariable Long id, @RequestBody Almacen almacen) {
        Optional<Almacen> existingAlmacen = almacenService.findById(id);
        if (existingAlmacen.isPresent()) {
            Almacen updatedAlmacen = existingAlmacen.get();
            updatedAlmacen.setCantidadActual(almacen.getCantidadActual());
            updatedAlmacen.setCantidadCritica(almacen.getCantidadCritica());
            updatedAlmacen.setUbicacion(almacen.getUbicacion());
            updatedAlmacen.setLotes(almacen.getLotes());
            almacenService.save(updatedAlmacen);
            return ResponseEntity.ok(updatedAlmacen);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlmacen(@PathVariable Long id) {
        if (almacenService.findById(id).isPresent()) {
            almacenService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
