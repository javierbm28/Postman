package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    /*
    * Utiliza @Autowired para inyectar instancias de ComentarioRepository y PublicacionRepository
    * para acceder a las funcionalidades de continuidad y recuperación de datos.
    * */
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PublicacionRepository publicacionRepository;
    // Método para agregar un comentario a una publicación
    @Override
    public Comentario agregarComentario(Long publicacionId, Comentario comentario) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId).orElse(null);
        if (publicacion != null) {
            comentario.setPublicacion(publicacion);
            return comentarioRepository.save(comentario);
        }
        return null;
    }
    // Metodo para obtener todos los comentarios de una publicacion
    @Override
    public List<Comentario> obtenerComentariosPorPublicacion(Long publicacionId) {
        return comentarioRepository.findByPublicacionId(publicacionId);
    }
    // Metodo para eliminar un comentario por su ID
    @Override
    public void eliminarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}
