package org.iche.department.dto.response;



import lombok.Data;
import org.iche.department.entity.Employee;
import java.util.List;

@Data
public class DepartmentResponse {
    private String name;
    private List<Employee> employeeList;

}
