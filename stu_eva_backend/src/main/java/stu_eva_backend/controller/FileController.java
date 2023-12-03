package stu_eva_backend.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    private final ResourceLoader resourceLoader;

    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/uploads/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        try {
            // 根据文件名加载文件资源
            Resource fileResource = resourceLoader.getResource("file:/Users/chenmingmeng/javaProject/student_evaluation_system/stu_eva_backend/src/main/resources/upload_files/" + filename);

            // 检查文件是否存在
            if (!fileResource.exists()) {
                return ResponseEntity.notFound().build();
            }

            // 设置响应头部，指定文件的下载名称
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");

            // 返回包含文件资源的响应实体
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(fileResource);
        } catch (Exception e) {
            // 处理异常
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

