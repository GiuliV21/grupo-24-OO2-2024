package com.unla.grupo24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo24.entities.Producto;
import com.unla.grupo24.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> findDistinctProductosByAlmacen() {
        // Obtener todos los productos
        List<Producto> productos = productoRepository.findAll();

        // Utilizar Stream API para obtener una lista de productos únicos
        List<Producto> productosUnicos = productos.stream()
                                            .distinct() // Eliminar duplicados
                                            .collect(Collectors.toList());

        return productosUnicos;
    }
}
