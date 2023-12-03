package stu_eva_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu_eva_backend.data.ManagerInfoData;
import stu_eva_backend.service.ManagerInfoService;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ManagerInfoController {
    @Autowired
    private ManagerInfoService managerInfoService;
    @PostMapping("/upload/info")
    public ResponseEntity<String> uploadInfoData(@RequestBody List<ManagerInfoData> managerInfoDataList) {
        try {
            managerInfoService.saveManagerInfoData(managerInfoDataList);
            return ResponseEntity.ok("数据上传成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("数据上传失败");
        }
    }
}
