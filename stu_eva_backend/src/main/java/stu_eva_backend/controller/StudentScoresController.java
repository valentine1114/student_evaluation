package stu_eva_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu_eva_backend.model.StudentScores;
import stu_eva_backend.service.StudentScoresServices;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/studentScores")
public class StudentScoresController {

    @Autowired
    private StudentScoresServices studentScoresServices;

    @GetMapping
    //return object
    public List<StudentScores> getStudentScores() {
        return studentScoresServices.getAllStudentScores();
    }

    // Additional CRUD endpoints
    // ...
    @PostMapping
    public StudentScores createStudentScores(@RequestBody StudentScores studentScores) {
        return studentScoresServices.createStudentScores(studentScores);
    }


//    @GetMapping("/residents-count-by-building")
//    public Map<String, Object> getResidentsCountByBuilding() {
//        return communityMemberService.getResidentsCountByBuilding();
//    }
}