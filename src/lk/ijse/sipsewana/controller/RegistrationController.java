package lk.ijse.sipsewana.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import lk.ijse.sipsewana.dao.custom.CourseDAO;
import lk.ijse.sipsewana.dao.custom.impl.CourseDAOImpl;
import lk.ijse.sipsewana.entity.Course;
import java.util.List;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/16/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public class RegistrationController {
    public JFXTextField txtStudentName;
    public JFXButton btnSave;
    public Label lblRegNo;
    public JFXDatePicker dpkDateOfBirth;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public JFXTextField txtEmail;
    public JFXTextField txtCourseName;
    public JFXTextField txtCourseDuration;
    public JFXTextField txtCourseFee;
    public JFXComboBox cmbCourseId;
    public JFXComboBox cmbGender;
    public JFXTextField txtStudentNic;

    CourseDAO courseDAO = new CourseDAOImpl();

    public void initialize(){
        loadCourseDetail();

        cmbGender.getItems().addAll("Male", "Female");

        cmbGender.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });
        cmbCourseId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            getCourseDetails((String) newValue);

        });
    }

    private void getCourseDetails(String id){
        Course courseDetails = courseDAO.getCourseDetail(id);
        if (courseDetails == null){
            new Alert(Alert.AlertType.WARNING, "Empty Result Set");
        } else {
            cmbCourseId.setValue(courseDetails.getId());
            txtCourseName.setText(courseDetails.getName());
            txtCourseDuration.setText(courseDetails.getDuration());
            txtCourseFee.setText(String.valueOf(courseDetails.getFee()));

        }
    }

    private void loadCourseDetail() {
        List<String> course = null;
        course = new CourseDAOImpl().getCourse();

        cmbCourseId.getItems().addAll(course);
    }

    public void saveOnAction(ActionEvent actionEvent) {
    }

}
