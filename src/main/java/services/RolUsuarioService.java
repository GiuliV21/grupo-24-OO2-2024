package services;

import entities.RolUsuario;
import repositories.RolUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolUsuarioService {

    @Autowired
    private RolUsuarioRepository rolUsuarioRepository;

    public List<RolUsuario> findAll() {
        return rolUsuarioRepository.findAll();
    }

    public Optional<RolUsuario> findById(Long id) {
        return rolUsuarioRepository.findById(id);
    }

    public RolUsuario save(RolUsuario rolUsuario) {
        return rolUsuarioRepository.save(rolUsuario);
    }

    public void deleteById(Long id) {
        rolUsuarioRepository.deleteById(id);
    }
}
