package com.dark.proyectoartistas.service;

import com.dark.proyectoartistas.entity.Artistas;
import com.dark.proyectoartistas.feignclients.CancionFeignClient;
import com.dark.proyectoartistas.model.Cancion;
import com.dark.proyectoartistas.repository.ArtistasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistasService {

    @Autowired
    CancionFeignClient cancionFeignClient;

    @Autowired
    ArtistasRepository artistasRepository;

    public List<Artistas> getArtistas(){
        return artistasRepository.findAll();
    }

    public Artistas addArtistas(Artistas artistas){
    return artistasRepository.save(artistas);
    }

 /*   public Cancion saveCancion(Long artistaId, Cancion cancion){
       cancion.setArtistaId(artistaId);
       Cancion newCancion = cancionFeignClient.saveCancion(cancion);
        return newCancion;
    }*/

    public Cancion saveCancion(Long artistaId, Cancion cancion){
        cancion.setArtistaId(artistaId);
       Cancion newCancion = cancionFeignClient.saveCancion(cancion);
        return newCancion;
    }

   public String getDatos(){
        List<Artistas> artistas = artistasRepository.findAll();
        return artistas.stream()
                .map(a -> a.getId() + " , " + a.getName() + " , " + a.getSurname())
                .collect(Collectors.joining("\n"));
   }


}
