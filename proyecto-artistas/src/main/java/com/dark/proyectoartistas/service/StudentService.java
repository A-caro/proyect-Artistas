package com.dark.proyectoartistas.service;


import com.dark.proyectoartistas.entity.Student;
import com.dark.proyectoartistas.feignclient.SubjectFeignClient;
import com.dark.proyectoartistas.model.Subject;
import com.dark.proyectoartistas.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    SubjectFeignClient subjectFeignClient;


    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAll(){
       return studentRepository.findAll();
    }

    public Optional<Student> getStudent(Long studentId){
        return studentRepository.findById(studentId);
    }


    public Subject saveSubject(Long studentId, Subject subject){
        subject.setStudentId(studentId);
        Subject subjectNew = subjectFeignClient.saveSubject(subject);
        return subjectNew;
    }

    public Map<String, Object> getSubject(Long studentId){
        Map<String, Object> subjectByStudent = new HashMap<>();
        Optional<Student> student = this.getStudent(studentId);
        List<Subject> subjects = subjectFeignClient.getSubject(studentId);
        subjectByStudent.put("Student", student);
        subjectByStudent.put("Subjects", subjects);
        return subjectByStudent;
    }

}
