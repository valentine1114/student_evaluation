package stu_eva_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu_eva_backend.model.StudentLeadership;
import stu_eva_backend.model.StudentScores;
import stu_eva_backend.model.YearlySummary;
import stu_eva_backend.service.StudentLeadershipServices;
import stu_eva_backend.service.StudentScoresServices;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/studentLeadership")
public class StudentLeadershipController {

    @Autowired
    private StudentLeadershipServices studentLeadershipServices;

    @GetMapping
    //return object
    public List<StudentLeadership> getStudentLeadership() {
        return studentLeadershipServices.getAllStudentLeadership();
    }

    // Additional CRUD endpoints
    // ...
    @PostMapping
    public StudentLeadership createStudentLeadership(@RequestBody StudentLeadership studentLeadership) {
        return studentLeadershipServices.createStudentLeadership(studentLeadership);
    }



//    @GetMapping("/residents-count-by-building")
//    public Map<String, Object> getResidentsCountByBuilding() {
//        return communityMemberService.getResidentsCountByBuilding();
//    }
}