package com.dark.canciones.controller;


import com.dark.canciones.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;




}
