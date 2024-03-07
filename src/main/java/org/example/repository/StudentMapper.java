package org.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface StudentMapper {
    List<Student> selectStudentByParam(Student student);

    List<Student> selectStudentById(Student student);

    int patchStudent(Student student);

    Integer insertStudent(Student student);

    Boolean chkExistStudent(Long studentId);
}
