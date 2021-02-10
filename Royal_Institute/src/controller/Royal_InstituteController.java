package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.CourseBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CourseTM;
import model.StudentTM;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class Royal_InstituteController implements Initializable {
    public JFXTabPane root;
    public TableView tblStudents;
    public TableColumn colNIC;
    public TableColumn colStudentID;
    public TableColumn colStudentName;
    public TableColumn colStudentAddress;
    public TableColumn colContact;
    public TableColumn colDob;
    public TableColumn colGender;
    public JFXTextField txtNIC;
    public JFXTextField txtStudentID;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtContact;
    public JFXTextField txtDob;
    public JFXTextField txtGender;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXTextField txtCode;
    public JFXTextField txtCourseName;
    public JFXTextField txtCourseFee;
    public JFXTextField txtDuration;
    public JFXButton btnCourseAdd;
    public JFXButton btnCourseUpdate;
    public JFXButton btnCourseDelete;
    public TableView tblCourse;
    public JFXComboBox cmbStudentID;
    public JFXComboBox cmbCourseCode;
    public Label lblRegistrationID;
    public JFXTextField txtStudentName2;
    public JFXTextField txtCourseName2;
    public JFXTextField txtCourseFee2;
    public JFXTextField txtCourseDuration2;
    public JFXTextField txtRegistrationFee;
    public TableView tblRegistration;
    public TableColumn colNIC11;
    public TableColumn colStudentID11;
    public TableColumn colStudentName11;
    public TableColumn colStudentAddress11;
    public TableColumn colStudentAddress111;
    public JFXButton btnRegistration;
    public TableColumn colCourseCode;
    public TableColumn colCourseName;
    public TableColumn colCourseFee;
    public TableColumn colCourseDuration;

    StudentBO studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);
    CourseBO courseBO = BOFactory.getInstance().getBO(BOType.COURSE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*Students*/
        colStudentID.setCellValueFactory(new PropertyValueFactory("id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory("student_name"));
        colStudentAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colDob.setCellValueFactory(new PropertyValueFactory("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory("gender"));

        try {
            loadAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblStudents.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) ->{
                    setDataStudent((StudentTM) newValue);
                } );
        /*Course*/
        colCourseCode.setCellValueFactory(new PropertyValueFactory("code"));
        colCourseName.setCellValueFactory(new PropertyValueFactory("course_name"));
        colCourseFee.setCellValueFactory(new PropertyValueFactory("course_fee"));
        colCourseDuration.setCellValueFactory(new PropertyValueFactory("duration"));

        try {
            loadAllCourses();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblCourse.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) ->{
                    setDataCourse((CourseTM) newValue);
                } );

    }

    private void setDataStudent(StudentTM tm){
        txtStudentID.setText(tm.getId());
        txtStudentName.setText(tm.getStudent_name());
        txtStudentAddress.setText(tm.getAddress());
        txtContact.setText(tm.getContact());
        txtDob.setText(tm.getDob());
        txtGender.setText(tm.getGender());
    }
    private void setDataCourse(CourseTM tm){
        txtCode.setText(tm.getCode());
        txtCourseName.setText(tm.getCourse_name());
        txtCourseFee.setText(tm.getCourse_fee()+"");
        txtDuration.setText(tm.getDuration());
    }

    private void loadAllStudents() throws Exception {
        tblStudents.getItems().clear();
        List<StudentDTO> allStudents=studentBO.getAllStudents();
        ObservableList<StudentTM> tmList= FXCollections.observableArrayList();
        for(StudentDTO studentDTO:allStudents){
            StudentTM tm=new StudentTM(
                    studentDTO.getId(),
                    studentDTO.getStudent_name(),
                    studentDTO.getAddress(),
                    studentDTO.getContact(),
                    studentDTO.getDob(),
                    studentDTO.getGender()
            );
            tmList.add(tm);
        }
        tblStudents.setItems(tmList);
    }
    private void loadAllCourses() throws Exception {
        tblCourse.getItems().clear();
        List<CourseDTO> allCourses=courseBO.getAllCourse();
        ObservableList<CourseTM> tmList= FXCollections.observableArrayList();

        for(CourseDTO courseDTO:allCourses){
            CourseTM tm=new CourseTM(
                    courseDTO.getCode(),
                    courseDTO.getCourse_name(),
                    courseDTO.getCourse_fee(),
                    courseDTO.getDuration()
            );
            tmList.add(tm);
        }
        tblCourse.setItems(tmList);
    }

    /*Students*/
    public void btnAddOnAction(ActionEvent actionEvent) throws Exception {
        boolean isAdded=studentBO.saveStudent(new StudentDTO(
                txtStudentID.getText(),
                txtStudentName.getText(),
                txtStudentAddress.getText(),
                txtContact.getText(),
                txtDob.getText(),
                txtGender.getText()

        ));
        System.out.println("UShan");
        if(isAdded){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Student Added Success...");
            alert.showAndWait();
        }
        loadAllStudents();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws Exception {
        studentBO.updateStudent(new StudentDTO(txtStudentID.getText(),
                txtStudentName.getText(),
                txtStudentAddress.getText(),
                txtContact.getText(),
                txtDob.getText(),
                txtGender.getText()
                ));

        loadAllStudents();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are you sure whether you want to delete this Student ?",
                ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> buttonType=alert.showAndWait();
        if(buttonType.get()==ButtonType.YES){
            StudentTM selectedItem= (StudentTM) tblStudents.getSelectionModel().getSelectedItem();
            try{
                studentBO.deleteStudent(selectedItem.getId());
                tblStudents.getItems().remove(selectedItem);
                tblStudents.getSelectionModel().clearSelection();

            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR,"Failed to delete the Student",ButtonType.OK).show();

            }
        }

    }
    public void txtStudentIDOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO studentDTO=studentBO.getStudent(txtStudentID.getText());
        if(studentDTO!=null){
            txtStudentID.setText(studentDTO.getId());
            txtStudentName.setText(studentDTO.getStudent_name());
            txtStudentAddress.setText(studentDTO.getAddress());
            txtContact.setText(studentDTO.getContact());
            txtDob.setText(studentDTO.getDob());
            txtGender.setText(studentDTO.getGender());

        }
    }
/*Course*/
    public void btnCourseAddOnAction(ActionEvent actionEvent) throws Exception {
        boolean b = courseBO.saveCourse(new CourseDTO(txtCode.getText(),
                txtCourseName.getText(),
                Double.parseDouble(txtCourseFee.getText()),
                txtDuration.getText()));

        if(b){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Course Added Success...");
            alert.showAndWait();
        }
        txtCode.setText("");
        txtCourseName.setText("");
        txtCourseFee.setText("");
        txtDuration.setText("");

        loadAllCourses();
    }

    public void btnCourseUpdateOnAction(ActionEvent actionEvent) throws Exception {
        courseBO.updateCourse(new CourseDTO(
                txtCode.getText(),
                txtCourseName.getText(),
                Double.parseDouble(txtCourseFee.getText()),
                txtDuration.getText())
        );
        loadAllCourses();
    }

    public void btnCourseDeleteOnAction(ActionEvent actionEvent) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are you sure whether you want to delete this Course?",
                ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> buttonType=alert.showAndWait();
        if(buttonType.get()==ButtonType.YES){
            CourseTM selectedItem= (CourseTM) tblCourse.getSelectionModel().getSelectedItem();
            try{
                courseBO.deleteCourse(selectedItem.getCode());
                tblCourse.getItems().remove(selectedItem);
                tblCourse.getSelectionModel().clearSelection();

            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR,"Failed to delete the Course",ButtonType.OK).show();

            }
        }
    }

    public void txtCodeOnAction(ActionEvent actionEvent) throws Exception {
        CourseDTO courseDTO=courseBO.getCourse(txtCode.getText());
        if(courseDTO !=null){
            txtCode.setText(courseDTO.getCode());
            txtCourseName.setText(courseDTO.getCourse_name());
            txtCourseFee.setText(courseDTO.getCourse_fee()+"");
            txtDuration.setText(courseDTO.getDuration());
        }
    }

    public void btnRegistrationOnAction(ActionEvent actionEvent) {
    }


}
