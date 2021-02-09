package entity;

public class Course implements SuperEntity{
    private String Course_code;
    private String Course_name;
    private double Course_fee;
    private String duration;

    public Course() {
    }

    public Course(String course_code, String course_name, double course_fee, String duration) {
        Course_code = course_code;
        Course_name = course_name;
        Course_fee = course_fee;
        this.duration = duration;
    }

    public String getCourse_code() {
        return Course_code;
    }

    public void setCourse_code(String course_code) {
        Course_code = course_code;
    }

    public String getCourse_name() {
        return Course_name;
    }

    public void setCourse_name(String course_name) {
        Course_name = course_name;
    }

    public double getCourse_fee() {
        return Course_fee;
    }

    public void setCourse_fee(double course_fee) {
        Course_fee = course_fee;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Course_code='" + Course_code + '\'' +
                ", Course_name='" + Course_name + '\'' +
                ", Course_fee=" + Course_fee +
                ", duration='" + duration + '\'' +
                '}';
    }
}
