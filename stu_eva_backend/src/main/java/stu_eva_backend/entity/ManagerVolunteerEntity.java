package stu_eva_backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "volunteer_service")
public class ManagerVolunteerEntity {

    @Id
    private Long id;

    @Column(name = "Hours")
    private Integer volunteerHours;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVolunteerHours() {
        return volunteerHours;
    }

    public void setVolunteerHours(Integer volunteerHours) {
        this.volunteerHours = volunteerHours;
    }
}
