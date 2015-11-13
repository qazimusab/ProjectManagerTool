package main;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Qazi Ahmed on 11/10/15.
 */
public class BaseController implements Initializable{
    protected DatabaseHelper databaseHelper;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        databaseHelper = new DatabaseHelper();
    }

    public void changeScene (String scene, Button button)
    {
        try {
            Stage primaryStage = (Stage) button.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
            primaryStage.setTitle("PMT 3000");
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.centerOnScreen();
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
