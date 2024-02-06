package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    // Metodo para agregar un comentario a una publicacion especifica
    @PostMapping
    public ResponseEntity<Comentario> agregarComentario(@PathVariable Long postId, @RequestBody Comentario comentario) {
        Comentario nuevoComentario = comentarioService. agregarComentario(postId, comentario);
        return new ResponseEntity<>(nuevoComentario, HttpStatus.CREATED);
    }
    // Metodo para obtener todos los comentarios de una publicacion especifica
    @GetMapping
    public ResponseEntity<List<Comentario>> obtenerComentariosPorPublicacion(@PathVariable Long postId) {
        List<Comentario> comentarios = comentarioService.obtenerComentariosPorPublicacion(postId);
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }
    // Metodo para eliminar un comentario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
