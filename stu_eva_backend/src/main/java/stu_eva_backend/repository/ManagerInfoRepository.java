package stu_eva_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import stu_eva_backend.entity.ManagerInfoEntity;

public interface ManagerInfoRepository extends JpaRepository<ManagerInfoEntity, Long> {
    // 可以添加自定义的查询方法或者使用默认提供的方法
}
