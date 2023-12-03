package stu_eva_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu_eva_backend.model.Research;
import stu_eva_backend.model.StudentScores;
import stu_eva_backend.repository.ResearchRepository;
import stu_eva_backend.repository.StudentScoresRepository;

import java.util.List;
import java.util.Optional;

@Service


public class ResearchServices {
    @Autowired
    private ResearchRepository researchRepository;

    public List<Research> getAllResearch() {
        return researchRepository.findAll();
    }

    // Additional CRUD methods
    // ...
    public Research createResearch(Research research) {
        return researchRepository.save(research);
    }

    public Optional<Research> getResearchById(String idCard) {
        return researchRepository.findById(Integer.valueOf(idCard));
    }


    public Research updateResearch(Research updatedResearch) {
        return researchRepository.save(updatedResearch);
    }
    public void deleteResearchById(String idCard) {
        researchRepository.deleteById(Integer.valueOf(idCard));
    }



}
