package com.dam2.Practica1.repository;

import com.dam2.Practica1.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {
    List<Entrada> findByFuncionId(Long funcionId);

    List<Entrada> findByVentaUsuarioId(Long usuarioId);
}
