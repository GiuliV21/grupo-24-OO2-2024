package com.unla.grupo24.controller;

import com.unla.grupo24.entities.Pedido;
import com.unla.grupo24.entities.Producto;
import com.unla.grupo24.helpers.ViewRouteHelper;
import com.unla.grupo24.services.PedidoService;
import com.unla.grupo24.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String getAllPedidos(Model model) {
        List<Pedido> pedidos = pedidoService.findAll();
        model.addAttribute("pedidos", pedidos);
        return ViewRouteHelper.PEDIDOS;
    }

    @GetMapping("/{id}")
    public String getPedidoById(@PathVariable Long id, Model model) {
        Optional<Pedido> pedidoOptional = pedidoService.findById(id);
        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            model.addAttribute("pedido", pedido);
            return ViewRouteHelper.DETALLE_PEDIDO;
        } else {
            return "redirect:/pedidos";
        }
    }

    @GetMapping("/nuevo")
    public String nuevoPedidoForm(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("productos", productoService.findAll());
        return ViewRouteHelper.NUEVO_PEDIDO;
    }

    @PostMapping("/crear")
    public String createPedido(@ModelAttribute Pedido pedido, @RequestParam Long productoId) {
        Optional<Producto> productoOptional = productoService.findById(productoId);
        if (productoOptional.isPresent()) {
            pedido.setProducto(productoOptional.get());
            pedido.setFechaPedido(LocalDate.now()); // Asignar la fecha actual al pedido
            pedidoService.save(pedido);
        }
        return "redirect:/pedidos";
    }

    @GetMapping("/{id}/editar")
    public String editarPedidoForm(@PathVariable Long id, Model model) {
        Optional<Pedido> pedidoOptional = pedidoService.findById(id);
        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            model.addAttribute("pedido", pedido);
            model.addAttribute("productos", productoService.findAll());
            return ViewRouteHelper.EDITAR_PEDIDO;
        } else {
            return "redirect:/pedidos";
        }
    }

    @PostMapping("/{id}/actualizar")
    public String updatePedido(@PathVariable Long id, @ModelAttribute Pedido pedido, @RequestParam Long productoId) {
        Optional<Pedido> existingPedidoOptional = pedidoService.findById(id);
        Optional<Producto> productoOptional = productoService.findById(productoId);
        if (existingPedidoOptional.isPresent() && productoOptional.isPresent()) {
            Pedido existingPedido = existingPedidoOptional.get();
            existingPedido.setCantidadSolicitada(pedido.getCantidadSolicitada());
            existingPedido.setFechaPedido(pedido.getFechaPedido());
            existingPedido.setProducto(productoOptional.get());
            pedidoService.save(existingPedido);
        }
        return "redirect:/pedidos";
    }

    @PostMapping("/{id}/eliminar")
    public String deletePedido(@PathVariable Long id) {
        pedidoService.deleteById(id);
        return "redirect:/pedidos";
    }
}
