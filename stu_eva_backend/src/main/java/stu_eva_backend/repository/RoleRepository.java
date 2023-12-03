package stu_eva_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import stu_eva_backend.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
