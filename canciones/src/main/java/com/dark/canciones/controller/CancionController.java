package com.dark.canciones.controller;

import com.dark.canciones.entity.Cancion;
import com.dark.canciones.service.CancionService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canciones")
public class CancionController {

    @Autowired
    CancionService cancionService;

    @PostMapping
    public Cancion saveCancion(@RequestBody Cancion cancion){
        return cancionService.saveCancion(cancion);
    }

    @GetMapping
    public List<Cancion> getAllCanciones(){
        return cancionService.getAllCanciones();
    }

}
