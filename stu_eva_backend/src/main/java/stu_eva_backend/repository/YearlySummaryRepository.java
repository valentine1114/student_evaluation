 
package stu_eva_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stu_eva_backend.model.YearlySummary;

@Repository
public interface YearlySummaryRepository extends JpaRepository<YearlySummary, Integer> {
}
