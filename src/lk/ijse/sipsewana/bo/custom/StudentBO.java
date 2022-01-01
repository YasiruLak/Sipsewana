package lk.ijse.sipsewana.bo.custom;

import lk.ijse.sipsewana.bo.SuperBO;
import lk.ijse.sipsewana.dto.StudentDTO;

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
public interface StudentBO extends SuperBO {
    ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException;

    boolean addStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException;

    boolean updateStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException;

    boolean ifStudentExist(String id) throws SQLException, ClassNotFoundException;

    boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;
}
