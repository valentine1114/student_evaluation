package stu_eva_backend.data;
import java.util.Date;

public class ManagerInfoData {
    private Long id;
    private String name;
    private Integer student_number;
    private String name_pinyin;
    private String gender;
    private String id_number;
    private String nation;
    private String ethnicity;
    private Date dob;
    private String political_status;
    private String school;
    private String student_type;
    private String major;
    public ManagerInfoData() {
        // 默认构造函数
    }

    public ManagerInfoData(Long id,  String name, Integer student_number,String namePinyin,String gender,String idNumber,String nation,String ethnicity,Date dob,String politicalStatus,String school,String studentType,String major) {
        this.id = id;
        this.student_number=student_number;
        this.name = name;
        this.name_pinyin=namePinyin;
        this.gender=gender;
        this.id_number=idNumber;
        this.dob=dob;
        this.political_status=politicalStatus;
        this.school=school;
        this.student_type=studentType;
        this.major=major;
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

    public Integer getStudent_number() {
        return student_number;
    }

    public void setStudent_number(Integer student_number) {
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
