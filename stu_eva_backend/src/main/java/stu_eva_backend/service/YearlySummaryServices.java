package stu_eva_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu_eva_backend.model.YearlySummary;
import stu_eva_backend.repository.YearlySummaryRepository;

import java.util.List;
import java.util.Optional;

@Service


public class YearlySummaryServices {
    @Autowired
    private YearlySummaryRepository yearlySummaryRepository;

    public List<YearlySummary> getAllYearlySummary() {
        return yearlySummaryRepository.findAll();
    }

    // Additional CRUD methods
    // ...
    public YearlySummary createYearlySummary(YearlySummary yearlySummary) {
        return yearlySummaryRepository.save(yearlySummary);
    }

    public Optional<YearlySummary> getYearlySummaryById(String idCard) {
        return yearlySummaryRepository.findById(Integer.valueOf(idCard));
    }


    public YearlySummary updateYearlySummary(YearlySummary updatedYearlySummary) {
        return yearlySummaryRepository.save(updatedYearlySummary);
    }
    public void deleteYearlySummaryById(String idCard) {
        yearlySummaryRepository.deleteById(Integer.valueOf(idCard));
    }



}
