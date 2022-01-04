package lk.ijse.sipsewana.dao.custom.impl;

import lk.ijse.sipsewana.dao.custom.StudentDAO;
import lk.ijse.sipsewana.entity.Student;
import lk.ijse.sipsewana.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/20/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public class StudentDAOImpl implements StudentDAO {

    public static List<Student> searchStudent(String s) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        List<Student> student = session.createQuery("FROM Student WHERE nicNo LIKE '%" + s + "%' or sName LIKE '%" + s + "%'").list();

        transaction.commit();

        session.close();

        return student;
    }

    @Override
    public boolean add(Student entity) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Student course = session.get(Student.class, s);

        session.delete(course);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean update(Student entity) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public Student search(String s){

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, s);

        transaction.commit();

        session.close();

        return student;
    }

    @Override
    public List getAll() throws Exception {

        ArrayList<Student> allStudents = new ArrayList();

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Student");

        allStudents = (ArrayList<Student>) query.list();

        transaction.commit();

        session.close();

        return allStudents;
    }

    @Override
    public void setSession(Session session) {

    }

    @Override
    public boolean ifStudentExist(String id){

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT nicNo FROM Student WHERE nicNo=:id");

        String id1 = (String) query.setParameter("id", id).uniqueResult();

        if (id1 != null) {
            return true;
        }

        transaction.commit();

        session.close();

        return false;
    }

    @Override
    public String getStudentName(String id) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT sName FROM Student WHERE nicNo=:id");

        String id1 = (String) query.setParameter("id", id).uniqueResult();

        if (id1 != null) {
            return id1;
        }

        transaction.commit();

        session.close();

        return null;
    }
}
