package Service;

import Clase.Funcion;
import DTOs.Funcion.FuncionCreateDTO;
import DTOs.Funcion.FuncionDTO;
import Mapper.FuncionMapper;
import Repository.PeliculaRepository;
import Repository.SalaRepository;
import Repository.FuncionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionService {

    @Autowired
    private FuncionRepository funcionRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private FuncionMapper funcionMapper;

    public List<FuncionDTO> getAllFunciones() {
        return funcionMapper.toDTO(funcionRepository.findAll());
    }

    public Optional<FuncionDTO> getFuncionById(Long id) {
        return funcionRepository.findById(id).map(funcionMapper::toDTO);
    }

    public FuncionDTO createFuncion(FuncionCreateDTO funcionCreateDTO) {
        Funcion funcion = funcionMapper.fromCreateUpdateDTO(funcionCreateDTO);

        peliculaRepository.findById(funcionCreateDTO.getPeliculaId())
                .ifPresent(funcion::setPelicula);

        salaRepository.findById(funcionCreateDTO.getSalaId())
                .ifPresent(funcion::setSala);

        return funcionMapper.toDTO(funcionRepository.save(funcion));
    }

    public Optional<FuncionDTO> updateFuncion(Long id, FuncionCreateDTO funcionCreateDTO) {
        return funcionRepository.findById(id).map(funcion -> {
            funcionMapper.updateEntityFromDTO(funcionCreateDTO, funcion);

            peliculaRepository.findById(funcionCreateDTO.getPeliculaId())
                    .ifPresent(funcion::setPelicula);

            salaRepository.findById(funcionCreateDTO.getSalaId())
                    .ifPresent(funcion::setSala);

            return funcionMapper.toDTO(funcionRepository.save(funcion));
        });
    }

    public boolean deleteFuncion(Long id) {
        if (funcionRepository.existsById(id)) {
            funcionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
