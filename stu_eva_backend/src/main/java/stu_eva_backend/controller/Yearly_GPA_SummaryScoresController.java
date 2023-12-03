package stu_eva_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu_eva_backend.model.SummaryScores;
import stu_eva_backend.service.Yearly_GPA_SummaryScoresServices;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/yearlyGpaSummaryScores")
public class Yearly_GPA_SummaryScoresController {

    @Autowired
    private Yearly_GPA_SummaryScoresServices yearlyGPASummaryScoresServices;

    @GetMapping
    //return object
    public List<SummaryScores> getAllYearlySummaryScores() {
        return yearlyGPASummaryScoresServices.getAllSummaryScores();
    }

    // Additional CRUD endpoints
    // ...
    @GetMapping("/GPA")
    public List<SummaryScores> getGPASummaryScores() {
        return yearlyGPASummaryScoresServices.getSummaryScoresWithGPA();
    }

    @GetMapping("/yearly")
    public List<SummaryScores> getYearlySummaryScores() {
        return yearlyGPASummaryScoresServices.getSummaryScoresWithYearly();
    }

    @GetMapping("/research")
    public List<SummaryScores> getResearchSummaryScores() {
        return yearlyGPASummaryScoresServices.getSummaryScoresWithResearch();
    }

    @GetMapping("/volunteer")
    public List<SummaryScores> getVolunteerSummaryScores() {
        return yearlyGPASummaryScoresServices.getSummaryScoresWithVolunteer();
    }

    @GetMapping("/social")
    public List<SummaryScores> getSocialSummaryScores() {
        return yearlyGPASummaryScoresServices.getSummaryScoresWithSocialPractice();
    }

    @GetMapping("/leadership")
    public List<SummaryScores> getLeadershipSummaryScores() {
        return yearlyGPASummaryScoresServices.getSummaryScoresWithLeadership();
    }

    @PostMapping("/yearly")
    public SummaryScores updateYearlySummaryScores(@RequestBody SummaryScores yearlySummaryScores) {
        return yearlyGPASummaryScoresServices.updateYearlySummaryScores(yearlySummaryScores);
    }
    @PostMapping("/gpa")
    public SummaryScores updateGPASummaryScores(@RequestBody SummaryScores gpaSummaryScores) {
        return yearlyGPASummaryScoresServices.updateGpaSummaryScores(gpaSummaryScores);
    }
    @PostMapping("/volunteer")
    public SummaryScores updateVolunteerScores(@RequestBody SummaryScores gpaSummaryScores) {
        return yearlyGPASummaryScoresServices.updateVolunteerScores(gpaSummaryScores);
    }
    @PostMapping("/research")
    public SummaryScores updateResearchScores(@RequestBody SummaryScores gpaSummaryScores) {
        return yearlyGPASummaryScoresServices.updateResearchScores(gpaSummaryScores);
    }
    @PostMapping("/social")
    public SummaryScores updateSocialScores(@RequestBody SummaryScores gpaSummaryScores) {
        return yearlyGPASummaryScoresServices.updateSocialScores(gpaSummaryScores);
    }

    @PostMapping("/studentLeadership")
    public SummaryScores updateLeadershipScores(@RequestBody SummaryScores gpaSummaryScores) {
        return yearlyGPASummaryScoresServices.updateLeadershipScores(gpaSummaryScores);
    }
}