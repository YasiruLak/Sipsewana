package lk.ijse.sipsewana.bo.custom.impl;

import lk.ijse.sipsewana.bo.custom.StudentBO;
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
public class StudentBOImpl implements StudentBO {
    @Override
    public ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean addStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean ifStudentExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
