package stu_eva_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu_eva_backend.model.YearlySummary;
import stu_eva_backend.service.YearlySummaryServices;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/yearlySummary")
public class YearlySummaryController {

    @Autowired
    private YearlySummaryServices yearlyGPASummaryServices;

    @GetMapping
    //return object
    public List<YearlySummary> getYearlySummary() {
        return yearlyGPASummaryServices.getAllYearlySummary();
    }

    // Additional CRUD endpoints
    // ...
    @PostMapping
    public YearlySummary updateYearlySummary(@RequestBody YearlySummary yearlySummary) {
        System.out.println(yearlySummary);
        System.out.println(yearlyGPASummaryServices);
        return yearlyGPASummaryServices.updateYearlySummary(yearlySummary);
    }

//    @GetMapping("/residents-count-by-building")
//    public Map<String, Object> getResidentsCountByBuilding() {
//        return communityMemberService.getResidentsCountByBuilding();
//    }
}