package lk.ijse.sipsewana.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 1/1/2022
 * @month : 01
 * @year : 2022
 * @since : 0.1.0
 **/
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Registration implements SuperEntity{
    @Id
    private String regId;
    private LocalDate regDate;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;

    public Registration() {
    }

    public Registration(String regId, LocalDate regDate, Student student, Course course) {
        this.regId = regId;
        this.regDate = regDate;
        this.student = student;
        this.course = course;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regId='" + regId + '\'' +
                ", regDate=" + regDate +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
