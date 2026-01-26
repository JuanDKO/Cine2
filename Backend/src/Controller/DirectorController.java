package Controller;

import DTOs.Director.DirectorCreateDTO;
import DTOs.Director.DirectorDTO;
import Service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directores")
@CrossOrigin(origins = "*")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<DirectorDTO>> getAllDirectores() {
        return ResponseEntity.ok(directorService.getAllDirectores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorDTO> getDirectorById(@PathVariable Long id) {
        return directorService.getDirectorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DirectorDTO> createDirector(@RequestBody DirectorCreateDTO directorCreateDTO) {
        return new ResponseEntity<>(directorService.createDirector(directorCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectorDTO> updateDirector(@PathVariable Long id,
            @RequestBody DirectorCreateDTO directorCreateDTO) {
        return directorService.updateDirector(id, directorCreateDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable Long id) {
        if (directorService.deleteDirector(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
