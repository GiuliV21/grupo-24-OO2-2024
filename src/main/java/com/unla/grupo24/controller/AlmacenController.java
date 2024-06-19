package com.unla.grupo24.controller;
import com.unla.grupo24.entities.Almacen;
import com.unla.grupo24.entities.Producto;
import com.unla.grupo24.entities.Stock;
import com.unla.grupo24.helpers.ViewRouteHelper;
import com.unla.grupo24.services.AlmacenService;
import com.unla.grupo24.services.ProductoService;
import com.unla.grupo24.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/almacenes")
public class AlmacenController {

    @Autowired
    private AlmacenService almacenService;

    @Autowired
    private ProductoService productoService;
    @Autowired
    private StockService stockService;
    
    @GetMapping("")
    public String getAllAlmacenes(Model model) {
        List<Almacen> almacenes = almacenService.findAll();
        model.addAttribute("almacenes", almacenes);
        return ViewRouteHelper.ALMACENES;
    }

    @GetMapping("/{id}")
    public String getAlmacenById(@PathVariable Long id, Model model) {
        Optional<Almacen> almacenOptional = almacenService.findById(id);
        if (almacenOptional.isPresent()) {
            Almacen almacen = almacenOptional.get();
            model.addAttribute("almacen", almacen);
            return ViewRouteHelper.ALMACENES_MOSTRAR;
        } else {
            return "redirect:/almacenes";
        }
    }  
    
    @GetMapping("/nuevo")
    public String nuevoAlmacenForm(Model model) {
        Almacen almacen = new Almacen();
        List<Producto> productos = productoService.findAll(); 
        List<Stock> stocks = stockService.findAll(); 
        model.addAttribute("almacen", almacen);
        model.addAttribute("productos", productos); 
        model.addAttribute("stocks", stocks);
        return ViewRouteHelper.ALMACENES_NUEVO;
    }


    @PostMapping("/crear")
    public String createAlmacen(@ModelAttribute Almacen almacen, @RequestParam("idProducto") Long idProducto) {
    	 Optional<Producto> producto = productoService.findById(idProducto);
    	 Stock stock = new Stock();
          stock.setProducto(producto.get());
          stockService.save(stock);
          almacen.setStock(stock);
          almacenService.save(almacen);
          return "redirect:/almacenes";
    }

    @GetMapping("/{id}/editar")
    public String editarAlmacenForm(@PathVariable Long id, Model model) {
        Optional<Almacen> almacenOptional = almacenService.findById(id);
        if (almacenOptional.isPresent()) {
            Almacen almacen = almacenOptional.get();
            model.addAttribute("almacen", almacen);
            return ViewRouteHelper.ALMACENES_EDITAR;
        } else {
            return "redirect:/almacenes";
        }
    }

    @PostMapping("/{id}/actualizar")
    public String updateAlmacen(@PathVariable Long id, @ModelAttribute Almacen almacen) {
        Optional<Almacen> existingAlmacenOptional = almacenService.findById(id);
        if (existingAlmacenOptional.isPresent()) {
            Almacen existingAlmacen = existingAlmacenOptional.get();
            existingAlmacen.setCantidadActual(almacen.getCantidadActual());
            existingAlmacen.setCantidadCritica(almacen.getCantidadCritica());
            existingAlmacen.setUbicacion(almacen.getUbicacion());
            almacenService.save(existingAlmacen);
        }
        return "redirect:/almacenes";
    }

    @PostMapping("/{id}/eliminar")
    public String deleteAlmacen(@PathVariable Long id) {
        almacenService.deleteById(id);
        return "redirect:/almacenes";
    }
}
