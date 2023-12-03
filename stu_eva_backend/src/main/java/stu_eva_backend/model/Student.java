package stu_eva_backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private Long id;
    private String number;
    private String name;
    private String status;

    // getters and setters
}
