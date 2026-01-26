package Service;

import Clase.Usuario;
import DTOs.Usuario.UsuarioCreateDTO;
import DTOs.Usuario.UsuarioDTO;
import Mapper.UsuarioMapper;
import Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

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
