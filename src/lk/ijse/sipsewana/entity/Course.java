package lk.ijse.sipsewana.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
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
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Course implements  SuperEntity{
    @Id
    private String id;
    private String name;
    private String duration;
    private double fee;
    @OneToMany(mappedBy = "course",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Registration> courseInfo = new ArrayList<>();

    public Course() {
    }

    public Course(String id, String name, String duration, double fee) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
    }

    public Course(String id, String name, String duration, double fee, List<Registration> courseInfo) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.courseInfo = courseInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public List<Registration> getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(List<Registration> courseInfo) {
        this.courseInfo = courseInfo;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                ", courseInfo=" + courseInfo +
                '}';
    }
}
