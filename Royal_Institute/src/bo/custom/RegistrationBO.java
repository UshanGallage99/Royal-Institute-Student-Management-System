package bo.custom;

import bo.SuperBO;
import dto.RegistrationDTO;
import dto.StudentDTO;

import java.util.ArrayList;

public interface RegistrationBO extends SuperBO {
    public int getNewOrderId() throws Exception;
    public boolean saveReg(RegistrationDTO registrationDTO)throws Exception;

    public boolean deleteReg(int regNo)throws Exception;

    public boolean updateReg(RegistrationDTO registrationDTO)throws Exception;

    public StudentDTO getReg(int regNo)throws Exception;

    public ArrayList<RegistrationDTO> getAllReg()throws Exception;
}
