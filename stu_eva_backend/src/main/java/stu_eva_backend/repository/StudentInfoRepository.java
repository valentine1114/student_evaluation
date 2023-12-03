package stu_eva_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import stu_eva_backend.model.StudentInfo;

@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfo, Integer> {

    @Query(value = "SELECT s FROM StudentInfo s WHERE s.student_number = ?1")
    StudentInfo findByStudentNumber(String studentNumber);

    @Query(value = "SELECT s FROM StudentInfo s WHERE s.name = ?1")
    StudentInfo findByUsername(String username);
}
