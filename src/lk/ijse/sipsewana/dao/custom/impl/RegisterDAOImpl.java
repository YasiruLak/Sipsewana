package lk.ijse.sipsewana.dao.custom.impl;

import lk.ijse.sipsewana.dao.custom.RegisterDAO;
import lk.ijse.sipsewana.entity.Registration;
import lk.ijse.sipsewana.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 1/1/2022
 * @month : 01
 * @year : 2022
 * @since : 0.1.0
 **/
public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public boolean add(Registration entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Registration entity) throws Exception {
        return false;
    }

    @Override
    public Registration search(String s) throws Exception {
        return null;
    }

    @Override
    public List getAll() throws Exception {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }

    @Override
    public boolean ifRegExist(String id) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT regId FROM Registration WHERE regId=:id");
        String id1 = (String) query.setParameter("id", id).uniqueResult();
        if (id1!=null){
            return true;
        }
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT regId FROM Registration ORDER BY regId DESC LIMIT 1");
        String s = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        if (s!=null) {
            int newStudentId = Integer.parseInt(s.replace("R", "")) + 1;
            return String.format("R%03d", newStudentId);
        }
       return null;
    }
}
