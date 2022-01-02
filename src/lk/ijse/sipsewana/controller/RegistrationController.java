package lk.ijse.sipsewana.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.sipsewana.bo.BOFactory;
import lk.ijse.sipsewana.bo.custom.RegistrationBO;
import lk.ijse.sipsewana.dao.custom.CourseDAO;
import lk.ijse.sipsewana.dao.custom.impl.CourseDAOImpl;
import lk.ijse.sipsewana.dao.custom.impl.StudentDAOImpl;
import lk.ijse.sipsewana.dto.CustomDTO;
import lk.ijse.sipsewana.dto.StudentDTO;
import lk.ijse.sipsewana.entity.Course;
import lk.ijse.sipsewana.view.tm.RegisterDetailTM;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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
    public Label lblRegNo;
    public JFXTextField txtCourseName;
    public JFXTextField txtCourseDuration;
    public JFXTextField txtCourseFee;
    public JFXComboBox cmbCourseId;
    public JFXTextField txtStudentNic;
    public JFXButton btnRegister;
    public TableView tblDetails;
    public TableColumn colRegId;
    public TableColumn colCourseId;
    public TableColumn colCourseName;
    public TableColumn colStudentName;
    public TableColumn colDate;
    public TextField txtSearch;

    CourseDAO courseDAO = new CourseDAOImpl();

    StudentDTO newStudent;
    
    private final RegistrationBO registerBO = (RegistrationBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.REGISTRATION);

    public void initialize(){

        lblRegNo.setText(generateNewId());
        lblRegNo.setDisable(true);
        btnRegister.setDisable(true);
        loadCourseDetail();
        loadAllDetails();

        colRegId.setCellValueFactory(new PropertyValueFactory<>("regId"));
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("cId"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("cName"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("sName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        cmbCourseId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            getCourseDetails((String) newValue);

        });
    }

    private void loadAllDetails() {
        tblDetails.getItems().clear();
        try {
            ArrayList<CustomDTO> allDetails = registerBO.getAllDetails();
            for (CustomDTO detail : allDetails) {
                tblDetails.getItems().add(new RegisterDetailTM(detail.getRegId(),detail.getsNic(),detail.getsName(),
                        detail.getcId(),detail.getcName(),detail.getRegDate()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private String generateNewId() {
        try {
            return registerBO.generateNewID();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new id " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (tblDetails.getItems().isEmpty()) {
            return "R001";
        } else {
            String id = getLastDetailId();
            int newDetailId = Integer.parseInt(id.replace("R", "")) + 1;
            return String.format("R%03d", newDetailId);
        }
    }

    private String getLastDetailId() {
        List<RegisterDetailTM> tempDetailList = new ArrayList(tblDetails.getItems());
        Collections.sort(tempDetailList);
        return tempDetailList.get(tempDetailList.size() - 1).getsId();
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

    public void getStudent(StudentDTO studentDTO){
        newStudent= studentDTO;
        if(newStudent!=null){
            txtStudentNic.setText(newStudent.getNiceNo());
            txtStudentName.setText(newStudent.getName());
        }
    }

    public void RegisterOnAction(ActionEvent actionEvent) {
    }
}
