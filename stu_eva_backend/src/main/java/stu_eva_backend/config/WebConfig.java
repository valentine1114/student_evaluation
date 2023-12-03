package stu_eva_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")    // 虚拟路径
                // file: 表示以本地的路径方式去访问绝对路径。
                .addResourceLocations("file:/Users/chenmingmeng/javaProject/student_evaluation_system/stu_eva_backend/src/main/resources/upload_files");    // 绝对路径
    }
}

