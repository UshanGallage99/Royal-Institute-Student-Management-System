package entity;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class Student implements SuperEntity{
    private String NIC;
    private String StudentID;
    private String Student_name;
    private String Student_address;
    private String Contact;
    private String Dob;
    private String Gender;

    public Student() {
    }

    public Student(String NIC, String studentID, String student_name, String student_address, String contact, String dob, String gender) {
        this.NIC = NIC;
        StudentID = studentID;
        Student_name = student_name;
        Student_address = student_address;
        Contact = contact;
        Dob = dob;
        Gender = gender;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getStudent_name() {
        return Student_name;
    }

    public void setStudent_name(String student_name) {
        Student_name = student_name;
    }

    public String getStudent_address() {
        return Student_address;
    }

    public void setStudent_address(String student_address) {
        Student_address = student_address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "NIC='" + NIC + '\'' +
                ", StudentID='" + StudentID + '\'' +
                ", Student_name='" + Student_name + '\'' +
                ", Student_address='" + Student_address + '\'' +
                ", Contact='" + Contact + '\'' +
                ", Dob='" + Dob + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
