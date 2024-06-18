package services;

import entities.ItemVenta;
import repositories.ItemVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
