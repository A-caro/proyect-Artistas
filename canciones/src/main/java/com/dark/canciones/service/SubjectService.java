package com.dark.canciones.service;

import com.dark.canciones.entity.Subject;
import com.dark.canciones.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<List<Subject>> getSubject(Long id){
        return subjectRepository.findSubjectByStudentId(id);
    }





}
