package org.iche.department.service;

import org.iche.department.dto.request.DepartmentRegistrationRequest;
import org.iche.department.dto.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {

    DepartmentResponse addDepartment(DepartmentRegistrationRequest department);

    DepartmentResponse findDepartmentById(Long id);

    DepartmentResponse findDepartmentByEmployeeById(Long id);

    List<DepartmentResponse> findAll();
}
