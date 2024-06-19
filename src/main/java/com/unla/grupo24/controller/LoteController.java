package com.unla.grupo24.controller;

import com.unla.grupo24.entities.Almacen;
import com.unla.grupo24.entities.Lote;
import com.unla.grupo24.entities.Proveedor;
import com.unla.grupo24.helpers.ViewRouteHelper;
import com.unla.grupo24.services.AlmacenService;
import com.unla.grupo24.services.LoteService;
import com.unla.grupo24.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lotes")
public class LoteController {

    @Autowired
    private LoteService loteService;

    @Autowired
    private AlmacenService almacenService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("")
    public String getAllLotes(Model model) {
        List<Lote> lotes = loteService.findAll();
        model.addAttribute("lotes", lotes);
        return ViewRouteHelper.LOTES;
    }

    @GetMapping("/{id}")
    public String getLoteById(@PathVariable Long id, Model model) {
        Optional<Lote> loteOptional = loteService.findById(id);
        if (loteOptional.isPresent()) {
            Lote lote = loteOptional.get();
            model.addAttribute("lote", lote);
            return ViewRouteHelper.DETALLE_LOTE;
        } else {
            return "redirect:/lotes";
        }
    }

    @GetMapping("/nuevo")
    public String nuevoLoteForm(Model model) {
        model.addAttribute("lote", new Lote());
        model.addAttribute("almacenes", almacenService.findAll());
        model.addAttribute("proveedores", proveedorService.findAll());
        return ViewRouteHelper.NUEVO_LOTE;
    }

    @PostMapping("/crear")
    public String createLote(@ModelAttribute Lote lote, @RequestParam Long almacenId, @RequestParam Long proveedorId) {
        Optional<Almacen> almacenOptional = almacenService.findById(almacenId);
        Optional<Proveedor> proveedorOptional = proveedorService.findById(proveedorId);
        if (almacenOptional.isPresent() && proveedorOptional.isPresent()) {
            lote.setAlmacen(almacenOptional.get());
            lote.setProveedor(proveedorOptional.get());
            lote.setFechaRecepcion(LocalDate.now());
            loteService.save(lote);
        }
        return "redirect:/lotes";
    }

    @GetMapping("/{id}/editar")
    public String editarLoteForm(@PathVariable Long id, Model model) {
        Optional<Lote> loteOptional = loteService.findById(id);
        if (loteOptional.isPresent()) {
            Lote lote = loteOptional.get();
            model.addAttribute("lote", lote);
            model.addAttribute("almacenes", almacenService.findAll());
            model.addAttribute("proveedores", proveedorService.findAll());
            return ViewRouteHelper.EDITAR_LOTE;
        } else {
            return "redirect:/lotes";
        }
    }

    @PostMapping("/{id}/actualizar")
    public String updateLote(@PathVariable Long id, @ModelAttribute Lote lote, @RequestParam Long almacenId, @RequestParam Long proveedorId) {
        Optional<Lote> existingLoteOptional = loteService.findById(id);
        Optional<Almacen> almacenOptional = almacenService.findById(almacenId);
        Optional<Proveedor> proveedorOptional = proveedorService.findById(proveedorId);
        if (existingLoteOptional.isPresent() && almacenOptional.isPresent() && proveedorOptional.isPresent()) {
            Lote existingLote = existingLoteOptional.get();
            existingLote.setCantidadRecibida(lote.getCantidadRecibida());
            existingLote.setFechaRecepcion(lote.getFechaRecepcion());
            existingLote.setPrecioCompra(lote.getPrecioCompra());
            existingLote.setAlmacen(almacenOptional.get());
            existingLote.setProveedor(proveedorOptional.get());
            loteService.save(existingLote);
        }
        return "redirect:/lotes";
    }

    @PostMapping("/{id}/eliminar")
    public String deleteLote(@PathVariable Long id) {
        loteService.deleteById(id);
        return "redirect:/lotes";
    }
}
