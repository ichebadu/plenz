package org.iche.department.config;

import org.iche.department.dto.response.ApiResponse;
import org.iche.department.dto.response.DepartmentResponse;
import org.iche.department.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetMapping("/employee/department/{department}")
    public ResponseEntity<ApiResponse<DepartmentResponse>> getDepartmentById(@PathVariable ("id") Long id);

}
