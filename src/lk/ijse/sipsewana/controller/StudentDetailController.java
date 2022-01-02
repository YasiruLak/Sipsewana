package lk.ijse.sipsewana.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.sipsewana.bo.BOFactory;
import lk.ijse.sipsewana.bo.custom.StudentBO;
import lk.ijse.sipsewana.dao.custom.impl.StudentDAOImpl;
import lk.ijse.sipsewana.dto.StudentDTO;
import lk.ijse.sipsewana.entity.Student;
import lk.ijse.sipsewana.util.ValidationUtil;
import lk.ijse.sipsewana.view.tm.StudentTM;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/16/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public class StudentDetailController {
    public TableView <StudentTM>tblStudent;
    public TableColumn colNic;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colDateOfBirth;
    public TableColumn colGender;
    public TableColumn colContact;
    public JFXTextField txtFullName;
    public JFXTextField txtNicNo;
    public JFXTextField txtAddress;
    public JFXDatePicker dpkDateOfBirth;
    public JFXComboBox cmbGender;
    public JFXTextField txtContact;
    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;

    private final StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.STUDENT);
    public TextField txtSearch;
    public AnchorPane context;

    public void initialize(){

        colNic.setCellValueFactory(new PropertyValueFactory<>("niceNo"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        loadAllStudents();

        storeValidations();

        cmbGender.getItems().addAll(
                "Male",
                "Female"
        );
        cmbGender.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                txtNicNo.setText(newValue.getNiceNo());
                txtFullName.setText(newValue.getName());
                txtAddress.setText(newValue.getAddress());
                dpkDateOfBirth.setValue(newValue.getDateOfBirth());
                cmbGender.setValue(newValue.getGender());
                txtContact.setText(newValue.getContact());
                btnSave.setDisable(true);
            }
        });

        txtSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                searchStore(newValue);
            }
        });
    }

    private void loadAllStudents() {
        tblStudent.getItems().clear();
        ArrayList<StudentDTO> allStudents = null;
        try {
            allStudents = studentBO.getAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (StudentDTO student : allStudents) {
            tblStudent.getItems().add(new StudentTM(student.getNiceNo(),student.getName(),student.getAddress(),
                    student.getDateOfBirth(),student.getGender(),student.getContact()));
        }

    }

    private void clear() {
        txtFullName.clear();
        txtNicNo.clear();
        txtAddress.clear();
        txtContact.clear();
        cmbGender.getSelectionModel().clearSelection();
        dpkDateOfBirth.getEditor().clear();
    }

    public void SaveOnAction(ActionEvent actionEvent) {

        String nic = txtNicNo.getText();
        String name = txtFullName.getText();
        String address = txtAddress.getText();
        LocalDate dob = dpkDateOfBirth.getValue();
        String gender = cmbGender.getValue().toString();
        String contact = txtContact.getText();

        try {
            if (existStudent(nic)) {
                new Alert(Alert.AlertType.ERROR, nic + " Already Exists").show();
            }
            else {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved...!").show();

                clear();
                StudentDTO studentDTO = new StudentDTO( nic, name,address, dob, gender, contact );
                try {
                    studentBO.addStudent(studentDTO);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                tblStudent.getItems().add(new StudentTM( nic, name,address, dob, gender, contact));

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Registration.fxml"));
                Parent parent = loader.load();
                RegistrationController controller = loader.getController();
                controller.getStudent(studentDTO);
                context.getChildren().clear();
                context.getChildren().add(parent);
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to save the student " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {

        String nic = txtNicNo.getText();
        String name = txtFullName.getText();
        String address = txtAddress.getText();
        LocalDate dob = dpkDateOfBirth.getValue();
        String gender = cmbGender.getValue().toString();
        String contact = txtContact.getText();

        try {
            if (!existStudent(nic)) {
                new Alert(Alert.AlertType.ERROR, nic + " There is no such student associated with the id "+nic).show();
            }
            else {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated...!").show();
                clear();
                StudentDTO studentDTO = new StudentDTO(nic, name,address, dob, gender, contact);
                try {
                    studentBO.updateStudent(studentDTO);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                btnSave.setDisable(false);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to update the student " + nic + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        StudentTM selectedStudent = tblStudent.getSelectionModel().getSelectedItem();
        selectedStudent.setName(name);
        selectedStudent.setAddress(address);
        selectedStudent.setNiceNo(nic);
        selectedStudent.setContact(contact);
        selectedStudent.setGender(gender);
        selectedStudent.setDateOfBirth(dob);
        tblStudent.refresh();
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String id = tblStudent.getSelectionModel().getSelectedItem().getNiceNo();
        try {
            if (!existStudent(id)) {
                new Alert(Alert.AlertType.ERROR, "There is no such student associated with the id " + id).show();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted...!").show();
                try {
                    studentBO.deleteStudent(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                tblStudent.getItems().remove(tblStudent.getSelectionModel().getSelectedItem());
                tblStudent.getSelectionModel().clearSelection();
                clear();
                btnSave.setDisable(false);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the student " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    boolean existStudent(String id) throws SQLException, ClassNotFoundException {
        return studentBO.ifStudentExist(id);
    }

    public void searchStore(String value) {
        ObservableList<StudentTM> obList = FXCollections.observableArrayList();
        try {

            List<Student> students = StudentDAOImpl.searchStudent(value);

            students.forEach(e->{
                obList.add(
                        new StudentTM(e.getNiceNo(),e.getName(),e.getAddress(),e.getDateOfBirth(),e.getGender(),e.getContact()));
            });
            tblStudent.setItems(obList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap();
    Pattern nicPattern = Pattern.compile("^[0-9]{9}[V]$");
    Pattern namePattern = Pattern.compile("^[A-z ]{3,30}$");
    Pattern addressPattern = Pattern.compile("^[A-z0-9, ]{6,40}$");
    Pattern contactPattern = Pattern.compile("^[0-9]{3}[-]?[0-9]{7}$");

    private void storeValidations() {
        map.put(txtNicNo, nicPattern);
        map.put(txtFullName, namePattern);
        map.put(txtAddress, addressPattern);
        map.put(txtContact, contactPattern);
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
        Object response = ValidationUtil.validate(map,btnSave);

        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (response instanceof TextField) {
                TextField errorText = (TextField) response;
                errorText.requestFocus();
            } else if (response instanceof Boolean) {

            }
        }
    }
}
