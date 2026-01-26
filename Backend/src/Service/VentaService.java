package Service;

import Clase.Venta;
import DTOs.Venta.VentaCreateDTO;
import DTOs.Venta.VentaDTO;
import Mapper.VentaMapper;
import Repository.UsuarioRepository;
import Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VentaMapper ventaMapper;

    public List<VentaDTO> getAllVentas() {
        return ventaMapper.toDTO(ventaRepository.findAll());
    }

    public Optional<VentaDTO> getVentaById(Long id) {
        return ventaRepository.findById(id).map(ventaMapper::toDTO);
    }

    public VentaDTO createVenta(VentaCreateDTO ventaCreateDTO) {
        Venta venta = ventaMapper.fromCreateUpdateDTO(ventaCreateDTO);

        usuarioRepository.findById(ventaCreateDTO.getUsuarioId())
                .ifPresent(venta::setUsuario);

        return ventaMapper.toDTO(ventaRepository.save(venta));
    }

    public Optional<VentaDTO> updateVenta(Long id, VentaCreateDTO ventaCreateDTO) {
        return ventaRepository.findById(id).map(venta -> {
            ventaMapper.updateEntityFromDTO(ventaCreateDTO, venta);

            usuarioRepository.findById(ventaCreateDTO.getUsuarioId())
                    .ifPresent(venta::setUsuario);

            return ventaMapper.toDTO(ventaRepository.save(venta));
        });
    }

    public boolean deleteVenta(Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
