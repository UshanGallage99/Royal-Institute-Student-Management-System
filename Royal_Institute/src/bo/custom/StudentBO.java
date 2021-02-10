package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;
import model.StudentTM;

import java.util.ArrayList;
import java.util.List;

public interface StudentBO extends SuperBO{
    public boolean saveStudent(StudentDTO studentDTO)throws Exception;

    public boolean deleteStudent(String id)throws Exception;

    public boolean updateStudent(StudentDTO studentDTO)throws Exception;

    public StudentDTO getStudent(String id)throws Exception;

    public ArrayList<StudentDTO> getAllStudents()throws Exception;

}
