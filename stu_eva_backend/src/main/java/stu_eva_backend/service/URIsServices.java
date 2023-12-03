package stu_eva_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import stu_eva_backend.model.URIs;
import stu_eva_backend.repository.StudentInfoRepository;
import stu_eva_backend.repository.TeacherRepository;
import stu_eva_backend.repository.URIsRepository;
import org.springframework.stereotype.Service;

@Service
public class URIsServices {
    // @Autowired
    // private URIsRepository backaccessRepository;



    // @Autowired
    // private StudentInfoRepository studentInfoRepository;

    // @Autowired
    // private TeacherRepository teacherRepository;

    // public List<URIs> getBackaccessByRoleId(Long roleId){
    //     return backaccessRepository.findBackaccessByRoleId(roleId);
    // }

    // public List<URIs> getBackaccessesByUserId(String userId){
    //     if(studentInfoRepository.findByStudentNumber(userId)!=null){
    //         return backaccessRepository.findBackaccessByRoleId((long)1);
    //     }
    //     else if(teacherRepository.findByJobNumber(userId)!=null){
    //         return backaccessRepository.findBackaccessByRoleId((long)teacherRepository.findByJobNumber(userId).getRole().getId());
    //     }
    //     else{
    //         return null;
    //     }
    // }

    // public List<URIs> getAllBackaccesses(){
    //     return backaccessRepository.findAll();
    // }
}
