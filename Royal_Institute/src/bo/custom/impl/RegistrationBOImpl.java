package bo.custom.impl;

import bo.custom.RegistrationBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.RegistrationDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dto.RegistrationDTO;
import dto.StudentDTO;
import entity.Registration;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {
    RegistrationDAOImpl registrationDAO= DAOFactory.getInstance().getDAO(DAOType.REGISTRATION);
    @Override
    public int getNewOrderId() throws Exception {
         int lastNO = registrationDAO.getLastRegistrationId();
         if (lastNO == 0) {
            return 001;
         }
         int newNO=(lastNO+1);
         return newNO;
    }

    @Override
    public boolean saveReg(RegistrationDTO registrationDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteReg(int regNo) throws Exception {
        return false;
    }

    @Override
    public boolean updateReg(RegistrationDTO registrationDTO) throws Exception {
        return false;
    }

    @Override
    public StudentDTO getReg(int regNo) throws Exception {
        return null;
    }

    @Override
    public ArrayList<RegistrationDTO> getAllReg() throws Exception {
        List<Registration> registrationList=registrationDAO.findAll();
        ArrayList<RegistrationDTO> dtoList=new ArrayList();
        for(Registration registration:registrationList){
            dtoList.add(new RegistrationDTO(
                    registration.getRegNo(),
                    registration.getRegDate(),
                    registration.getRegFee(),
                    registration.getStudentId(),
                    registration.getCourseCode()
            ));
        }
        return dtoList;
    }
}
