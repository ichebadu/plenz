package org.iche.schoolservice.service.serviceImpl;


import lombok.RequiredArgsConstructor;
import org.iche.schoolservice.config.client.StudentClient;
import org.iche.schoolservice.dto.request.SchoolRegistrationRequest;
import org.iche.schoolservice.dto.response.FullResponseDetails;
import org.iche.schoolservice.dto.response.SchoolResponse;
import org.iche.schoolservice.model.School;
import org.iche.schoolservice.repository.SchoolRepository;
import org.iche.schoolservice.service.SchoolService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final ModelMapper modelMapper;
    private final StudentClient studentClient;

    @Override
    public SchoolResponse saveSchool(SchoolRegistrationRequest schoolRegistrationRequest){
        System.out.println(schoolRegistrationRequest);

        School school = modelMapper.map(schoolRegistrationRequest, School.class);
        schoolRepository.save(school);
        return modelMapper.map(school, SchoolResponse.class);
    }

    @Override
    public SchoolResponse findSchoolById(Long id){
        School school = schoolRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
        return modelMapper.map(school, SchoolResponse.class);
    }

    @Override
    public List<SchoolResponse> findAllSchool(){
        List<School> schoolList = schoolRepository.findAll();

        return schoolList.stream()
                .map(school -> modelMapper.map(school, SchoolResponse.class))
                .collect(Collectors.toList());
    }



    @Override
    public FullResponseDetails findSchoolWithStudents(Long schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElse(School.builder()
                        .name("Not found")
                        .email("Not found")
                        .build()
                );

        var students = studentClient.AllStudentsBySchoolId(schoolId);

        return FullResponseDetails.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
