package Service;

import Clase.Director;
import DTOs.Director.DirectorCreateDTO;
import DTOs.Director.DirectorDTO;
import Mapper.DirectorMapper;
import Repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private DirectorMapper directorMapper;

    public List<DirectorDTO> getAllDirectores() {
        return directorMapper.toDTO(directorRepository.findAll());
    }

    public Optional<DirectorDTO> getDirectorById(Long id) {
        return directorRepository.findById(id).map(directorMapper::toDTO);
    }

    public DirectorDTO createDirector(DirectorCreateDTO directorCreateDTO) {
        Director director = directorMapper.fromCreateUpdateDTO(directorCreateDTO);
        return directorMapper.toDTO(directorRepository.save(director));
    }

    public Optional<DirectorDTO> updateDirector(Long id, DirectorCreateDTO directorCreateDTO) {
        return directorRepository.findById(id).map(director -> {
            directorMapper.updateEntityFromDTO(directorCreateDTO, director);
            return directorMapper.toDTO(directorRepository.save(director));
        });
    }

    public boolean deleteDirector(Long id) {
        if (directorRepository.existsById(id)) {
            directorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
