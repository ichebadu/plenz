package org.iche.schoolservice.service;

import org.iche.schoolservice.dto.request.SchoolRegistrationRequest;
import org.iche.schoolservice.dto.response.FullResponseDetails;
import org.iche.schoolservice.dto.response.SchoolResponse;


import java.util.List;

public interface SchoolService {

    SchoolResponse saveSchool(SchoolRegistrationRequest schoolRegistrationRequest);

    SchoolResponse findSchoolById(Long id);

    List<SchoolResponse> findAllSchool();

    FullResponseDetails findSchoolWithStudents(Long schoolId);
}

