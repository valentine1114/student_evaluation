package stu_eva_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu_eva_backend.model.SummaryScores;
import stu_eva_backend.repository.SummaryScoresRepository;

import java.util.List;
import java.util.Optional;

@Service
public class Yearly_GPA_SummaryScoresServices {
    @Autowired
    private SummaryScoresRepository SummaryScoresRepository;

    public List<SummaryScores> getAllSummaryScores() {
        return SummaryScoresRepository.findAll();
    }

    // Additional CRUD methods
    // ...
    public SummaryScores createSummaryScores(SummaryScores SummaryScores) {
        return SummaryScoresRepository.save(SummaryScores);
    }

    public Optional<SummaryScores> getSummaryScoresById(String idCard) {
        return SummaryScoresRepository.findById(Integer.valueOf(idCard));
    }



    public List<SummaryScores> getSummaryScoresWithGPA() {
        List<SummaryScores> allSummaryScores = SummaryScoresRepository.findAll();
        for (SummaryScores summaryScores : allSummaryScores) {
            // 删除不需要的成绩信息
            summaryScores.setResearchScore(null);
            summaryScores.setVolunteerScore(null);
            summaryScores.setSocialPracticeScore(null);
            summaryScores.setLeadershipScore(null);
            summaryScores.setYearlySummaryScore(null);
        }
        return allSummaryScores;
    }

    public List<SummaryScores> getSummaryScoresWithResearch() {
        List<SummaryScores> allSummaryScores = SummaryScoresRepository.findAll();
        for (SummaryScores summaryScores : allSummaryScores) {
            // 删除不需要的成绩信息
            summaryScores.setGpaScore(null);
            summaryScores.setVolunteerScore(null);
            summaryScores.setSocialPracticeScore(null);
            summaryScores.setLeadershipScore(null);
            summaryScores.setYearlySummaryScore(null);
        }
        return allSummaryScores;
    }

    public List<SummaryScores> getSummaryScoresWithVolunteer() {
        List<SummaryScores> allSummaryScores = SummaryScoresRepository.findAll();
        for (SummaryScores summaryScores : allSummaryScores) {
            // 删除不需要的成绩信息
            summaryScores.setGpaScore(null);
            summaryScores.setResearchScore(null);
            summaryScores.setSocialPracticeScore(null);
            summaryScores.setLeadershipScore(null);
            summaryScores.setYearlySummaryScore(null);
        }
        return allSummaryScores;
    }

    public List<SummaryScores> getSummaryScoresWithSocialPractice() {
        List<SummaryScores> allSummaryScores = SummaryScoresRepository.findAll();
        for (SummaryScores summaryScores : allSummaryScores) {
            // 删除不需要的成绩信息
            summaryScores.setGpaScore(null);
            summaryScores.setResearchScore(null);
            summaryScores.setVolunteerScore(null);
            summaryScores.setLeadershipScore(null);
            summaryScores.setYearlySummaryScore(null);
        }
        return allSummaryScores;
    }

    public List<SummaryScores> getSummaryScoresWithLeadership() {
        List<SummaryScores> allSummaryScores = SummaryScoresRepository.findAll();
        for (SummaryScores summaryScores : allSummaryScores) {
            // 删除不需要的成绩信息
            summaryScores.setGpaScore(null);
            summaryScores.setResearchScore(null);
            summaryScores.setVolunteerScore(null);
            summaryScores.setSocialPracticeScore(null);
            summaryScores.setYearlySummaryScore(null);
        }
        return allSummaryScores;
    }

    public List<SummaryScores> getSummaryScoresWithYearly() {
        List<SummaryScores> allSummaryScores = SummaryScoresRepository.findAll();
        for (SummaryScores summaryScores : allSummaryScores) {
            // 删除不需要的成绩信息
            summaryScores.setGpaScore(null);
            summaryScores.setResearchScore(null);
            summaryScores.setVolunteerScore(null);
            summaryScores.setSocialPracticeScore(null);
            summaryScores.setLeadershipScore(null);
        }
        return allSummaryScores;
    }

    public SummaryScores updateYearlySummaryScores(SummaryScores updatedSummaryScores) {
        Optional<SummaryScores> optionalSummaryScores = SummaryScoresRepository.findById(updatedSummaryScores.getId());
        if (optionalSummaryScores.isPresent()) {
            SummaryScores existingSummaryScores = optionalSummaryScores.get();
            existingSummaryScores.setSummaryScore(updatedSummaryScores.getYearlySummaryScore());
            return SummaryScoresRepository.save(existingSummaryScores);
        } else {
            return null;
        }
        // Float yearlySummaryScores=updatedSummaryScores.getSummaryScore();
        // updatedSummaryScores.setSummaryScore(yearlySummaryScores);
        // return SummaryScoresRepository.save(updatedSummaryScores);
    }
    public SummaryScores updateGpaSummaryScores(SummaryScores updatedSummaryScores) {
        // Float gpaSummaryScores=updatedSummaryScores.getGpaScore();
        // updatedSummaryScores.setGpaScore(gpaSummaryScores);
        // return SummaryScoresRepository.save(updatedSummaryScores);
        Optional<SummaryScores> optionalSummaryScores = SummaryScoresRepository.findById(updatedSummaryScores.getId());
        if (optionalSummaryScores.isPresent()) {
            SummaryScores existingSummaryScores = optionalSummaryScores.get();
            existingSummaryScores.setGpaScore(updatedSummaryScores.getGpaScore());
            return SummaryScoresRepository.save(existingSummaryScores);
        } else {
            return null;
        }
    }
    public SummaryScores updateResearchScores(SummaryScores updatedSummaryScores) {
        // Float researchScores=updatedSummaryScores.getResearchScore();
        // updatedSummaryScores.setResearchScore(researchScores);
        // return SummaryScoresRepository.save(updatedSummaryScores);
        Optional<SummaryScores> optionalSummaryScores = SummaryScoresRepository.findById(updatedSummaryScores.getId());
        if (optionalSummaryScores.isPresent()) {
            SummaryScores existingSummaryScores = optionalSummaryScores.get();
            existingSummaryScores.setResearchScore(updatedSummaryScores.getResearchScore());
            return SummaryScoresRepository.save(existingSummaryScores);
        } else {
            return null;
        }
    }
    public void deleteSummaryScoresById(String idCard) {
        SummaryScoresRepository.deleteById(Integer.valueOf(idCard));
    }
    public SummaryScores updateSocialScores(SummaryScores updatedSummaryScores) {
        // Float socialSummaryScores=updatedSummaryScores.getSocialPracticeScore();
        // updatedSummaryScores.setSocialPracticeScore(socialSummaryScores);
        // return SummaryScoresRepository.save(updatedSummaryScores);
        Optional<SummaryScores> optionalSummaryScores = SummaryScoresRepository.findById(updatedSummaryScores.getId());
        if (optionalSummaryScores.isPresent()) {
            SummaryScores existingSummaryScores = optionalSummaryScores.get();
            existingSummaryScores.setSocialPracticeScore(updatedSummaryScores.getSocialPracticeScore());
            return SummaryScoresRepository.save(existingSummaryScores);
        } else {
            return null;
        }
    }

    public SummaryScores updateVolunteerScores(SummaryScores updatedSummaryScores) {
        // Float socialSummaryScores=updatedSummaryScores.getVolunteerScore();
        // updatedSummaryScores.setVolunteerScore(socialSummaryScores);
        // return SummaryScoresRepository.save(updatedSummaryScores);
        Optional<SummaryScores> optionalSummaryScores = SummaryScoresRepository.findById(updatedSummaryScores.getId());
        if (optionalSummaryScores.isPresent()) {
            SummaryScores existingSummaryScores = optionalSummaryScores.get();
            existingSummaryScores.setVolunteerScore(updatedSummaryScores.getVolunteerScore());
            return SummaryScoresRepository.save(existingSummaryScores);
        } else {
            return null;
        }
    }
    public SummaryScores updateLeadershipScores(SummaryScores updatedSummaryScores) {
        // Float socialSummaryScores=updatedSummaryScores.getLeadershipScore();
        // updatedSummaryScores.setLeadershipScore(socialSummaryScores);
        // return SummaryScoresRepository.save(updatedSummaryScores);
        Optional<SummaryScores> optionalSummaryScores = SummaryScoresRepository.findById(updatedSummaryScores.getId());
        if (optionalSummaryScores.isPresent()) {
            SummaryScores existingSummaryScores = optionalSummaryScores.get();
            existingSummaryScores.setLeadershipScore(updatedSummaryScores.getLeadershipScore());
            return SummaryScoresRepository.save(existingSummaryScores);
        } else {
            return null;
        }
    }

    
}
