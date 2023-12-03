package stu_eva_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu_eva_backend.model.SocialPractice;
import stu_eva_backend.repository.SocialPracticeRepository;
import java.util.List;
import stu_eva_backend.model.SummaryScores;
import stu_eva_backend.repository.SummaryScoresRepository;
import java.util.Optional;

@Service
public class SocialPracticeServices {

    private final SocialPracticeRepository socialPracticeRepository;

    @Autowired
    public SocialPracticeServices(SocialPracticeRepository socialPracticeRepository) {
        this.socialPracticeRepository = socialPracticeRepository;
    }

    public SocialPractice saveSocialPractice2sql(SocialPractice socialPractice) {
        socialPracticeRepository.saveCustom(socialPractice.getStudent().getId(), socialPractice.getTime(), socialPractice.getActivityTheme(), socialPractice.getOrganizer(), socialPractice.getPosition(), socialPractice.getDuration());
        return socialPractice;
    }

    // 其他可能的服务方法...
    public List<SocialPractice> findAllCustom() {
        return socialPracticeRepository.findAllCustom();
    }
    

}
