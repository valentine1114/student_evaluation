package stu_eva_backend.data;

public class ManagerVolunteerData {

    private Long id;
    private Integer volunteerHours;
    public ManagerVolunteerData() {
        // 默认构造函数
    }

    public ManagerVolunteerData(Long id, Integer volunteerHours) {
        this.id = id;
        this.volunteerHours = volunteerHours;
    }

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

