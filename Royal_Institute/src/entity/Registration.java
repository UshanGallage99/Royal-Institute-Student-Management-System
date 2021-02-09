package entity;

public class Registration implements SuperEntity{
    private Integer Registration_num;
    private String Registration_date;
    private double Registration_fee;
    private String StudentID;
    private String Course_code;

    public Registration() {
    }

    public Registration(Integer registration_num, String registration_date, double registration_fee, String studentID, String course_code) {
        Registration_num = registration_num;
        Registration_date = registration_date;
        Registration_fee = registration_fee;
        StudentID = studentID;
        Course_code = course_code;
    }

    public Integer getRegistration_num() {
        return Registration_num;
    }

    public void setRegistration_num(Integer registration_num) {
        Registration_num = registration_num;
    }

    public String getRegistration_date() {
        return Registration_date;
    }

    public void setRegistration_date(String registration_date) {
        Registration_date = registration_date;
    }

    public double getRegistration_fee() {
        return Registration_fee;
    }

    public void setRegistration_fee(double registration_fee) {
        Registration_fee = registration_fee;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getCourse_code() {
        return Course_code;
    }

    public void setCourse_code(String course_code) {
        Course_code = course_code;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "Registration_num=" + Registration_num +
                ", Registration_date='" + Registration_date + '\'' +
                ", Registration_fee=" + Registration_fee +
                ", StudentID='" + StudentID + '\'' +
                ", Course_code='" + Course_code + '\'' +
                '}';
    }
}
