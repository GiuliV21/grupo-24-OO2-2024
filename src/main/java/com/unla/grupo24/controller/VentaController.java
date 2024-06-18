package com.unla.grupo24.controller;

import com.unla.grupo24.entities.Venta;
import com.unla.grupo24.services.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {
        Optional<Venta> venta = ventaService.findById(id);
        if (venta.isPresent()) {
            return ResponseEntity.ok(venta.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Venta createVenta(@RequestBody Venta venta) {
        return ventaService.save(venta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Long id, @RequestBody Venta venta) {
        Optional<Venta> existingVenta = ventaService.findById(id);
        if (existingVenta.isPresent()) {
            Venta updatedVenta = existingVenta.get();
            updatedVenta.setCliente(venta.getCliente());
            updatedVenta.setFecha(venta.getFecha());
            updatedVenta.setTotal(venta.getTotal());
            updatedVenta.setItemsVenta(venta.getItemsVenta());
            ventaService.save(updatedVenta);
            return ResponseEntity.ok(updatedVenta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        if (ventaService.findById(id).isPresent()) {
            ventaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
