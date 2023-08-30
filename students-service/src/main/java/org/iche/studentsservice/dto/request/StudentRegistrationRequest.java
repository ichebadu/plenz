package org.iche.studentsservice.dto.request;

import lombok.Data;


@Data
public class StudentRegistrationRequest {

    private String firstname;
    private String lastname;
    private String email;
    private int age;
    private String grade;
    private Long schoolId;

}
