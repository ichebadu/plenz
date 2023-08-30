package org.iche.studentsservice.service.serviceImpl;


import lombok.RequiredArgsConstructor;
import org.iche.studentsservice.Utils.MapToDto;
import org.iche.studentsservice.dto.request.StudentRegistrationRequest;
import org.iche.studentsservice.dto.response.StudentResponse;
import org.iche.studentsservice.model.Student;
import org.iche.studentsservice.repository.StudentRepository;
import org.iche.studentsservice.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    private final MapToDto mapToDto;
    @Override
    public StudentResponse addStudent(StudentRegistrationRequest studentRegistrationRequest){
        System.out.println(studentRegistrationRequest);


        Student student = mapToDto.studentRegMapToStudent(studentRegistrationRequest);
        studentRepository.save(student);

        return StudentResponse.builder()
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .email(student.getEmail())
                .age(student.getAge())
                .grade(student.getGrade())
                .build();
    }

    @Override
    public List<StudentResponse> findAllStudentsBySchool(Long id) {
        List<Student> students = studentRepository.findAllStudentBySchoolId(id);

        if(students.isEmpty()){
            throw new RuntimeException("No student found for the given school ID");
        }

        return students.stream()
                .map( student -> modelMapper.map(student, StudentResponse.class)
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> newly(Long schoolId) {
        return studentRepository.findAllStudentBySchoolId(schoolId);
    }

    @Override
    public StudentResponse findStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        return modelMapper.map(student, StudentResponse.class);
    }
    @Override
    public List<StudentResponse> findAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        return studentList.stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());
    }

}
