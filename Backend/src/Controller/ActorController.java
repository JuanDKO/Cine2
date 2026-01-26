package Controller;

import DTOs.Actor.ActorCreateDTO;
import DTOs.Actor.ActorDTO;
import Service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acores")
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen, ajústalo según necesites
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping
    public ResponseEntity<List<ActorDTO>> getAllActors() {
        return ResponseEntity.ok(actorService.getAllActors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDTO> getActorById(@PathVariable Long id) {
        return actorService.getActorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ActorDTO> createActor(@RequestBody ActorCreateDTO actorCreateDTO) {
        return new ResponseEntity<>(actorService.createActor(actorCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActorDTO> updateActor(@PathVariable Long id, @RequestBody ActorCreateDTO actorCreateDTO) {
        return actorService.updateActor(id, actorCreateDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        if (actorService.deleteActor(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
