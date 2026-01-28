package com.dam2.Practica1;

import com.dam2.Practica1.model.Usuario;
import com.dam2.Practica1.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Practica1Application {

    public static void main(String[] args) {
        SpringApplication.run(Practica1Application.class, args);
    }

    @Bean
    public CommandLineRunner init(UsuarioRepository usuarioRepository) {
        return args -> {
            System.out.println("--------------------------------------");
            System.out.println("LISTADO DE USUARIOS Y CONTRASEÑAS:");
            usuarioRepository.findAll()
                    .forEach(u -> System.out.println("Usuario: " + u.getEmail() + " | Password: " + u.getPassword()));
            System.out.println("--------------------------------------");
        };
    }
}
