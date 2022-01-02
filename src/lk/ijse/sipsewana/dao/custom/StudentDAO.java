package lk.ijse.sipsewana.dao.custom;

import lk.ijse.sipsewana.dao.CrudDAO;
import lk.ijse.sipsewana.dao.SuperDAO;
import lk.ijse.sipsewana.entity.Student;

import java.sql.SQLException;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/20/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public interface StudentDAO extends CrudDAO <Student, String> {
    boolean ifStudentExist(String id) throws SQLException, ClassNotFoundException;
    String getStudentName(String id) throws SQLException, ClassNotFoundException;
}
