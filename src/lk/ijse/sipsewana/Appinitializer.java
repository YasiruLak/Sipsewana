package lk.ijse.sipsewana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 12/15/2021
 * @month : 12
 * @year : 2021
 * @since : 0.1.0
 **/
public class Appinitializer extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getResource("view/LoginPg.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("SIPSEWANA INSTITUTE | YASIRU DAHANAYAKA");
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
