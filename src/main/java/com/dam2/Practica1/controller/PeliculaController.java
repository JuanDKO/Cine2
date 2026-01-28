package com.dam2.Practica1.controller;

import com.dam2.Practica1.dto.Pelicula.PeliculaCreateDTO;
import com.dam2.Practica1.dto.Pelicula.PeliculaDTO;
import com.dam2.Practica1.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
@CrossOrigin(origins = "*")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<PeliculaDTO>> getAllPeliculas() {
        return ResponseEntity.ok(peliculaService.getAllPeliculas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> getPeliculaById(@PathVariable Long id) {
        return peliculaService.getPeliculaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PeliculaDTO> createPelicula(@RequestBody PeliculaCreateDTO peliculaCreateDTO) {
        return new ResponseEntity<>(peliculaService.createPelicula(peliculaCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> updatePelicula(@PathVariable Long id,
            @RequestBody PeliculaCreateDTO peliculaCreateDTO) {
        return peliculaService.updatePelicula(id, peliculaCreateDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePelicula(@PathVariable Long id) {
        if (peliculaService.deletePelicula(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
