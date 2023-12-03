package stu_eva_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu_eva_backend.data.ManagerVolunteerData;
import stu_eva_backend.entity.ManagerVolunteerEntity;
import stu_eva_backend.repository.ManagerVolunteerRepository;

import java.util.List;

@Service
public class ManagerVolunteerService {

    @Autowired
    private ManagerVolunteerRepository managerVolunteerRepository;

    public void saveManagerVolunteerData(List<ManagerVolunteerData> volunteerDataList) {
        // 将数据存储到MySQL数据库的volunteer_service表中
        for (ManagerVolunteerData volunteerData : volunteerDataList) {
            ManagerVolunteerEntity ManagerVolunteerEntity = new ManagerVolunteerEntity();
            ManagerVolunteerEntity.setId(volunteerData.getId());
            ManagerVolunteerEntity.setVolunteerHours(volunteerData.getVolunteerHours());
            managerVolunteerRepository.save(ManagerVolunteerEntity);
        }
    }
}
