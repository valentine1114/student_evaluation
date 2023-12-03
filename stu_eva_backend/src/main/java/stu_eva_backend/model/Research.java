package stu_eva_backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "Research")
public class Research {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "StudentID", nullable = false)
    private StudentInfo student;

    private Date time;

    private String type;

    private String content;
    private String uploadUrl;


    // Getters and setters...
}
