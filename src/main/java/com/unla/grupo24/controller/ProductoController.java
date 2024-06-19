package com.unla.grupo24.controller;

import com.unla.grupo24.entities.Producto;
import com.unla.grupo24.helpers.ViewRouteHelper;
import com.unla.grupo24.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String getAllProductos(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return ViewRouteHelper.PRODUCTOS;
    }

    @GetMapping("/{id}")
    public String getProductoById(@PathVariable Long id, Model model) {
        Optional<Producto> productoOptional = productoService.findById(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            model.addAttribute("producto", producto);
            return ViewRouteHelper.DETALLE_PRODUCTO;
        } else {
            return "redirect:/productos";
        }
    }

    @GetMapping("/nuevo")
    public String nuevoProductoForm(Model model) {
        model.addAttribute("producto", new Producto());
        return ViewRouteHelper.NUEVO_PRODUCTO;
    }

    @PostMapping("/crear")
    public String createProducto(@ModelAttribute Producto producto) {
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/{id}/editar")
    public String editarProductoForm(@PathVariable Long id, Model model) {
        Optional<Producto> productoOptional = productoService.findById(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            model.addAttribute("producto", producto);
            return ViewRouteHelper.EDITAR_PRODUCTO;
        } else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/{id}/actualizar")
    public String updateProducto(@PathVariable Long id, @ModelAttribute Producto producto) {
        Optional<Producto> existingProductoOptional = productoService.findById(id);
        if (existingProductoOptional.isPresent()) {
            Producto existingProducto = existingProductoOptional.get();
            existingProducto.setCodigo(producto.getCodigo());
            existingProducto.setDescripcion(producto.getDescripcion());
            existingProducto.setCosto(producto.getCosto());
            existingProducto.setPrecioVenta(producto.getPrecioVenta());
            productoService.save(existingProducto);
        }
        return "redirect:/productos";
    }

    @PostMapping("/{id}/eliminar")
    public String deleteProducto(@PathVariable Long id) {
        productoService.deleteById(id);
        return "redirect:/productos";
    }
}
