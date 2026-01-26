package Service;

import Clase.Pelicula;
import DTOs.Pelicula.PeliculaCreateDTO;
import DTOs.Pelicula.PeliculaDTO;
import Mapper.PeliculaMapper;
import Repository.DirectorRepository;
import Repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private PeliculaMapper peliculaMapper;

    public List<PeliculaDTO> getAllPeliculas() {
        return peliculaMapper.toDTO(peliculaRepository.findAll());
    }

    public Optional<PeliculaDTO> getPeliculaById(Long id) {
        return peliculaRepository.findById(id).map(peliculaMapper::toDTO);
    }

    public PeliculaDTO createPelicula(PeliculaCreateDTO peliculaCreateDTO) {
        Pelicula pelicula = peliculaMapper.fromCreateUpdateDTO(peliculaCreateDTO);

        directorRepository.findById(peliculaCreateDTO.getDirectorId())
                .ifPresent(pelicula::setDirector);

        return peliculaMapper.toDTO(peliculaRepository.save(pelicula));
    }

    public Optional<PeliculaDTO> updatePelicula(Long id, PeliculaCreateDTO peliculaCreateDTO) {
        return peliculaRepository.findById(id).map(pelicula -> {
            peliculaMapper.updateEntityFromDTO(peliculaCreateDTO, pelicula);

            directorRepository.findById(peliculaCreateDTO.getDirectorId())
                    .ifPresent(pelicula::setDirector);

            return peliculaMapper.toDTO(peliculaRepository.save(pelicula));
        });
    }

    public boolean deletePelicula(Long id) {
        if (peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
