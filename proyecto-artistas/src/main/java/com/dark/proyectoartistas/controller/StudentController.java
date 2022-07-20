package com.dark.proyectoartistas.controller;

import com.dark.proyectoartistas.model.Subject;
import com.dark.proyectoartistas.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/saveSubject/{studentId}")
    public ResponseEntity<Subject> saveSubject(@PathVariable("studentId") Long studentId, @RequestBody Subject subject) {
        Subject subjectNew = studentService.saveSubject(studentId, subject);
        return ResponseEntity.ok(subject);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Map<String, Object>> getSubject(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getSubject(id));
    }

}
