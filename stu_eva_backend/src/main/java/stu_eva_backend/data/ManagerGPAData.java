package stu_eva_backend.data;

public class ManagerGPAData {

    private Long id;
    private Float grade;
    public ManagerGPAData() {
        // 默认构造函数
    }

    public ManagerGPAData(Long id,  Float grade) {
        this.id = id;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }
}

