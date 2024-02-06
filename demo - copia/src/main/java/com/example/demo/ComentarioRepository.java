package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    // Método personalizado para buscar comentarios por ID de publicación
    List<Comentario> findByPublicacionId(Long publicacionId);

}
