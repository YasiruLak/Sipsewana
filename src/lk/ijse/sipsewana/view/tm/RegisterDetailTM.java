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
public class RegisterDetailTM implements Comparable<RegisterDetailTM>{

    private String regId;
    private String studentNic;
    private String studentName;
    private String courseId;
    private String courseName;
    private LocalDate regDate;

    public RegisterDetailTM() {
    }

    public RegisterDetailTM(String regId, String studentNic, String studentName, String courseId, String courseName, LocalDate regDate) {
        this.regId = regId;
        this.studentNic = studentNic;
        this.studentName = studentName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.regDate = regDate;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getStudentNic() {
        return studentNic;
    }

    public void setStudentNic(String studentNic) {
        this.studentNic = studentNic;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "RegisterDetailTM{" +
                "regId='" + regId + '\'' +
                ", studentNice='" + studentNic + '\'' +
                ", studentName='" + studentName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", regDate=" + regDate +
                '}';
    }

    @Override
    public int compareTo(RegisterDetailTM o) {
        return regId.compareTo(o.getRegId());
    }
}
