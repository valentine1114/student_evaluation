package stu_eva_backend.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "Summary_Scores")
public class SummaryScores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "StudentID", nullable = false)
    private StudentInfo student;
    
    @Column(name = "Social_Practice_Score")
    private Float socialPracticeScore;
    
    @Column(name = "Research_Score")
    private Float researchScore;
    
    @Column(name = "Volunteer_Score")
    private Float volunteerScore;

    @Column(name = "Leadership_Score")
    private Float leadershipScore;

    @Column(name = "GPA_Score")
    private Float gpaScore;

    @Column(name="Summary_score")
    private Float yearlySummaryScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentInfo getStudent() {
        return student;
    }

    public void setStudent(StudentInfo student) {
        this.student = student;
    }

    public Float getSocialPracticeScore() {
        return socialPracticeScore;
    }

    public void setSocialPracticeScore(Float socialPracticeScore) {
        this.socialPracticeScore = socialPracticeScore;
    }

    public Float getResearchScore() {
        return researchScore;
    }

    public void setResearchScore(Float researchScore) {
        this.researchScore = researchScore;
    }

    public Float getVolunteerScore() {
        return volunteerScore;
    }

    public void setVolunteerScore(Float volunteerScore) {
        this.volunteerScore = volunteerScore;
    }

    public Float getLeadershipScore() {
        return leadershipScore;
    }

    public void setLeadershipScore(Float leadershipScore) {
        this.leadershipScore = leadershipScore;
    }

    public Float getGpaScore() {
        return gpaScore;
    }

    public void setGpaScore(Float gpaScore) {
        this.gpaScore = gpaScore;
    }

    public Float getSummaryScore() {
        return summaryScore;
    }

    public void setSummaryScore(Float summaryScore) {
        this.summaryScore = summaryScore;
    }

    @Column(name = "Summary_Score")
    private Float summaryScore;

    public Float getYearlySummaryScore() {
        return yearlySummaryScore;
    }

    public void setYearlySummaryScore(Float yearlySummaryScore) {
        this.yearlySummaryScore = yearlySummaryScore;
    }

    // Getters and setters...
}
