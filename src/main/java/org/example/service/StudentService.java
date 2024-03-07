package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentMapper;
import org.example.util.BooleanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public List<Student> getStudentByParam(Student student) {
        return studentMapper.selectStudentByParam(student);
    }

    public String patchStudent(Student student) {
        Integer apiResult = studentMapper.patchStudent(student);

        if(BooleanUtil.isFalse(apiResult)) return "바꾸려는 학생의 ID와 일치하는 정보가 없습니다.";
        else return "성공적으로 업데이트되었습니다.";
    }


    public String insertStudent(Student student) {
        Integer apiResult = studentMapper.insertStudent(student);

        if(BooleanUtil.isFalse(apiResult)) return "학생정보 등록에 실패했습니다.";
        else return "성공적으로 학생정보를 등록했습니다.";
    }
}
