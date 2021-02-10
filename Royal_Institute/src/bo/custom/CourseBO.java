package bo.custom;

import bo.SuperBO;
import dto.CourseDTO;
import dto.StudentDTO;

import java.util.ArrayList;

public interface CourseBO extends SuperBO {
    public boolean saveCourse(CourseDTO courseDTO)throws Exception;

    public boolean deleteCourse(String code)throws Exception;

    public boolean updateCourse(CourseDTO courseDTO)throws Exception;

    public CourseDTO getCourse(String code)throws Exception;

    public ArrayList<CourseDTO> getAllCourse()throws Exception;
}
