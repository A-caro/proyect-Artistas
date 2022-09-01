package com.dark.canciones.controller;


import com.dark.canciones.entity.Subject;
import com.dark.canciones.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public List<Subject> getAll(){
        return subjectService.getAll();
    }

    @GetMapping("/subject/{studentId}")
    public ResponseEntity<Optional<List<Subject>>> getSubjectCorrect(@PathVariable Long studentId){
        return ResponseEntity.ok(subjectService.getSubjectCorrect(studentId));
    }

    @PostMapping
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject) {
        Subject subjectNew = subjectService.saveSubject(subject);
        return ResponseEntity.ok(subjectNew);
    }



}
