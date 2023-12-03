package stu_eva_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu_eva_backend.data.ManagerGPAData;
import stu_eva_backend.entity.ManagerGPAEntity;
import stu_eva_backend.repository.ManagerGPARepository;

import java.util.List;
@Service
public class ManagerGPAService {
    @Autowired
    private ManagerGPARepository managerGPARepository;
    public void saveManagerGPAData(List<ManagerGPAData> GPADataList) {
        // 将数据存储到MySQL数据库的student_scores表中
        for (ManagerGPAData GPAData : GPADataList) {
            ManagerGPAEntity ManagerGPAEntity = new ManagerGPAEntity();
            ManagerGPAEntity.setId(GPAData.getId());
            ManagerGPAEntity.setGrade( GPAData.getGrade());
            managerGPARepository.save(ManagerGPAEntity);
        }
    }
}
