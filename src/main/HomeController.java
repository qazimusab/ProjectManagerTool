package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable{

    @FXML
    private VBox projectNameVbox;
    @FXML
    private VBox projectManagerVbox;
    @FXML
    private VBox viewButtonsVbox;

    public final static double CELL_MIN_HEIGHT = 40;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setHeader();
        addNewProject(new SoftwareProject("Chipotle", "Micheal Syphoe"));
        addNewProject(new SoftwareProject("Wendy's", "Rodney Murray"));
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
        viewProject.setOnAction(event -> addNewProject(new SoftwareProject("Test", "Test")));

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
