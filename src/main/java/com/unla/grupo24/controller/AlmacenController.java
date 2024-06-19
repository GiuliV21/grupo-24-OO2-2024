package com.unla.grupo24.controller;
import com.unla.grupo24.entities.Almacen;
import com.unla.grupo24.helpers.ViewRouteHelper;
import com.unla.grupo24.services.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/almacenes")
public class AlmacenController {

    @Autowired
    private AlmacenService almacenService;

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
        model.addAttribute("almacen", new Almacen());
        return ViewRouteHelper.ALMACENES_NUEVO;
    }

    @PostMapping("/crear")
    public String createAlmacen(@ModelAttribute Almacen almacen) {
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
