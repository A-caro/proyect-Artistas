package com.dark.proyectoartistas.service;


import com.dark.proyectoartistas.feignclient.SubjectFeignClient;
import com.dark.proyectoartistas.model.Subject;
import com.dark.proyectoartistas.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StudentService {

    @Autowired
    SubjectFeignClient subjectFeignClient;

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Subject saveSubject(Long studentId, Subject subject){
        subject.setStudentId(studentId);
        Subject subjectNew = subjectFeignClient.saveSubject(subject);
        return subjectNew;
    }
}
