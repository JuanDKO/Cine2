package com.dam2.Practica1.controller;

import com.dam2.Practica1.dto.Sala.SalaCreateDTO;
import com.dam2.Practica1.dto.Sala.SalaDTO;
import com.dam2.Practica1.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
@CrossOrigin(origins = "*")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping
    public ResponseEntity<List<SalaDTO>> getAllSalas() {
        return ResponseEntity.ok(salaService.getAllSalas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaDTO> getSalaById(@PathVariable Long id) {
        return salaService.getSalaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SalaDTO> createSala(@RequestBody SalaCreateDTO salaCreateDTO) {
        return new ResponseEntity<>(salaService.createSala(salaCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaDTO> updateSala(@PathVariable Long id, @RequestBody SalaCreateDTO salaCreateDTO) {
        return salaService.updateSala(id, salaCreateDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id) {
        if (salaService.deleteSala(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
