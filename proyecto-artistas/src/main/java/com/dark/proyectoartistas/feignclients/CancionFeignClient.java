package com.dark.proyectoartistas.feignclients;


import com.dark.proyectoartistas.model.Cancion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cancionservice")
@RequestMapping("/cancion")

public interface CancionFeignClient {

    @PostMapping
     Cancion saveCancion(@RequestBody Cancion cancion);

}
