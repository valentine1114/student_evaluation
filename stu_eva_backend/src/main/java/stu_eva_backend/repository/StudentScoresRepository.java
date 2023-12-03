 
package stu_eva_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stu_eva_backend.model.StudentScores;

@Repository
public interface StudentScoresRepository extends JpaRepository<StudentScores, Integer> {
}
