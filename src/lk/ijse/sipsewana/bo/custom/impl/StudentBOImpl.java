package lk.ijse.sipsewana.bo.custom.impl;

import lk.ijse.sipsewana.bo.custom.StudentBO;
import lk.ijse.sipsewana.dao.DAOFactory;
import lk.ijse.sipsewana.dao.custom.StudentDAO;
import lk.ijse.sipsewana.dto.StudentDTO;
import lk.ijse.sipsewana.entity.Student;

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

    StudentDAO studentDAO= DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        ArrayList<StudentDTO> allStudents = new ArrayList<>();
        ArrayList<Student> all = (ArrayList<Student>) studentDAO.getAll();
        for (Student student : all) {
            allStudents.add(new StudentDTO(
                    student.getNicNo(),
                    student.getName(),
                    student.getAddress(),
                    student.getDateOfBirth(),
                    student.getGender(),
                    student.getContact()));
        }
        return allStudents;
    }

    @Override
    public boolean addStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.add(new Student(
                studentDTO.getNicNo(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getDateOfBirth(),
                studentDTO.getGender(),
                studentDTO.getContact()));
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(
                studentDTO.getNicNo(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getDateOfBirth(),
                studentDTO.getGender(),
                studentDTO.getContact()));
    }

    @Override
    public boolean ifStudentExist(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.ifStudentExist(id);
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDAO.delete(id);
    }
}
