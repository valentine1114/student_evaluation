package stu_eva_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu_eva_backend.model.StudentLeadership;
import stu_eva_backend.model.StudentScores;
import stu_eva_backend.repository.StudentLeadershipRepository;
import stu_eva_backend.repository.StudentScoresRepository;

import java.util.List;
import java.util.Optional;

@Service


public class StudentLeadershipServices {
    @Autowired
    private StudentLeadershipRepository studentLeadershipRepository;

    public List<StudentLeadership> getAllStudentLeadership() {
        return studentLeadershipRepository.findAll();
    }

    // Additional CRUD methods
    // ...
    public StudentLeadership createStudentLeadership(StudentLeadership studentLeadership) {
        return studentLeadershipRepository.save(studentLeadership);
    }

    public Optional<StudentLeadership> getStudentLeadershipById(String idCard) {
        return studentLeadershipRepository.findById(Integer.valueOf(idCard));
    }


    public StudentLeadership updateStudentLeadership(StudentLeadership updatedStudentLeadership) {
        return studentLeadershipRepository.save(updatedStudentLeadership);
    }
    public void deleteStudentLeadershipById(String idCard) {
        studentLeadershipRepository.deleteById(Integer.valueOf(idCard));
    }



}
