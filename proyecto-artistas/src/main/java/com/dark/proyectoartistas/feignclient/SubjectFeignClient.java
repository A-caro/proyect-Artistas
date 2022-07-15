package com.dark.proyectoartistas.feignclient;


import com.dark.proyectoartistas.model.Subject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name ="subjectservice")
@RequestMapping("/subject")

public interface SubjectFeignClient {

    @PostMapping()
    Subject saveSubject(@RequestBody Subject Subject);

    @GetMapping("/student/{studentId}")
    List<Subject> getSubject(@PathVariable("studentId") Long studentId);
}
