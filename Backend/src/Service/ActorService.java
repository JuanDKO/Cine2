package Service;

import Clase.Actor;
import DTOs.Actor.ActorCreateDTO;
import DTOs.Actor.ActorDTO;
import Mapper.ActorMapper;
import Repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorMapper actorMapper;

    public List<ActorDTO> getAllActors() {
        return actorMapper.toDTO(actorRepository.findAll());
    }

    public Optional<ActorDTO> getActorById(Long id) {
        return actorRepository.findById(id).map(actorMapper::toDTO);
    }

    public ActorDTO createActor(ActorCreateDTO actorCreateDTO) {
        Actor actor = actorMapper.fromCreateUpdateDTO(actorCreateDTO);
        return actorMapper.toDTO(actorRepository.save(actor));
    }

    public Optional<ActorDTO> updateActor(Long id, ActorCreateDTO actorCreateDTO) {
        return actorRepository.findById(id).map(actor -> {
            actorMapper.updateEntityFromDTO(actorCreateDTO, actor);
            return actorMapper.toDTO(actorRepository.save(actor));
        });
    }

    public boolean deleteActor(Long id) {
        if (actorRepository.existsById(id)) {
            actorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
