package stu_eva_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu_eva_backend.data.ManagerGPAData;
import stu_eva_backend.service.ManagerGPAService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagerGPAController {
    @Autowired
    private ManagerGPAService managerGPAService;
    @PostMapping("/upload/gpa")
    public ResponseEntity<String> uploadGPAData(@RequestBody List<ManagerGPAData> managerGPADataList) {
        try {
            managerGPAService.saveManagerGPAData(managerGPADataList);
            return ResponseEntity.ok("数据上传成功");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("数据上传失败");
        }
    }
}
