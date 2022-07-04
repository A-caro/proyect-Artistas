package com.dark.proyectoartistas.feignclients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cancionservice")
@RequestMapping("/cancion")
public class CancionFeignClient {



}
