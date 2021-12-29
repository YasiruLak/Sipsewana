package lk.ijse.sipsewana.bo.custom;

import lk.ijse.sipsewana.bo.SuperBO;
import lk.ijse.sipsewana.dto.CourseDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/20/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public interface CourseBO extends SuperBO {
    boolean saveCourse(CourseDTO courseDTO)throws Exception;
    boolean updateCourse(CourseDTO courseDTO)throws Exception;
    boolean deleteCourse(String courseDTO)throws Exception;
    CourseDTO searchCourse(CourseDTO courseDTO)throws Exception;
    ArrayList<CourseDTO> getAll()throws Exception;
    boolean ifCourseExists(String code) throws SQLException, ClassNotFoundException;
}
