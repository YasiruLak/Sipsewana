package lk.ijse.sipsewana.dao.custom;

import lk.ijse.sipsewana.dao.CrudDAO;
import lk.ijse.sipsewana.entity.Registration;

import java.sql.SQLException;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 1/1/2022
 * @month : 01
 * @year : 2022
 * @since : 0.1.0
 **/
public interface RegisterDAO extends CrudDAO<Registration,String> {
    boolean ifRegExist(String id) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;
}
