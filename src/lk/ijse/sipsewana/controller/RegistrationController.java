package lk.ijse.sipsewana.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.sipsewana.bo.BOFactory;
import lk.ijse.sipsewana.bo.custom.RegistrationBO;
import lk.ijse.sipsewana.dao.custom.CourseDAO;
import lk.ijse.sipsewana.dao.custom.impl.CourseDAOImpl;
import lk.ijse.sipsewana.dao.custom.impl.StudentDAOImpl;
import lk.ijse.sipsewana.dto.CustomDTO;
import lk.ijse.sipsewana.dto.RegistrationDTO;
import lk.ijse.sipsewana.dto.StudentDTO;
import lk.ijse.sipsewana.entity.Course;
import lk.ijse.sipsewana.view.tm.RegisterDetailTM;

import java.sql.SQLException;
import java.time.LocalDate;
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
    public TableView <RegisterDetailTM>tblDetails;
    public TableColumn colRegId;
    public TableColumn colCourseId;
    public TableColumn colCourseName;
    public TableColumn colStudentName;
    public TableColumn colDate;
    public TextField txtSearch;
    public TableColumn colStudentId;
    public JFXCheckBox paidBox;

    CourseDAO courseDAO = new CourseDAOImpl();

    StudentDTO newStudent;
    
    private final RegistrationBO registerBO = (RegistrationBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.REGISTRATION);

    public void initialize(){

        lblRegNo.setText(generateNewId());
        loadCourseDetail();
        loadAllDetails();
        btnRegister.setDisable(true);

        tblDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("regId"));
        tblDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("studentNic"));
        tblDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("studentName"));
        tblDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("courseId"));
        tblDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("courseName"));
        tblDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("regDate"));

//        colRegId.setCellValueFactory(new PropertyValueFactory<>("regId"));
//        colStudentId.setCellValueFactory(new PropertyValueFactory<>("sId"));
//        colStudentName.setCellValueFactory(new PropertyValueFactory<>("sName"));
//        colCourseId.setCellValueFactory(new PropertyValueFactory<>("cId"));
//        colCourseName.setCellValueFactory(new PropertyValueFactory<>("cName"));
//        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        cmbCourseId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            getCourseDetails((String) newValue);

        });

        txtSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                searchStore(newValue);
            }
        });
    }

    private void loadAllDetails() {
        tblDetails.getItems().clear();
        try {
            ArrayList<CustomDTO> allDetails = registerBO.getAllDetails();
            for (CustomDTO detail : allDetails) {
                tblDetails.getItems().add(new RegisterDetailTM(detail.getRegId(),detail.getStudentNic(),detail.getStudentName(),
                        detail.getCourseId(),detail.getCourseName(),detail.getRegDate()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public boolean saveRegister(String regId,String sNic, String cId, LocalDate date) {
        try {
            RegistrationDTO registerDTO = new RegistrationDTO(regId,sNic,cId,date);
            return registerBO.registerDetails(registerDTO);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
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
        return tempDetailList.get(tempDetailList.size() - 1).getStudentNic();
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
        newStudent = studentDTO;
        if(newStudent!=null){
            txtStudentNic.setText(newStudent.getNicNo());
            txtStudentName.setText(newStudent.getName());
        }
    }

    public void getStudentName(String id) throws SQLException, ClassNotFoundException {
        try {
            String name = new StudentDAOImpl().getStudentName(id);
            txtStudentName.setText(name);
        }catch (Exception e){

        }
    }

    public void searchStore(String value) {

        ObservableList<RegisterDetailTM> obList = FXCollections.observableArrayList();

        List<CustomDTO> detail = registerBO.searchDetail(value);

        for (CustomDTO temp:detail) {
            obList.add(new RegisterDetailTM(temp.getRegId(),temp.getStudentNic(),temp.getStudentName(),temp.getCourseId(),temp.getCourseName(),temp.getRegDate()));
        }

        tblDetails.setItems(obList);
    }

    public void RegisterOnAction(ActionEvent actionEvent) {
        boolean b = saveRegister(lblRegNo.getText(),txtStudentNic.getText(),cmbCourseId.getValue().toString(),LocalDate.now());

        String id = lblRegNo.getText();
        String nic = txtStudentNic.getText();
        String name = txtStudentName.getText();
        String cId = cmbCourseId.getValue().toString();
        String cName = txtCourseName.getText();
        LocalDate date = LocalDate.now();

        if (b) {
            new Alert(Alert.AlertType.INFORMATION, "successfully Registered").show();
            tblDetails.getItems().add(new RegisterDetailTM(id,nic,name,cId,cName,date));
            lblRegNo.setText(generateNewId());
            txtCourseName.clear();
            txtStudentName.clear();
            txtStudentNic.clear();
            txtCourseFee.clear();
            txtCourseDuration.clear();
            cmbCourseId.getSelectionModel().clearSelection();
        } else {
            new Alert(Alert.AlertType.ERROR, "Register has not been done successfully").show();
        }
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
        try {
            getStudentName(txtStudentNic.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void paidOnAction(ActionEvent actionEvent) {
        boolean isSelect= paidBox.isSelected();
        if (isSelect) {
            btnRegister.setDisable(false);
        }

    }
}
