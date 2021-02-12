package bo.custom.impl;

import bo.custom.CourseBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.CourseDAOImpl;
import dto.CourseDTO;
import dto.StudentDTO;
import entity.Course;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {
    CourseDAOImpl courseDAO= DAOFactory.getInstance().getDAO(DAOType.COURSE);

    @Override
    public String getNewCourseId() throws Exception {
        String lastCourseId = courseDAO.getLastStudentID();
        if (lastCourseId == null) {
            return "C001";
        } else {
            int maxId = Integer.parseInt(lastCourseId.replace("C", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "C00" + maxId;
            } else if (maxId < 100) {
                id = "C0" + maxId;
            } else {
                id = "C" + maxId;
            }
            return id;
        }
    }

    @Override
    public boolean saveCourse(CourseDTO courseDTO) throws Exception {
        return courseDAO.save(new Course(courseDTO.getCode(),
                courseDTO.getCourse_name(),
                courseDTO.getCourse_fee(),
                courseDTO.getDuration()));

    }

    @Override
    public boolean deleteCourse(String code) throws Exception {
        return courseDAO.delete(code);
    }

    @Override
    public boolean updateCourse(CourseDTO courseDTO) throws Exception {
        return courseDAO.update(new Course(courseDTO.getCode(),
                courseDTO.getCourse_name(),
                courseDTO.getCourse_fee(),
                courseDTO.getDuration()));

    }

    @Override
    public CourseDTO getCourse(String code) throws Exception {
        Course course=courseDAO.find(code);
        return new CourseDTO(course.getCode(),
                course.getCourse_name(),
                course.getCourse_fee(),
                course.getDuration());
    }

    @Override
    public ArrayList<CourseDTO> getAllCourse() throws Exception {
        List<Course> studentList=courseDAO.findAll();
        ArrayList<CourseDTO> dtoList=new ArrayList();
        for(Course course:studentList){
            dtoList.add(new CourseDTO(
                    course.getCode(),
                    course.getCourse_name(),
                    course.getCourse_fee(),
                    course.getDuration()
            ));
        }
        return dtoList;
    }
}
