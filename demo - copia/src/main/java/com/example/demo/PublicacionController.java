package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    // Método para crear una nueva publicación
    @PostMapping
    public ResponseEntity<Publicacion> crearPublicacion(@RequestBody Publicacion publicacion) {
        Publicacion nuevaPublicacion = publicacionService.crearPublicacion(publicacion);
        return new ResponseEntity<>(nuevaPublicacion, HttpStatus.CREATED);
    }
    // Método para obtener todas las publicaciones
    @GetMapping
    public ResponseEntity<List<Publicacion>> obtenerTodasPublicaciones() {
        List<Publicacion> publicaciones = publicacionService.obtenerTodasPublicaciones();
        return new ResponseEntity<>(publicaciones, HttpStatus.OK);
    }
    // Método para obtener una publicación por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacionPorId(@PathVariable Long id) {
        Publicacion publicacion = publicacionService.obtenerPublicacionPorId(id);
        return publicacion != null ?
                new ResponseEntity<>(publicacion, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // Método para actualizar una publicación existente
    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
        Publicacion actualizada = publicacionService.actualizarPublicacion(id, publicacion);
        return actualizada != null ?
                new ResponseEntity<>(actualizada, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // Método para eliminar una publicación por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable Long id) {
        publicacionService.eliminarPublicacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
