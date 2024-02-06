package com.example.demo;

import java.util.List;

public interface PublicacionService {
    Publicacion crearPublicacion(Publicacion publicacion);
    List<Publicacion> obtenerTodasPublicaciones();
    Publicacion obtenerPublicacionPorId(Long id);
    Publicacion actualizarPublicacion(Long id, Publicacion publicacion);
    void eliminarPublicacion(Long id);
}
/*
*
* Esta Interfaz define los metodos para manipular las publicaciones
*
* */