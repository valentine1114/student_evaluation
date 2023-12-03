package stu_eva_backend.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stu_eva_backend.repository.BackaccessRepository;
import stu_eva_backend.repository.StudentInfoRepository;
import stu_eva_backend.repository.TeacherRepository;
import stu_eva_backend.repository.URIsRepository;
import stu_eva_backend.model.Backaccess;
import stu_eva_backend.model.URIs;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class BackaccessServices {
    @Autowired
    private BackaccessRepository backaccessRepository;



    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public List<URIs> findURIsByRoleId(Integer roleId){
        List<Backaccess> backaccesses = backaccessRepository.findByRoleId(roleId);
        List<URIs> urisList = new ArrayList<>();
        for(Backaccess backaccess : backaccesses){
            urisList.add(backaccess.getURI());
        }
        return urisList;
    }

    public List<URIs> getBackaccessesByUserId(String userId){
        if(studentInfoRepository.findByStudentNumber(userId)!=null){
            return this.findURIsByRoleId(1);
        }
        else if(teacherRepository.findByJobNumber(userId)!=null){
            return this.findURIsByRoleId(teacherRepository.findByJobNumber(userId).getRole().getId());
        }
        else{
            return null;
        }
    }

    public List<URIs> getAllBackaccesses(){
        List<Backaccess> backaccesses=backaccessRepository.findAll();
        List<URIs> urisList = new ArrayList<>();
        for(Backaccess backaccess : backaccesses){
            urisList.add(backaccess.getURI());
        }
        return urisList;
    }
}
