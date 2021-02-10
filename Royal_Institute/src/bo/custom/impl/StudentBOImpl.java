package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.StudentDAO;
import dao.custom.impl.StudentDAOImpl;
import db.FactoryConfiguration;
import dto.StudentDTO;
import entity.Student;
import model.StudentTM;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAOImpl studentDAO= DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public boolean saveStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.save(new Student(studentDTO.getId(),
                studentDTO.getStudent_name(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGender()));
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(studentDTO.getId(),
                studentDTO.getStudent_name(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGender()));
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        Student student=studentDAO.find(id);
        return new StudentDTO(
                student.getId(),
                student.getStudent_name(),
                student.getAddress(),
                student.getContact(),
                student.getDob(),
                student.getGender());
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        List<Student> studentList=studentDAO.findAll();
        ArrayList<StudentDTO> dtoList=new ArrayList();
        for(Student student:studentList){
            dtoList.add(new StudentDTO(
                    student.getId(),
                    student.getStudent_name(),
                    student.getAddress(),
                    student.getContact(),
                    student.getDob(),
                    student.getGender()
            ));
        }
        return dtoList;
    }
}
