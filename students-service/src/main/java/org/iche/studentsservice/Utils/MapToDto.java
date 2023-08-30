package org.iche.studentsservice.Utils;

import lombok.RequiredArgsConstructor;
import org.iche.studentsservice.dto.request.StudentRegistrationRequest;
import org.iche.studentsservice.model.Student;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapToDto {


    public Student studentRegMapToStudent (StudentRegistrationRequest studentRegistrationRequest){
        Student student = new Student();

        student.setFirstname(studentRegistrationRequest.getFirstname());
        student.setLastname(studentRegistrationRequest.getLastname());
        student.setEmail(studentRegistrationRequest.getEmail());
        student.setGrade(studentRegistrationRequest.getGrade());
        student.setAge(studentRegistrationRequest.getAge());
        student.setSchoolId(studentRegistrationRequest.getSchoolId());
        student.getId();

        return student;
    }
}
