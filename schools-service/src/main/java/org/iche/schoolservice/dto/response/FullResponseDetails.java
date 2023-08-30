package org.iche.schoolservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iche.schoolservice.model.Student;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullResponseDetails {

    private String name;
    private String email;
    private List<Student> students;
}
