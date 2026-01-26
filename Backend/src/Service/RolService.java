package Service;

import Clase.Rol;
import DTOs.Rol.RolCreateDTO;
import DTOs.Rol.RolDTO;
import Mapper.RolMapper;
import Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private RolMapper rolMapper;

    public List<RolDTO> getAllRoles() {
        return rolMapper.toDTO(rolRepository.findAll());
    }

    public Optional<RolDTO> getRolById(Long id) {
        return rolRepository.findById(id).map(rolMapper::toDTO);
    }

    public RolDTO createRol(RolCreateDTO rolCreateDTO) {
        Rol rol = rolMapper.fromCreateUpdateDTO(rolCreateDTO);
        return rolMapper.toDTO(rolRepository.save(rol));
    }

    public Optional<RolDTO> updateRol(Long id, RolCreateDTO rolCreateDTO) {
        return rolRepository.findById(id).map(rol -> {
            rolMapper.updateEntityFromDTO(rolCreateDTO, rol);
            return rolMapper.toDTO(rolRepository.save(rol));
        });
    }

    public boolean deleteRol(Long id) {
        if (rolRepository.existsById(id)) {
            rolRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
