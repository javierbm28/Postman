package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}
/*
* Interfaz que extiende JpaRepository para manipular entidades de tipo Publicacion en la base de datos
* */