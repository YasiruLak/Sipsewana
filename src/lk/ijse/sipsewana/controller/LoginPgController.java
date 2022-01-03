package lk.ijse.sipsewana.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
public class LoginPgController {
    public JFXButton btnLogin;
    public JFXTextField pswPassword;
    public JFXTextField txtUserName;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {


        if (txtUserName.getText().equals("Yasiru") & pswPassword.getText().equals("19980611")){
            Stage logStage = (Stage) btnLogin.getScene().getWindow();
            logStage.close();

            URL resource = this.getClass().getResource("../view/Dashboard.fxml");
            Parent load = FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.show();
        }else{
            new Alert(Alert.AlertType.ERROR, " Password or User Name Incorrect ").show();
        }
    }
}
