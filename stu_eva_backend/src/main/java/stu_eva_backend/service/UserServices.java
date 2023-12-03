package stu_eva_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu_eva_backend.model.Role;
import stu_eva_backend.model.User;
import stu_eva_backend.repository.StudentInfoRepository;
import stu_eva_backend.repository.TeacherRepository;

@Service
public class UserServices {
    @Autowired
    private TeacherRepository teacherRepository;
    
    @Autowired
    private StudentInfoRepository studentInfoRepository;

    public Role getRole(String id){
        if(teacherRepository.findByJobNumber(id)!=null){
            return teacherRepository.findByJobNumber(id).getRole();
        }
        else if(studentInfoRepository.findByStudentNumber(id)!=null){
            return studentInfoRepository.findByStudentNumber(id).getRole();
        }
        else{
            return null;
        }
    }

    public User getUserByUsername(String username){
        if(teacherRepository.findByUsername(username)!=null){
            return teacherRepository.findByUsername(username);
        }
        else if(studentInfoRepository.findByUsername(username)!=null){
            return studentInfoRepository.findByUsername(username);
        }
        else{
            return null;
        }
    }

    public User getUserByUserId(String username){
        if(teacherRepository.findByJobNumber(username)!=null){
            return teacherRepository.findByJobNumber(username);
        }
        else if(studentInfoRepository.findByStudentNumber(username)!=null){
            return studentInfoRepository.findByStudentNumber(username);
        }
        else{
            return null;
        }
    }

    public User getUserByIdAndRole(String id,Role role){
        if(role.getId()>1){
            return teacherRepository.findByJobNumber(id);
        }
        else if(role.getId()==1){
            return studentInfoRepository.findByStudentNumber(id);
        }
        else{
            return null;
        }
    }
}
