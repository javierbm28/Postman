package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;
    // Método para crear una nueva publicación y guardarla en la base de datos
    @Override
    public Publicacion crearPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }
    // Método para obtener todas las publicaciones almacenadas en la base de datos
    @Override
    public List<Publicacion> obtenerTodasPublicaciones() {
        return publicacionRepository.findAll();
    }
    // Método para obtener una publicación por su ID
    @Override
    public Publicacion obtenerPublicacionPorId(Long id) {
        return publicacionRepository.findById(id).orElse(null);
    }
    // Método para actualizar una publicación existente en la base de datos
    @Override
    public Publicacion actualizarPublicacion(Long id, Publicacion publicacion) {
        Publicacion existente = publicacionRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setTitulo(publicacion.getTitulo());
            existente.setContenido(publicacion.getContenido());
            // Actualiza los campos
            return publicacionRepository.save(existente);
        }
        return null;
    }
    // Método para eliminar una publicación por su ID
    @Override
    public void eliminarPublicacion(Long id) {
        publicacionRepository.deleteById(id);
    }
}
