package lk.ijse.sipsewana.bo.custom.impl;

import com.mysql.cj.Session;
import lk.ijse.sipsewana.bo.custom.RegistrationBO;
import lk.ijse.sipsewana.dao.DAOFactory;
import lk.ijse.sipsewana.dao.custom.CourseDAO;
import lk.ijse.sipsewana.dao.custom.QueryDAO;
import lk.ijse.sipsewana.dao.custom.RegisterDAO;
import lk.ijse.sipsewana.dao.custom.StudentDAO;
import lk.ijse.sipsewana.dto.CustomDTO;
import lk.ijse.sipsewana.dto.RegistrationDTO;
import lk.ijse.sipsewana.entity.Course;
import lk.ijse.sipsewana.entity.Registration;
import lk.ijse.sipsewana.entity.Student;
import lk.ijse.sipsewana.util.FactoryConfiguration;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 1/1/2022
 * @month : 01
 * @year : 2022
 * @since : 0.1.0
 **/
public class RegistrationBOImpl implements RegistrationBO {

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);
    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.COURSE);
    private final RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.REGISTRATION);
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.QUERY);

    @Override
    public boolean registerDetails(RegistrationDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<CustomDTO> getAllDetails() throws SQLException, ClassNotFoundException {
        ArrayList<CustomDTO> allDetails = new ArrayList<>();
        ArrayList<CustomDTO> all = queryDAO.getAll();
        for (CustomDTO register : all) {
            allDetails.add(new CustomDTO(register.getRegId(),register.getsNic(),register.getsName(),
                    register.getcId(),register.getcName(),register.getRegDate()));
        }
        return allDetails;
    }


    @Override
    public boolean ifExist(String id) throws SQLException, ClassNotFoundException {
        return registerDAO.ifRegExist(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return registerDAO.generateNewID();
    }

    @Override
    public List<CustomDTO> searchDetail(String value) {
        return queryDAO.searchDetail(value);
    }
}
