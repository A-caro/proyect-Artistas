package com.dark.canciones.service;

import com.dark.canciones.entity.Subject;
import com.dark.canciones.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getAll(){
        return subjectRepository.findAll();
    }

    public Subject saveSubject(Subject subject){

        Subject newSubject = subjectRepository.save(subject);
        return newSubject;
    }





}
