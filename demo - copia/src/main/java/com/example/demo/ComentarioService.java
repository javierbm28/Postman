package com.example.demo;

import java.util.List;

public interface ComentarioService {
    Comentario agregarComentario(Long publicacionId, Comentario comentario);
    List<Comentario> obtenerComentariosPorPublicacion(Long publicacionId);
    void eliminarComentario(Long id);
}

/*
 *
 * Esta Interfaz define los metodos para manipular los comentarios
 *
 * */