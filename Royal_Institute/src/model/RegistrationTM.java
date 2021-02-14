package model;

import dto.CourseDTO;
import dto.StudentDTO;

public class RegistrationTM {
    private Integer regNo;
    private String regDate;
    private double regFee;
    private StudentDTO studentId;
    private CourseDTO courseCode;

    public RegistrationTM() {
    }

    public RegistrationTM(Integer regNo, String regDate, double regFee, StudentDTO studentId, CourseDTO courseCode) {
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

    public StudentDTO getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentDTO studentId) {
        this.studentId = studentId;
    }

    public CourseDTO getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(CourseDTO courseCode) {
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
