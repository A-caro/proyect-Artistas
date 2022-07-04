package com.dark.proyectoartistas.repository;

import com.dark.proyectoartistas.entity.Artistas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistasRepository extends JpaRepository<Artistas, Long> {
}
