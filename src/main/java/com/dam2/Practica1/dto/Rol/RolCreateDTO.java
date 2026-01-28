package com.dam2.Practica1.dto.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolCreateDTO {
    @NotBlank(message = "El nombre del rol es obligatorio")
    private String nombre;
}
