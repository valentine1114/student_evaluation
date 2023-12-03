package stu_eva_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu_eva_backend.model.StudentScores;
import stu_eva_backend.repository.StudentScoresRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentScoresServices {
    @Autowired
    private StudentScoresRepository studentScoresRepository;

    public List<StudentScores> getAllStudentScores() {
        return studentScoresRepository.findAll();
    }

    // Additional CRUD methods
    // ...
    public StudentScores createStudentScores(StudentScores studentScores) {
        return studentScoresRepository.save(studentScores);
    }

    public Optional<StudentScores> getStudentScoresById(String idCard) {
        return studentScoresRepository.findById(Integer.valueOf(idCard));
    }


    public StudentScores updateStudentScores(StudentScores updatedStudentScores) {
        return studentScoresRepository.save(updatedStudentScores);
    }
    public void deleteStudentScoresById(String idCard) {
        studentScoresRepository.deleteById(Integer.valueOf(idCard));
    }



}
