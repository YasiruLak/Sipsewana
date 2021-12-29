package lk.ijse.sipsewana.bo.custom.impl;

import lk.ijse.sipsewana.bo.custom.CourseBO;
import lk.ijse.sipsewana.dao.DAOFactory;
import lk.ijse.sipsewana.dao.custom.CourseDAO;
import lk.ijse.sipsewana.dto.CourseDTO;
import lk.ijse.sipsewana.entity.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/20/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public class CourseBOImpl implements CourseBO {

    CourseDAO courseDAO= DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.COURSE);

    @Override
    public boolean saveCourse(CourseDTO courseDTO) throws Exception {
        return courseDAO.add(
                new Course(
                        courseDTO.getId(),
                        courseDTO.getName(),
                        courseDTO.getDuration(),
                        courseDTO.getFee()
                )
        );
    }

    @Override
    public boolean updateCourse(CourseDTO courseDTO) throws Exception {
        return courseDAO.update(
                new Course(
                        courseDTO.getId(),
                        courseDTO.getName(),
                        courseDTO.getDuration(),
                        courseDTO.getFee()
                )
        );
    }

    @Override
    public boolean deleteCourse(String id) throws Exception {
        return courseDAO.delete(id);
    }

    @Override
    public CourseDTO searchCourse(CourseDTO courseDTO) throws Exception {
        return courseDTO(courseDAO.search(String.valueOf(course(courseDTO))));
    }

    @Override
    public ArrayList<CourseDTO> getAll() throws Exception {
        ArrayList<CourseDTO> allCourse = new ArrayList<>();
        ArrayList<Course> courses = (ArrayList<Course>) courseDAO.getAll();
        for (Course course : courses){
            allCourse.add(
                    new CourseDTO(
                            course.getId(),
                            course.getName(),
                            course.getDuration(),
                            course.getFee()
                    )
            );
        }
        return allCourse;
    }

    @Override
    public boolean ifCourseExists(String code) throws SQLException, ClassNotFoundException {
        return courseDAO.ifCourseExists(code);
    }

    private CourseDTO courseDTO(Course course){
        return new CourseDTO(
                course.getId(),
                course.getName(),
                course.getDuration(),
                course.getFee()
        );
    }
    private Course course(CourseDTO courseDTO){
        return new Course(
                courseDTO.getId(),
                courseDTO.getName(),
                courseDTO.getDuration(),
                courseDTO.getFee()
        );
    }
}
