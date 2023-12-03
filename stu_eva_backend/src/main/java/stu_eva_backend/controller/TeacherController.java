package stu_eva_backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu_eva_backend.model.Teacher;
import stu_eva_backend.repository.TeacherRepository;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    public Teacher findTeacherByTeacherId(String jobNumber) {
        return teacherRepository.findByJobNumber(jobNumber);
    }
}
