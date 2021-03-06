package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeController extends BaseController implements Initializable{

    @FXML
    private VBox projectNameVbox;
    @FXML
    private VBox projectManagerVbox;
    @FXML
    private VBox viewButtonsVbox;

    public final static double CELL_MIN_HEIGHT = 40;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        setHeader();
        try {
            populateAllProjects();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setHeader() {
        HBox projectNameContainer = new HBox();
        HBox projectManagerContainer = new HBox();
        HBox viewProjectContainer = new HBox();

        projectNameContainer.setMinHeight(CELL_MIN_HEIGHT);
        projectManagerContainer.setMinHeight(CELL_MIN_HEIGHT);
        viewProjectContainer.setMinHeight(CELL_MIN_HEIGHT);

        Label projectName = new Label("Project Name");
        projectName.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        projectName.setTextFill(Color.BLUE);
        projectNameContainer.getChildren().addAll(projectName);
        projectNameContainer.setAlignment(Pos.CENTER_LEFT);
        projectNameContainer.setPadding(new Insets(0,0,0,20));

        Label projectManager = new Label("Project Manager");
        projectManager.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        projectManager.setTextFill(Color.BLUE);
        projectManagerContainer.setAlignment(Pos.CENTER);
        projectManagerContainer.getChildren().addAll(projectManager);

        Button viewProject = new Button("Add Project");
        viewProjectContainer.getChildren().addAll(viewProject);
        viewProjectContainer.setAlignment(Pos.CENTER_RIGHT);
        viewProjectContainer.setPadding(new Insets(0, 20, 0, 0));
        viewProject.setOnAction(event -> changeScene("../res/page_add_project.fxml",viewProject));

        projectNameVbox.getChildren().add(projectNameContainer);
        projectManagerVbox.getChildren().add(projectManagerContainer);
        viewButtonsVbox.getChildren().add(viewProjectContainer);

        Separator separator = new Separator();
        Separator separator2 = new Separator();
        Separator separator3 = new Separator();

        projectNameVbox.getChildren().add(separator);
        projectManagerVbox.getChildren().add(separator2);
        viewButtonsVbox.getChildren().add(separator3);
    }

    public void populateAllProjects() throws IOException {
        ArrayList<SoftwareProject> allProjects = databaseHelper.getAllProjects();
        if(!allProjects.isEmpty()) {
            for (SoftwareProject softwareProject : allProjects) {
                addNewProject(softwareProject);
            }
        }
    }

    public void addNewProject(SoftwareProject softwareProject) {
        HBox projectNameContainer = new HBox();
        HBox projectManagerContainer = new HBox();
        HBox viewProjectContainer = new HBox();

        projectNameContainer.setMinHeight(CELL_MIN_HEIGHT);
        projectManagerContainer.setMinHeight(CELL_MIN_HEIGHT);
        viewProjectContainer.setMinHeight(CELL_MIN_HEIGHT);

        Label projectName = new Label(softwareProject.projectName);
        Label projectManager = new Label(softwareProject.projectManager);
        Button viewProject = new Button("View");

        viewProject.setOnAction(event -> {
            try {
                Stage primaryStage = (Stage) viewProject.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../res/page_edit_project.fxml"));
                primaryStage.setTitle("PMT 3000");
                primaryStage.setScene(new Scene(loader.load()));
                primaryStage.centerOnScreen();
                primaryStage.show();
                loader.<EditProjectController>getController().populateWithProject(softwareProject);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        projectNameContainer.getChildren().addAll(projectName);
        projectNameContainer.setAlignment(Pos.CENTER_LEFT);
        projectNameContainer.setPadding(new Insets(0,0,0,20));

        projectManagerContainer.getChildren().addAll(projectManager);
        projectManagerContainer.setAlignment(Pos.CENTER);

        viewProjectContainer.getChildren().addAll(viewProject);
        viewProjectContainer.setAlignment(Pos.CENTER_RIGHT);
        viewProjectContainer.setPadding(new Insets(0,20,0,0));

        Separator separator = new Separator();
        Separator separator2 = new Separator();
        Separator separator3 = new Separator();

        projectNameVbox.getChildren().add(projectNameContainer);
        projectManagerVbox.getChildren().add(projectManagerContainer);
        viewButtonsVbox.getChildren().add(viewProjectContainer);

        projectNameVbox.getChildren().add(separator);
        projectManagerVbox.getChildren().add(separator2);
        viewButtonsVbox.getChildren().add(separator3);
    }
}
