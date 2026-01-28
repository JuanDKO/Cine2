package com.dam2.Practica1.controller;

import com.dam2.Practica1.dto.Funcion.FuncionCreateDTO;
import com.dam2.Practica1.dto.Funcion.FuncionDTO;
import com.dam2.Practica1.service.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funciones")
@CrossOrigin(origins = "*")
public class FuncionController {

    @Autowired
    private FuncionService funcionService;

    @GetMapping
    public ResponseEntity<List<FuncionDTO>> getAllFunciones() {
        return ResponseEntity.ok(funcionService.getAllFunciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionDTO> getFuncionById(@PathVariable Long id) {
        return funcionService.getFuncionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FuncionDTO> createFuncion(@RequestBody FuncionCreateDTO funcionCreateDTO) {
        return new ResponseEntity<>(funcionService.createFuncion(funcionCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionDTO> updateFuncion(@PathVariable Long id,
            @RequestBody FuncionCreateDTO funcionCreateDTO) {
        return funcionService.updateFuncion(id, funcionCreateDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncion(@PathVariable Long id) {
        if (funcionService.deleteFuncion(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
