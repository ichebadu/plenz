package org.iche.department.controller;

import lombok.RequiredArgsConstructor;
import org.iche.department.dto.request.DepartmentRegistrationRequest;
import org.iche.department.dto.response.ApiResponse;
import org.iche.department.dto.response.DepartmentResponse;
import org.iche.department.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department-app/api")
@RequiredArgsConstructor
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    private final DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<DepartmentResponse>>  addDepartment(@RequestBody DepartmentRegistrationRequest departmentRegistrationRequest){
        ApiResponse<DepartmentResponse> apiResponse = new ApiResponse<>(departmentService.addDepartment(departmentRegistrationRequest));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/allDepartment")
    public ResponseEntity<ApiResponse<List<DepartmentResponse>>> getAllDepartment(){
        ApiResponse<List<DepartmentResponse>> apiResponse = new ApiResponse<>(departmentService.findAll());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<ApiResponse<DepartmentResponse>> getDepartmentById(@PathVariable ("id") Long id){
        ApiResponse<DepartmentResponse> apiResponse = new ApiResponse<>(departmentService.findDepartmentById(id));
        LOGGER.info("Department find : id = {}", id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
