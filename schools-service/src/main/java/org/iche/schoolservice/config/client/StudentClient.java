package org.iche.schoolservice.config.client;


import org.iche.schoolservice.model.Student;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "students-service", url = "${application.config.students-url}")
public interface StudentClient {




    @GetMapping("/school/{school-id}")
    List<Student> findSchoolsWithStudents(@PathVariable("school-id") Long id );
    @GetMapping("/new-student/{school-id}")
    List<Student> AllStudentsBySchoolId(@PathVariable ("school-id") Long schoolId );
}
