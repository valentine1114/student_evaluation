package stu_eva_backend.model;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher  implements User{
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "job_number")
    private String job_number;

    
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    // getters and setters...
    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_number() {
        return job_number;
    }

    public void setJob_number(String job_number) {
        this.job_number = job_number;
    }



}