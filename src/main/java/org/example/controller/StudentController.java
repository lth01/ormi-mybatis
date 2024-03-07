package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> getStudent(@RequestParam(required = false) String name, @RequestParam(required = false) Long id , @RequestParam(required = false) Integer age){
        Student dto = new Student(id, name, age, new Date(new java.util.Date().getTime()));
        return studentService.getStudentByParam(dto);
    }

    /**
     * PUT으로 유저 수정할거라면, 반드시 고유한 유저를 대상으로 해야함
     * 그렇다면 진작에 수정할 대상에 대해서는 getStudent API로 특정 한 상태여야함
     * @param student
     */
    @PatchMapping("/student")
    public String updateStudent(@RequestBody Student student){
         return studentService.patchStudent(student);
    }

    /**
     * 현재는 이름, 나이 열만 있어, 신규 생성에 대한 중복검사가 불가(동명이인, 장소가 학교나 학원이라면 나이가 다르다 보장할 수 없음)
     * @param student
     * @return
     */
    @PostMapping("/student")
    public String insertStudent(@RequestBody Student student){
        return studentService.insertStudent(student);
    }
}
