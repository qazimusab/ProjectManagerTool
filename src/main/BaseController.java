package main;

import javafx.fxml.Initializable;

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
}
