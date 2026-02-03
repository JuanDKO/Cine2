package com.dam2.Practica1.service;

import com.dam2.Practica1.model.Usuario;
import com.dam2.Practica1.dto.Usuario.UsuarioCreateDTO;
import com.dam2.Practica1.dto.Usuario.UsuarioDTO;
import com.dam2.Practica1.mapper.UsuarioMapper;
import com.dam2.Practica1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private com.dam2.Practica1.repository.RolRepository rolRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioMapper.toDTO(usuarioRepository.findAll());
    }

    public Optional<UsuarioDTO> getUsuarioById(Long id) {
        return usuarioRepository.findById(id).map(usuarioMapper::toDTO);
    }

    public UsuarioDTO createUsuario(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = usuarioMapper.fromCreateUpdateDTO(usuarioCreateDTO);

        // Asignar rol "usuario" por defecto
        com.dam2.Practica1.model.Rol rolUsuario = rolRepository.findByNombre("usuario")
                .orElseThrow(() -> new RuntimeException("Error: Rol 'usuario' no encontrado."));

        if (usuario.getRoles() == null) {
            usuario.setRoles(new java.util.HashSet<>());
        }
        usuario.getRoles().add(rolUsuario);

        return usuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    public Optional<UsuarioDTO> updateUsuario(Long id, UsuarioCreateDTO usuarioCreateDTO) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuarioMapper.updateEntityFromDTO(usuarioCreateDTO, usuario);
            return usuarioMapper.toDTO(usuarioRepository.save(usuario));
        });
    }

    public boolean deleteUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
