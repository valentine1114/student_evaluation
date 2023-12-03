package stu_eva_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu_eva_backend.data.ManagerGPAData;
import stu_eva_backend.data.ManagerInfoData;
import stu_eva_backend.entity.ManagerGPAEntity;
import stu_eva_backend.entity.ManagerInfoEntity;
import stu_eva_backend.model.SummaryScores;
import stu_eva_backend.model.StudentInfo;
import stu_eva_backend.repository.ManagerInfoRepository;
import stu_eva_backend.repository.SummaryScoresRepository;
import stu_eva_backend.repository.StudentInfoRepository;

import java.util.List;

@Service
public class ManagerInfoService {
    @Autowired
    private ManagerInfoRepository managerInfoRepository;
    @Autowired
    private SummaryScoresRepository summaryScoresRepository;
    @Autowired
    private StudentInfoRepository studentInfoRepository;
    public void saveManagerInfoData(List<ManagerInfoData> InfoDataList) {
        // 将数据存储到MySQL数据库的student_info表中
        for (ManagerInfoData InfoData : InfoDataList) {
            ManagerInfoEntity ManagerInfoEntity = new ManagerInfoEntity();
            // ManagerInfoEntity.setId(InfoData.getId());
            ManagerInfoEntity.setName(InfoData.getName());
            ManagerInfoEntity.setStudent_number(InfoData.getStudent_number());
            ManagerInfoEntity.setName_pinyin(InfoData.getName_pinyin());
            ManagerInfoEntity.setGender(InfoData.getGender());
            ManagerInfoEntity.setId_number(InfoData.getId_number());
            ManagerInfoEntity.setNation(InfoData.getNation());
            ManagerInfoEntity.setEthnicity(InfoData.getEthnicity());
            ManagerInfoEntity.setPolitical_status(InfoData.getPolitical_status());
            ManagerInfoEntity.setDob(InfoData.getDob());
            ManagerInfoEntity.setSchool(InfoData.getSchool());
            ManagerInfoEntity.setMajor(InfoData.getMajor());
            ManagerInfoEntity.setStudent_type(InfoData.getStudent_type());
            managerInfoRepository.save(ManagerInfoEntity);
            StudentInfo studentInfoEntity = new StudentInfo();
            studentInfoEntity.setStudent_number(ManagerInfoEntity.getStudent_number().toString(0));
            studentInfoRepository.save(studentInfoEntity);
            // 创建和保存新的SummaryScores实体
            SummaryScores summaryScores = new SummaryScores();
            summaryScores.setStudent(studentInfoEntity); //这里假设你的ManagerInfoEntity实现了StudentInfo接口，如果没有，你需要创建一个新的StudentInfo实体
            summaryScores.setSocialPracticeScore(null);
            summaryScores.setResearchScore(null);
            summaryScores.setVolunteerScore(null);
            summaryScores.setLeadershipScore(null);
            summaryScores.setGpaScore(null);
            summaryScores.setSummaryScore(null);
            summaryScoresRepository.save(summaryScores);
        }
    }
}
