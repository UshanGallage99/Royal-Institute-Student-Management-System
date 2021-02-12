package dao.custom.impl;

import dao.custom.RegistrationDAO;
import db.FactoryConfiguration;
import entity.Registration;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;


import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {
    @Override
    public boolean save(Registration registration) throws Exception {
        return false;
    }

    @Override
    public boolean update(Registration registration) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws Exception {
        return false;
    }

    @Override
    public Registration find(Integer integer) throws Exception {
        return null;
    }

    @Override
    public List<Registration> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Registration> list=session.createCriteria(Registration.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public int getLastRegistrationId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query =  session.createSQLQuery("SELECT regNo FROM Registration ORDER BY regNo DESC LIMIT 1");
        int rst =(int)query.uniqueResult();
        transaction.commit();
        return rst;
    }
}
