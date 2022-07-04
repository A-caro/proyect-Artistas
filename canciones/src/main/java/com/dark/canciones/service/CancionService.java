package com.dark.canciones.service;

import com.dark.canciones.entity.Cancion;
import com.dark.canciones.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancionService {

    @Autowired
    CancionRepository cancionRepository;

    public Cancion saveCancion(Cancion cancion){
        Cancion newCancion = cancionRepository.save(cancion);
        return newCancion;
    }

    public List<Cancion> getAllCanciones(){
        return cancionRepository.findAll();
    }

}
