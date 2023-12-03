package stu_eva_backend.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "student_info")
public class StudentInfo  implements User{
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "student_number")
    private String student_number;

    @Column(name = "name_pinyin")
    private String name_pinyin;

    @Column(name="gender")
    private String gender;

    @Column(name="id_number")
    private String id_number;
    
    @Column(name="nation")
    private String nation;
    
    @Column(name="ethnicity")
    private String ethnicity;
    
    @Column(name="dob")
    private Date dob;
    
    @Column(name="political_status")
    private String political_status;
    
    @Column(name="school")
    private String school;
    
    @Column(name="student_type")
    private String student_type;
    
    @Column(name="major")
    private String major;
    // getters and setters

    
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

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public String getName_pinyin() {
        return name_pinyin;
    }

    public void setName_pinyin(String name_pinyin) {
        this.name_pinyin = name_pinyin;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPolitical_status() {
        return political_status;
    }

    public void setPolitical_status(String political_status) {
        this.political_status = political_status;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudent_type() {
        return student_type;
    }

    public void setStudent_type(String student_type) {
        this.student_type = student_type;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


}