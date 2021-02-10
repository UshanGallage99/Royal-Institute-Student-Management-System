package dto;

public class CourseDTO {
    private String code;
    private String course_name;
    private double course_fee;
    private String duration;

    public CourseDTO() {
    }

    public CourseDTO(String code, String course_name, double course_fee, String duration) {
        this.code = code;
        this.course_name = course_name;
        this.course_fee = course_fee;
        this.duration = duration;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public double getCourse_fee() {
        return course_fee;
    }

    public void setCourse_fee(double course_fee) {
        this.course_fee = course_fee;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "CourseTM{" +
                "code='" + code + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_fee=" + course_fee +
                ", duration='" + duration + '\'' +
                '}';
    }
}
