package org.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.Instructor;

import java.util.List;

@Mapper
public interface InstructorMapper {
    Integer postInstructor(Instructor instructor);

    List<Instructor> selectInstructorByParam(Instructor instructor);

    Boolean chkExistInstructor(Long id);
}
