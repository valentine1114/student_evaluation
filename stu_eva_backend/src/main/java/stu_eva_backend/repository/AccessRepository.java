package stu_eva_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stu_eva_backend.model.Access;
import javax.transaction.Transactional;

@Transactional
@Repository
public interface AccessRepository extends JpaRepository<Access, Long> {
}