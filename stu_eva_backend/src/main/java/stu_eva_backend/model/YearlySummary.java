package stu_eva_backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Yearly_Summary")
public class YearlySummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "StudentID", nullable = false)
    private StudentInfo student;

    private String summary;



    //private Integer year;


    // Getters and setters...
    
}


