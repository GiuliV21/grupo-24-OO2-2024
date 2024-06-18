package com.unla.grupo24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo24.entities.ItemVenta;
import com.unla.grupo24.repositories.ItemVentaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVentaService {

    @Autowired
    private ItemVentaRepository itemVentaRepository;

    public List<ItemVenta> findAll() {
        return itemVentaRepository.findAll();
    }

    public Optional<ItemVenta> findById(Long id) {
        return itemVentaRepository.findById(id);
    }

    public ItemVenta save(ItemVenta itemVenta) {
        return itemVentaRepository.save(itemVenta);
    }

    public void deleteById(Long id) {
        itemVentaRepository.deleteById(id);
    }
}
