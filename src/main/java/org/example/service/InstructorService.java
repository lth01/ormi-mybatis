package org.example.service;

import org.example.model.Instructor;
import org.example.repository.InstructorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    @Autowired
    private InstructorMapper instructorMapper;

    public Integer postInstructor(Instructor instructor) {
        return instructorMapper.postInstructor(instructor);
    }

    public List<Instructor> getInstructorByParam(Instructor instructor) {
        return instructorMapper.selectInstructorByParam(instructor);
    }
}
