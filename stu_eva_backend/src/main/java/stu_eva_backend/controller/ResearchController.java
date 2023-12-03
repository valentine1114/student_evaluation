package stu_eva_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu_eva_backend.model.Research;
import stu_eva_backend.model.StudentScores;
import stu_eva_backend.model.YearlySummary;
import stu_eva_backend.service.ResearchServices;
import stu_eva_backend.service.StudentScoresServices;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/research")
public class ResearchController {

    @Autowired
    private ResearchServices researchServices;

    @GetMapping
    //return object
    public List<Research> getResearch() {
        return researchServices.getAllResearch();
    }

    // Additional CRUD endpoints
    // ...
    @PostMapping
    public Research createResearch(@RequestBody Research research) {
        return researchServices.createResearch(research);
    }



//    @GetMapping("/residents-count-by-building")
//    public Map<String, Object> getResidentsCountByBuilding() {
//        return communityMemberService.getResidentsCountByBuilding();
//    }
}