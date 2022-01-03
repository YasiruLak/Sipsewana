package lk.ijse.sipsewana.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;
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
public class Student implements SuperEntity {
    @Id
    private String niceNo;
    private String sName;
    private String address;
    private LocalDate dateOfBirth;
    private String gender;
    private String contact;
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Registration> studentInfo;

    public Student() {
    }

    public Student(String niceNo, String name, String address, LocalDate dateOfBirth, String gender, String contact) {
        this.niceNo = niceNo;
        this.sName = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contact = contact;
    }

    public Student(String niceNo, String name, String address, LocalDate dateOfBirth, String gender, String contact, List<Registration> studentInfo) {
        this.niceNo = niceNo;
        this.sName = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contact = contact;
        this.studentInfo = studentInfo;
    }

    public String getNiceNo() {
        return niceNo;
    }

    public void setNiceNo(String niceNo) {
        this.niceNo = niceNo;
    }

    public String getName() {
        return sName;
    }

    public void setName(String name) {
        this.sName = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Registration> getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(List<Registration> studentInfo) {
        this.studentInfo = studentInfo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "niceNo='" + niceNo + '\'' +
                ", name='" + sName + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", contact='" + contact + '\'' +
                ", studentInfo=" + studentInfo +
                '}';
    }
}
