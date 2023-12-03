package stu_eva_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu_eva_backend.model.StudentInfo;
import stu_eva_backend.repository.StudentInfoRepository;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentInfoRepository studentInfoRepository;

    @Autowired
    public StudentController(StudentInfoRepository studentInfoRepository) {
        this.studentInfoRepository = studentInfoRepository;
    }

    @GetMapping
    public List<StudentInfo> getAllStudents() {
        return studentInfoRepository.findAll();
    }
}
