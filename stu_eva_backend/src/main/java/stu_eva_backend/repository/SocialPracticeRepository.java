package stu_eva_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import stu_eva_backend.model.SocialPractice;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface SocialPracticeRepository extends JpaRepository<SocialPractice, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into Social_Practice (StudentID, Time, ActivityTheme, Organizer, Position, Duration) values (:student, :time, :activityTheme, :organizer, :position, :duration)", nativeQuery = true)
    void saveCustom(@Param("student") Long student, @Param("time") Date time, @Param("activityTheme") String activityTheme, @Param("organizer") String organizer, @Param("position") String position, @Param("duration") Integer duration);

    @Modifying
    @Transactional
    @Query(value = "select ID,StudentID,Time, ActivityTheme, Organizer, Position, Duration from Social_Practice", nativeQuery = true)
    List<SocialPractice> findAllCustom();
}