package lk.ijse.sipsewana.bo.custom.impl;

import lk.ijse.sipsewana.bo.custom.RegistrationBO;
import lk.ijse.sipsewana.dto.CustomDTO;
import lk.ijse.sipsewana.dto.RegistrationDTO;

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

    @Override
    public boolean registerDetails(RegistrationDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<CustomDTO> getAllDetails() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean ifExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<CustomDTO> searchDetail(String value) {
        return null;
    }
}
