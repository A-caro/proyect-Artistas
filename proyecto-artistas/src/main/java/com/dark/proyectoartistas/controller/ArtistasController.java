package com.dark.proyectoartistas.controller;

import com.dark.proyectoartistas.entity.Artistas;
import com.dark.proyectoartistas.model.Cancion;
import com.dark.proyectoartistas.service.ArtistasService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

   /* @CircuitBreaker(name = "cancionesCB", fallbackMethod = "fallBackSaveCancion")
    @PostMapping("/saveCancion/{artistaId}")
    public Cancion saveCancion(@PathVariable("artistaId") Long artistaId, @RequestBody Cancion cancion){
        return artistasService.saveCancion(artistaId, cancion);
    }*/

    @CircuitBreaker(name = "cancionesCB", fallbackMethod = "fallBackSaveCancion")
    @PostMapping("/saveCancion/{artistaId}")
    public ResponseEntity<Cancion> saveCancion(@PathVariable("artistaId") Long artistaId, @RequestBody Cancion cancion) {
        Cancion cancionNew = artistasService.saveCancion(artistaId, cancion);
        return ResponseEntity.ok(cancion);
        /*cancion.setArtistaId(artistaId);
        return ResponseEntity.ok().body(artistasService.saveCancion(cancion));*/
    }

    @GetMapping("/datos")
    public String getDatos(){
        return artistasService.getDatos();
    }


    private ResponseEntity<Cancion> fallBackSaveCancion(@PathVariable("artistaId") Long artistaId, @RequestBody Cancion cancion, RuntimeException exception){
        return new ResponseEntity("El artista " + artistaId + "  no puede relacionarse con una cancion()CB",  HttpStatus.OK);
    }


}
