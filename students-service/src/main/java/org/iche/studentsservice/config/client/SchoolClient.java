//package org.iche.studentsservice.config.client;
//
//import org.iche.studentsservice.dto.response.StudentResponse;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//@FeignClient(name="student-service", url = "{application.config.students-url}")
//public interface SchoolClient {
//        @GetMapping("/with-student/{school-id}")
//        List<StudentResponse> getAllStudentsBySchoolId(@PathVariable("school-id") Long schoolId);
//
//}
