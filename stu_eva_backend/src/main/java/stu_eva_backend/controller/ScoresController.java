package stu_eva_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu_eva_backend.model.StudentInfo;
import stu_eva_backend.repository.StudentInfoRepository;
import stu_eva_backend.repository.StudentScoresRepository;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoresController {
    private StudentScoresRepository studentScoresRepository;
    private StudentInfoRepository studentInfoRepository;
    @Autowired
    public ScoresController(StudentScoresRepository studentScoresRepository) {
        this.studentScoresRepository=studentScoresRepository;
    }
    @GetMapping("/get")
    public List<StudentInfo> getAllStudents() {
        return studentInfoRepository.findAll();
    }

}
