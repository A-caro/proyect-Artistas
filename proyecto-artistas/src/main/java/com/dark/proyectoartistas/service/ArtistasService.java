package com.dark.proyectoartistas.service;

import com.dark.proyectoartistas.entity.Artistas;
import com.dark.proyectoartistas.repository.ArtistasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistasService {

    @Autowired
    ArtistasRepository artistasRepository;

    public List<Artistas> getArtistas(){
        return artistasRepository.findAll();
    }

    public Artistas addArtistas(Artistas artistas){
    return artistasRepository.save(artistas);
    }


}
