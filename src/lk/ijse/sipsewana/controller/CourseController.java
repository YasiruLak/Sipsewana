package lk.ijse.sipsewana.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.sipsewana.bo.BOFactory;
import lk.ijse.sipsewana.bo.custom.CourseBO;
import lk.ijse.sipsewana.dto.CourseDTO;
import lk.ijse.sipsewana.view.tm.CourseTM;
import lk.ijse.sipsewana.view.tm.StudentTM;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/16/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public class CourseController {
    private final CourseBO courseBO = (CourseBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.COURSE);

    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXTextField txtCourseName;
    public JFXTextField txtCourseFee;
    public JFXComboBox cmbDuration;
    public JFXTextField txtCourseId;
    public TableView <CourseTM>tblCourse;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colDuration;
    public TableColumn colFee;

    public void initialize(){
        tblCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
        tblCourse.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fee"));

        loadAllItems();

        cmbDuration.getItems().addAll(
                "1 Month",
                "3 Months",
                "6 Months",
                "1 Years",
                "18 Months",
                "2 Years"
        );
        cmbDuration.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });

        tblCourse.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                txtCourseId.setText(newValue.getId());
                txtCourseName.setText(newValue.getName());
                cmbDuration.setValue(newValue.getDuration());
                txtCourseFee.setText(String.valueOf(newValue.getFee()));
                btnSave.setDisable(true);
            }
        });

    }

    private void loadAllItems(){
        tblCourse.getItems().clear();
        ArrayList<CourseDTO> allCourse = null;
        try {
            allCourse = courseBO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (CourseDTO courseDTO : allCourse){
            tblCourse.getItems().add(new CourseTM(
                    courseDTO.getId(),
                    courseDTO.getName(),
                    courseDTO.getDuration(),
                    courseDTO.getFee()
            ));
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {

        String id = tblCourse.getSelectionModel().getSelectedItem().getId();

        try {
            if(!existCourse(id)){
                new Alert(Alert.AlertType.ERROR,"There is no such student associated with the id " + id).show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted..!").show();
                courseBO.deleteCourse(id);
                tblCourse.getItems().remove(tblCourse.getSelectionModel().getSelectedItem());
                tblCourse.getSelectionModel().clearSelection();
                initiUi();
                btnSave.setDisable(false);
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the student " + id).show();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        String courseId = txtCourseId.getText();
        String name = txtCourseName.getText();
        String duration = cmbDuration.getValue().toString();
        double fee = Double.parseDouble(txtCourseFee.getText());

        try {
            if (!existCourse(courseId)) {
                new Alert(Alert.AlertType.ERROR, courseId + " There is no such student associated with the id " + courseId).show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated...!");
                initiUi();
                CourseDTO courseDTO = new CourseDTO(courseId, name, duration, fee);

                    courseBO.updateCourse(courseDTO);
                    btnSave.setDisable(false);
                    tblCourse.refresh();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to update the student " + courseId + e.getMessage()).show();
        }

        CourseTM selectedCourse = tblCourse.getSelectionModel().getSelectedItem();
        selectedCourse.setName(name);
        selectedCourse.setDuration(duration);
        selectedCourse.setFee(fee);
        selectedCourse.setId(courseId);
        tblCourse.refresh();
    }

    public void SaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String courseId = txtCourseId.getText();
        String name = txtCourseName.getText();
        String duration = cmbDuration.getValue().toString();
        double fee = Double.parseDouble(txtCourseFee.getText());

        if (!courseId.matches("^(CT0)[0-9]{3,3}$")){
            new Alert(Alert.AlertType.ERROR,"Invalid Course Id" ).show();
            txtCourseId.requestFocus();
            return;
        }else if(!name.matches("^[A-z ]{3,40}$")){
            new Alert(Alert.AlertType.ERROR, "Invalid Name Type").show();
            txtCourseName.requestFocus();
            return;
        }else if(cmbDuration.getValue() == null){
            new Alert(Alert.AlertType.ERROR, "Please Enter Duration").show();
            cmbDuration.requestFocus();
            return;
        }else if(!txtCourseFee.getText().matches("^[0-9]{3,6}[.][0]$")){
            new Alert(Alert.AlertType.ERROR, "Invalid Fee Format").show();
            txtCourseFee.requestFocus();
            return;
        }

        if (!existCourse(courseId)){

            new Alert(Alert.AlertType.CONFIRMATION, "Successfully Saved" +courseId).show();
            CourseDTO courseDTO = new CourseDTO(courseId, name, duration, fee);

            try {
                courseBO.saveCourse(courseDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
            initiUi();
            loadAllItems();
        }else {
            new Alert(Alert.AlertType.ERROR, "Couldn't Save. Please Try Again");
        }

    }

    private boolean existCourse(String courseID) throws SQLException, ClassNotFoundException {
            return courseBO.ifCourseExists(courseID);
    }

    private void initiUi(){
        txtCourseFee.clear();
        txtCourseName.clear();
        txtCourseId.clear();
        cmbDuration.getSelectionModel().clearSelection();
    }
}
