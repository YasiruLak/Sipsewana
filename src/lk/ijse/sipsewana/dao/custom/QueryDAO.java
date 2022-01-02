package lk.ijse.sipsewana.dao.custom;

import lk.ijse.sipsewana.dao.SuperDAO;
import lk.ijse.sipsewana.dto.CustomDTO;

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
public interface QueryDAO extends SuperDAO {
    ArrayList<CustomDTO> getAll();
    List<CustomDTO> searchDetail(String s);
}
