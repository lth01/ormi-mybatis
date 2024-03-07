package org.example.controller;

import org.example.model.Instructor;
import org.example.service.InstructorService;
import org.example.util.BooleanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping("/instructor")
    public List<Instructor> getInstructor(@RequestParam(required = false) String id, @RequestParam(required = false) String name){
        Instructor instructor = new Instructor(id, name);
        return instructorService.getInstructorByParam(instructor);
    }
    @PostMapping("/instructor")
    public String insertInstructor(@RequestBody Instructor instructor){
        Integer apiResult = instructorService.postInstructor(instructor);

        if(BooleanUtil.isFalse(apiResult)) return "강사정보 등록에 실패했습니다.";
        else return "강사정보 등록에 성공하였습니다!";
    }
}
