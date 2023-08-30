package org.iche.schoolservice.controller;


import lombok.RequiredArgsConstructor;
import org.iche.schoolservice.dto.request.SchoolRegistrationRequest;
import org.iche.schoolservice.dto.response.ApiResponse;
import org.iche.schoolservice.dto.response.FullResponseDetails;
import org.iche.schoolservice.dto.response.SchoolResponse;
import org.iche.schoolservice.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping("/add-school")
    public ResponseEntity<ApiResponse<SchoolResponse>> addEmployee(@RequestBody SchoolRegistrationRequest studentRegistrationRequest){
        ApiResponse<SchoolResponse> apiResponse = new ApiResponse<>(schoolService.saveSchool(studentRegistrationRequest));
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/add-school/{id}")
    public ResponseEntity<ApiResponse<SchoolResponse>> getEmployeeById(@PathVariable("id") Long id){
        ApiResponse<SchoolResponse> apiResponse = new ApiResponse<>(schoolService.findSchoolById(id));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all-school")
    public ResponseEntity<ApiResponse<List<SchoolResponse>>> findAllSchool(){
        ApiResponse<List<SchoolResponse>> apiResponse = new ApiResponse<>(schoolService.findAllSchool());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/full-details/{school-id}")
    public ResponseEntity<ApiResponse<FullResponseDetails>> getFullDetails(@PathVariable ("school-id") Long schoolId){
        ApiResponse<FullResponseDetails> apiResponse = new ApiResponse<>(schoolService.findSchoolWithStudents(schoolId));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
