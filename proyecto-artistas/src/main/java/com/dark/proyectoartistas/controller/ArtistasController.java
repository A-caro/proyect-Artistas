package com.dark.proyectoartistas.controller;

import com.dark.proyectoartistas.entity.Artistas;
import com.dark.proyectoartistas.model.Cancion;
import com.dark.proyectoartistas.service.ArtistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistasController {
    @Autowired
    ArtistasService artistasService;


    @GetMapping("/list")
    public List<Artistas> getArtistas(){
        return artistasService.getArtistas();
    }

    @PostMapping
    public Artistas addArtistas(@RequestBody Artistas artistas){
        return artistasService.addArtistas(artistas);
    }

    @PostMapping("/saveCnacion/{artistasId}")
    public ResponseEntity<Cancion> saveCancion(@PathVariable("artistasId") Long artistasId, @RequestBody Cancion cancion){
        Cancion newCancion = artistasService.saveCancion(artistasId, cancion);
        return ResponseEntity.ok(cancion);
    }
}
