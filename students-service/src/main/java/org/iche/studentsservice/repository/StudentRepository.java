package org.iche.studentsservice.repository;


import org.iche.studentsservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllStudentBySchoolId(Long schoolId);
}
