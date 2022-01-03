package lk.ijse.sipsewana.view.tm;

import java.time.LocalDate;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 1/2/2022
 * @month : 01
 * @year : 2022
 * @since : 0.1.0
 **/
public class StudentTM implements Comparable<StudentTM>{
    private String niceNo;
    private String name;
    private String address;
    private LocalDate dateOfBirth;
    private String gender;
    private String contact;

    public StudentTM() {
    }

    public StudentTM(String niceNo, String name, String address, LocalDate dateOfBirth, String gender, String contact) {
        this.niceNo = niceNo;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contact = contact;
    }

    public String getNiceNo() {
        return niceNo;
    }

    public void setNiceNo(String niceNo) {
        this.niceNo = niceNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "StudentTM{" +
                "niceNo='" + niceNo + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    @Override
    public int compareTo(StudentTM o) {
        return niceNo.compareTo(o.getNiceNo());
    }
}