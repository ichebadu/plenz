package org.iche.department.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.iche.department.config.EmployeeClient;
import org.iche.department.dto.request.DepartmentRegistrationRequest;
import org.iche.department.dto.response.DepartmentResponse;
import org.iche.department.entity.Department;
import org.iche.department.repository.DepartmentRepository;
import org.iche.department.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class departmentServiceImpl implements DepartmentService {

    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;

    private final EmployeeClient employeeClient;

    @Override
    public DepartmentResponse addDepartment(DepartmentRegistrationRequest departmentRequest) {
        Department department = modelMapper.map(departmentRequest, Department.class); // Convert DTO to Entity
        Department savedDepartment = departmentRepository.save(department);
        return modelMapper.map(savedDepartment, DepartmentResponse.class);
    }

    @Override
    public DepartmentResponse findDepartmentById(Long id){
        Optional<Department> department = departmentRepository.findById(id);
                if(!department.isPresent()){
                    throw new RuntimeException("Department not found");
                };
        Department saveDepartment = department.get();
        return modelMapper.map(saveDepartment, DepartmentResponse.class);
    }

    @Override
    public DepartmentResponse findDepartmentByEmployeeById(Long id){
        Optional<Department> department = departmentRepository.findById(id);
        if(!department.isPresent()){
            throw new RuntimeException("Department not found");
        };
        Department saveDepartment = department.get();
        return modelMapper.map(saveDepartment, DepartmentResponse.class);
    }

//    @Override
//    public DepartmentResponse findDepartmentById(Long id){
//
//        List<Department> departmentList = new ArrayList<>();
//
//        Optional<Department> optionalDepartment = departmentList.stream()
//                .filter(department -> department.getId().equals(id))
//                .findFirst();
//
//        Department department = optionalDepartment.orElseThrow(() -> new RuntimeException("Department with the given ID does not exist"));
//
//        return modelMapper.map(optionalDepartment, DepartmentResponse.class);
//    }

    @Override
    public List<DepartmentResponse> findAll(){
        List<Department> departmentList = departmentRepository.findAll();

        return departmentList.stream()
                        .map(department->  modelMapper.map(department, DepartmentResponse.class))
                .collect(Collectors.toList());
    }
}
