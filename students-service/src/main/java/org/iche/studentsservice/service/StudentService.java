package org.iche.studentsservice.service;

import org.iche.studentsservice.dto.request.StudentRegistrationRequest;
import org.iche.studentsservice.dto.response.StudentResponse;
import org.iche.studentsservice.model.Student;

import java.util.List;

public interface StudentService {

    StudentResponse addStudent(StudentRegistrationRequest studentRegistrationRequest);


    StudentResponse findStudentById(Long id);


    List<StudentResponse> findAllStudent();

    List<StudentResponse> findAllStudentsBySchool(Long id);

    List<Student> newly(Long schoolId);
}


