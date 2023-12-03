package stu_eva_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stu_eva_backend.model.SocialPractice;
import stu_eva_backend.service.SocialPracticeServices;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/socialPractice")
public class SocialPracticeController {

    private final SocialPracticeServices socialPracticeService;

    @Autowired
    public SocialPracticeController(SocialPracticeServices socialPracticeService) {
        this.socialPracticeService = socialPracticeService;
    }
    

    @PostMapping("/saveData")
    public ResponseEntity<SocialPractice> saveSocialPractice(@RequestBody SocialPractice socialPractice) {
        SocialPractice savedSocialPractice = socialPracticeService.saveSocialPractice2sql(socialPractice);
        return ResponseEntity.ok(savedSocialPractice);
    }

    // 其他可能的控制器方法...
    @GetMapping("/findAll")
    public ResponseEntity<List<SocialPractice>> getAllSocialPractices() {
        List<SocialPractice> socialPractices = socialPracticeService.findAllCustom();
        return ResponseEntity.ok(socialPractices);
    }


}
