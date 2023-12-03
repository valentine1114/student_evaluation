package stu_eva_backend.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stu_eva_backend.model.SummaryScores;
import stu_eva_backend.repository.SummaryScoresRepository;

@Service
public class SocialPracticeScoreServices {
   
    @Autowired
    private SummaryScoresRepository SummaryScoresRepository;

    public List<SummaryScores> getAllSummaryScores() {
        return SummaryScoresRepository.findAll();
    }

    public SummaryScores createSummaryScores(SummaryScores SummaryScores) {
        return SummaryScoresRepository.save(SummaryScores);
    }

    public Optional<SummaryScores> getSummaryScoresById(String idCard) {
        return SummaryScoresRepository.findById(Integer.valueOf(idCard));
    }


    public SummaryScores updateSocialScores(SummaryScores updatedSummaryScores) {
        Float socialScores=updatedSummaryScores.getSummaryScore();
        updatedSummaryScores.setSummaryScore(socialScores);
        return SummaryScoresRepository.save(updatedSummaryScores);
    }
}
