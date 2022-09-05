package com.dark.proyectoartistas.controller;

import com.dark.proyectoartistas.entity.Student;
import com.dark.proyectoartistas.model.Subject;
import com.dark.proyectoartistas.service.StudentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getAll(){
        return studentService.getAll();
    }


    @PostMapping("/saveSubject/{studentId}")
    public ResponseEntity<Subject> saveSubject(@PathVariable("studentId") Long studentId, @RequestBody Subject subject) {
        Subject subjectNew = studentService.saveSubject(studentId, subject);
        return ResponseEntity.ok(subject);
    }

    @CircuitBreaker(name = "subjectCB", fallbackMethod = "fallBackGetSubject")
    @GetMapping("/subject/{studentId}")
    public ResponseEntity<Map<String, Object>> getSubject(@PathVariable Long studentId){
        return ResponseEntity.ok(studentService.getSubject(studentId));
    }

   public ResponseEntity<List<Subject>> fallBackGetSubject(@PathVariable ("studentId") Long studentId, RuntimeException e ){
        return new ResponseEntity("El estudiante " + studentId + " no tiene materias asociadas(CB)", HttpStatus.OK);
   }






}
