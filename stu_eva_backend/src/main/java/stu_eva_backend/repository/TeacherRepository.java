package stu_eva_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stu_eva_backend.model.Teacher;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(value = "SELECT s FROM Teacher s WHERE s.job_number = ?1")
    Teacher findByJobNumber(String jobNumber);

    @Query(value = "SELECT s FROM Teacher s WHERE s.name = ?1")
    Teacher findByUsername(String username);
}