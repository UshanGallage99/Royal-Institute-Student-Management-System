package dao.custom;

import dao.CrudDAO;
import entity.Registration;

public interface RegistrationDAO extends CrudDAO<Registration,Integer> {
    int getLastRegistrationId() throws Exception;
}
