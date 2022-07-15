package com.dark.proyectoartistas.feignclient;


import com.dark.proyectoartistas.model.Subject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name ="subjectservice")
@RequestMapping("/subject")

public interface SubjectFeignClient {

    @PostMapping()
    Subject saveSubject(@RequestBody Subject Subject);
}
