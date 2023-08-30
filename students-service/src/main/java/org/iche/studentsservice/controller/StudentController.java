package org.iche.studentsservice.controller;


import lombok.RequiredArgsConstructor;
import org.iche.studentsservice.dto.request.StudentRegistrationRequest;
import org.iche.studentsservice.dto.response.ApiResponse;
import org.iche.studentsservice.dto.response.StudentResponse;
import org.iche.studentsservice.model.Student;
import org.iche.studentsservice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @PostMapping("/add-student")
    public ResponseEntity<ApiResponse<StudentResponse>> addStudent(@RequestBody StudentRegistrationRequest studentRegistrationRequest){
        ApiResponse<StudentResponse> apiResponse = new ApiResponse<>(studentService.addStudent(studentRegistrationRequest));
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> getStudentById(@PathVariable ("id") Long id){
        ApiResponse<StudentResponse> apiResponse = new ApiResponse<>(studentService.findStudentById(id));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all-student")
    public ResponseEntity<ApiResponse<List<StudentResponse>>> getAllStudent(){
        ApiResponse<List<StudentResponse>> apiResponse = new ApiResponse<>(studentService.findAllStudent());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/with-student/{school-id}")
    public ResponseEntity<ApiResponse<List<StudentResponse>>> getAllStudentsBySchoolId(@PathVariable ("school-id") Long schoolId ){
        ApiResponse<List<StudentResponse>> apiResponse = new ApiResponse<>(studentService.findAllStudentsBySchool(schoolId));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/new-student/{school-id}")
    public List<Student> AllStudentsBySchoolId(@PathVariable ("school-id") Long schoolId ){
        return ResponseEntity.ok(studentService.newly(schoolId)).getBody();
    }

}
