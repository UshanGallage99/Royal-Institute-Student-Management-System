package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Registration implements SuperEntity{
    @Id
    private Integer regNo;
    private String regDate;
    private double regFee;
    private String studentId;
    private String courseCode;

    public Registration() {
    }

    public Registration(Integer regNo, String regDate, double regFee, String studentId, String courseCode) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.regFee = regFee;
        this.studentId = studentId;
        this.courseCode = courseCode;
    }

    public Integer getRegNo() {
        return regNo;
    }

    public void setRegNo(Integer regNo) {
        this.regNo = regNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regNo=" + regNo +
                ", regDate='" + regDate + '\'' +
                ", regFee=" + regFee +
                ", studentId='" + studentId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
