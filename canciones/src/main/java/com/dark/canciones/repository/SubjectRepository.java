package com.dark.canciones.repository;

import com.dark.canciones.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<List<Subject>> findSubjectByStudentId(Long studentId);

}
