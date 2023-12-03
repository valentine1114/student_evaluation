package stu_eva_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu_eva_backend.model.VolunteerService ;
import stu_eva_backend.service.VolunteerServiceServices;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/studentVolunteer")
public class VolunteerController {

    @Autowired
    private VolunteerServiceServices volunteerServiceServices;

    @GetMapping
    //return object
    public List<VolunteerService> getVolunteerServices() {
        return volunteerServiceServices.getAllVolunteerServices();
    }

    // Additional CRUD endpoints
    // ...
    @PostMapping
    public VolunteerService createVolunteerService(@RequestBody VolunteerService volunteerService) {
        return volunteerServiceServices.createVolunteerService(volunteerService);
    }


//    @GetMapping("/residents-count-by-building")
//    public Map<String, Object> getResidentsCountByBuilding() {
//        return communityMemberService.getResidentsCountByBuilding();
//    }
}