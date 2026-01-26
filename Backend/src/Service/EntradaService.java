package Service;

import Clase.Entrada;
import DTOs.Entrada.EntradaCreateDTO;
import DTOs.Entrada.EntradaDTO;
import Mapper.EntradaMapper;
import Repository.FuncionRepository;
import Repository.VentaRepository;
import Repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private FuncionRepository funcionRepository;

    @Autowired
    private EntradaMapper entradaMapper;

    public List<EntradaDTO> getAllEntradas() {
        return entradaMapper.toDTO(entradaRepository.findAll());
    }

    public Optional<EntradaDTO> getEntradaById(Long id) {
        return entradaRepository.findById(id).map(entradaMapper::toDTO);
    }

    public EntradaDTO createEntrada(EntradaCreateDTO entradaCreateDTO) {
        Entrada entrada = entradaMapper.fromCreateUpdateDTO(entradaCreateDTO);

        ventaRepository.findById(entradaCreateDTO.getVentaId())
                .ifPresent(entrada::setVenta);

        funcionRepository.findById(entradaCreateDTO.getFuncionId())
                .ifPresent(entrada::setFuncion);

        return entradaMapper.toDTO(entradaRepository.save(entrada));
    }

    public Optional<EntradaDTO> updateEntrada(Long id, EntradaCreateDTO entradaCreateDTO) {
        return entradaRepository.findById(id).map(entrada -> {
            entradaMapper.updateEntityFromDTO(entradaCreateDTO, entrada);

            ventaRepository.findById(entradaCreateDTO.getVentaId())
                    .ifPresent(entrada::setVenta);

            funcionRepository.findById(entradaCreateDTO.getFuncionId())
                    .ifPresent(entrada::setFuncion);

            return entradaMapper.toDTO(entradaRepository.save(entrada));
        });
    }

    public boolean deleteEntrada(Long id) {
        if (entradaRepository.existsById(id)) {
            entradaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
