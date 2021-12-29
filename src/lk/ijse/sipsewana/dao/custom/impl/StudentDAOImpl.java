package lk.ijse.sipsewana.dao.custom.impl;

import lk.ijse.sipsewana.dao.custom.StudentDAO;
import lk.ijse.sipsewana.entity.Student;
import org.hibernate.Session;

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

    @Override
    public boolean add(Student entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Student entity) throws Exception {
        return false;
    }

    @Override
    public Student search(String s) throws Exception {
        return null;
    }

    @Override
    public List getAll() throws Exception {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }
}
