package com.unla.grupo24.controller;

import com.unla.grupo24.entities.ItemVenta;
import com.unla.grupo24.entities.Producto;
import com.unla.grupo24.entities.Venta;
import com.unla.grupo24.services.ProductoService;
import com.unla.grupo24.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String listarVentas(Model model) {
        List<Venta> ventas = ventaService.findAll();
        model.addAttribute("ventas", ventas);
        return "venta/index"; 
    }

    @GetMapping("/nueva")
    public String nuevaVentaForm(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("productos", productoService.findAll());
        return "venta/nuevaVenta";
    }

    @PostMapping("/crear")
    public String crearVenta(@ModelAttribute("venta") Venta venta,
                             @RequestParam(name = "productos") List<Long> idsProductos,
                             @RequestParam(name = "cantidades") List<Integer> cantidades,
                             Model model) {
        Set<ItemVenta> itemsVenta = new HashSet<>();
        double total = 0.0;

        if (idsProductos.size() != cantidades.size()) {
            model.addAttribute("error", "Discrepancia entre los productos y las cantidades proporcionadas.");
            return "venta/nuevaVenta";
        }

        for (int i = 0; i < idsProductos.size(); i++) {
            Optional<Producto> productoOptional = productoService.findById(idsProductos.get(i));
            if (productoOptional.isPresent()) {
                Producto producto = productoOptional.get();
                int cantidad = cantidades.get(i);
                ItemVenta itemVenta = new ItemVenta();
                itemVenta.setProducto(producto);
                itemVenta.setCantidad(cantidad);
                itemVenta.setPrecioUnitario(producto.getPrecioVenta());
                itemsVenta.add(itemVenta);
                total += itemVenta.getSubtotal(); // Calcular subtotal del item
            } else {
                model.addAttribute("error", "Producto no encontrado");
                return "venta/nuevaVenta";
            }
        }

        venta.setItemsVenta(itemsVenta);
        venta.setTotal(total);
        ventaService.save(venta);

        return "redirect:/ventas";
    }

    @GetMapping("/{id}/eliminar")
    public String eliminarVenta(@PathVariable Long id) {
        ventaService.deleteById(id);
        return "redirect:/ventas";
    }
}