package com.dam2.Practica1.controller;

import com.dam2.Practica1.dto.Entrada.EntradaCreateDTO;
import com.dam2.Practica1.dto.Entrada.EntradaDTO;
import com.dam2.Practica1.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas")
@CrossOrigin(origins = "*")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @GetMapping
    public ResponseEntity<List<EntradaDTO>> getAllEntradas() {
        return ResponseEntity.ok(entradaService.getAllEntradas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaDTO> getEntradaById(@PathVariable Long id) {
        return entradaService.getEntradaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EntradaDTO> createEntrada(@RequestBody EntradaCreateDTO entradaCreateDTO) {
        return new ResponseEntity<>(entradaService.createEntrada(entradaCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradaDTO> updateEntrada(@PathVariable Long id,
            @RequestBody EntradaCreateDTO entradaCreateDTO) {
        return entradaService.updateEntrada(id, entradaCreateDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrada(@PathVariable Long id) {
        if (entradaService.deleteEntrada(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
