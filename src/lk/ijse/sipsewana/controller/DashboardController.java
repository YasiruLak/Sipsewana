package lk.ijse.sipsewana.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/16/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public class DashboardController {
    public JFXButton btnExit;
    public JFXButton btnRegister;
    public JFXButton btnCourse;
    public JFXButton btnStudent;
    public AnchorPane DashboardContext;

    public void goToExitOnAction(ActionEvent actionEvent) throws IOException {
        Stage logStage = (Stage) btnExit.getScene().getWindow();
        logStage.close();

        URL resource = this.getClass().getResource("../view/LoginPg.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("SIPSEWANA INSTITUTE | YASIRU DAHANAYAKA");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();

    }

    public void goToRegisterOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/Registration.fxml");
        Parent load = FXMLLoader.load(resource);
        DashboardContext.getChildren().clear();
        DashboardContext.getChildren().add(load);
    }

    public void goToCourseOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/Courses.fxml");
        Parent load = FXMLLoader.load(resource);
        DashboardContext.getChildren().clear();
        DashboardContext.getChildren().add(load);
    }

    public void goToStudentDetailOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/StudentDetail.fxml");
        Parent load = FXMLLoader.load(resource);
        DashboardContext.getChildren().clear();
        DashboardContext.getChildren().add(load);

    }

    public void goToHelpOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/Help.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("SIPSEWANA INSTITUTE | YASIRU DAHANAYAKA");
        stage.centerOnScreen();
        stage.show();
    }

    public void goToSettingOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/Settings.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("SIPSEWANA INSTITUTE | YASIRU DAHANAYAKA");
        stage.centerOnScreen();
        stage.show();
    }
}
