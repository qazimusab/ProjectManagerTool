package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddProjectController extends BaseController implements Initializable {

    @FXML public TextField projectNameTextField;
    @FXML public TextField projectManagerTextField;
    @FXML public TextField projectNumberOfTeamMembersTextField;
    @FXML public TextField projectCurrentStatusTextField;
    @FXML public TextField projectHoursTextField;
    @FXML public TextField projectStartDateTextField;
    @FXML public TextField projectExpectedDateTextField;
    @FXML public TextField projectActualDateTextField;
    @FXML public Button addProjectButton;

    public SoftwareProject createSoftwareProjectFromFields()
    {
        return new SoftwareProject(projectNameTextField.getText(),projectManagerTextField.getText(),projectNumberOfTeamMembersTextField.getText(),
                projectCurrentStatusTextField.getText(),projectHoursTextField.getText(),projectStartDateTextField.getText(),projectExpectedDateTextField.getText(),
                projectActualDateTextField.getText());
    }

    @FXML
    public void addProjectButtonAction(ActionEvent event) throws IOException
    {
        databaseHelper.saveOrUpdateSoftwareProject(createSoftwareProjectFromFields());
        changeScene("../res/page_home.fxml",addProjectButton);
    }

    public void populateWithProject(SoftwareProject softwareProject){
        projectNameTextField.setText(softwareProject.projectName);
        projectManagerTextField.setText(softwareProject.projectManager);
        projectNumberOfTeamMembersTextField.setText(softwareProject.numberOfTeamMembers);
        projectCurrentStatusTextField.setText(softwareProject.currentStatus);
        projectHoursTextField.setText(softwareProject.hoursWorked);
        projectStartDateTextField.setText(softwareProject.startDate);
        projectExpectedDateTextField.setText(softwareProject.expectedDate);
        projectActualDateTextField.setText(softwareProject.actualDate);
    }
}


