package lk.ijse.sipsewana.dao.custom;

import lk.ijse.sipsewana.dao.CrudDAO;
import lk.ijse.sipsewana.entity.Course;

import java.util.List;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/20/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public interface CourseDAO extends CrudDAO<Course, String> {
    boolean ifCourseExists(String code);
    Course getCourseDetail(String name);
    List getCourse();
}
