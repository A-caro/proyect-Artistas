package com.dark.canciones.repository;

import com.dark.canciones.entity.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository <Cancion, Long> {
}
