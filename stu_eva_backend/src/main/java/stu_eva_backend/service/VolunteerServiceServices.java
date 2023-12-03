package stu_eva_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu_eva_backend.model.VolunteerService;
import stu_eva_backend.repository.VolunteerServiceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerServiceServices {
    @Autowired
    private VolunteerServiceRepository volunteerServiceRepository;

    public List<VolunteerService> getAllVolunteerServices() {
        return volunteerServiceRepository.findAll();
    }

    // Additional CRUD methods
    // ...
    public VolunteerService createVolunteerService(VolunteerService volunteerService) {
        return volunteerServiceRepository.save(volunteerService);
    }

    public Optional<VolunteerService> getVolunteerServiceById(String idCard) {
        return volunteerServiceRepository.findById(Integer.valueOf(idCard));
    }


    public VolunteerService updateVolunteerService(VolunteerService updatedVolunteerService) {
        return volunteerServiceRepository.save(updatedVolunteerService);
    }
    public void deleteVolunteerServiceById(String idCard) {
        volunteerServiceRepository.deleteById(Integer.valueOf(idCard));
    }



}
