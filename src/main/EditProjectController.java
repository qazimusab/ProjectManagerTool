package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditProjectController extends BaseController implements Initializable {

    @FXML public Label projectNameTextField;
    @FXML public TextField projectManagerTextField;
    @FXML public TextField projectDescriptionTextField;
    @FXML public TextField projectTeamMemberNameTextField;
    @FXML public TextField projectRiskAndStatusTextField;
    @FXML public TextField projectCurrentStatusTextField;
    @FXML public TextField projectRequirementsHoursTextField;
    @FXML public TextField projectDesigningHoursTextField;
    @FXML public TextField projectCodingHoursTextField;
    @FXML public TextField projectTestingHoursTextField;
    @FXML public TextField projectManagementHoursTextField;
    @FXML public TextField projectStartDateTextField;
    @FXML public TextField projectExpectedDateTextField;
    @FXML public TextField projectActualDateTextField;
    @FXML public Button addProjectButton;
    @FXML public Button deleteProjectButton;

    public SoftwareProject createSoftwareProjectFromFields()
    {
        return new SoftwareProject(projectNameTextField.getText(), projectManagerTextField.getText(),
                projectDescriptionTextField.getText(), projectTeamMemberNameTextField.getText(),
                projectRiskAndStatusTextField.getText(), projectCurrentStatusTextField.getText(),
                projectRequirementsHoursTextField.getText(), projectDesigningHoursTextField.getText(),
                projectCodingHoursTextField.getText(), projectTestingHoursTextField.getText(),
                projectManagementHoursTextField.getText(), projectStartDateTextField.getText(),
                projectExpectedDateTextField.getText(), projectActualDateTextField.getText());
    }

    @FXML
    public void updateProjectButtonAction(ActionEvent event) throws IOException
    {
        databaseHelper.saveOrUpdateSoftwareProject(createSoftwareProjectFromFields());
        changeScene("../res/page_home.fxml",addProjectButton);
    }

    public void populateWithProject(SoftwareProject softwareProject){
        projectNameTextField.setText(softwareProject.projectName);
        projectManagerTextField.setText(softwareProject.projectManager);
        projectDescriptionTextField.setText(softwareProject.projectDescription);
        projectTeamMemberNameTextField.setText(softwareProject.projectTeamMemberNames);
        projectRiskAndStatusTextField.setText(softwareProject.projectRisk);
        projectCurrentStatusTextField.setText(softwareProject.projectCurrentStatus);
        projectRequirementsHoursTextField.setText(softwareProject.projectRequirementHours);
        projectDesigningHoursTextField.setText(softwareProject.projectDesignHours);
        projectCodingHoursTextField.setText(softwareProject.projectCodingHours);
        projectTestingHoursTextField.setText(softwareProject.projectTestingHours);
        projectManagementHoursTextField.setText(softwareProject.projectManagementHours);
        projectStartDateTextField.setText(softwareProject.startDate);
        projectExpectedDateTextField.setText(softwareProject.expectedDate);
        projectActualDateTextField.setText(softwareProject.actualDate);
    }

    @FXML
    public void deleteProjectButtonAction(ActionEvent actionEvent) throws IOException {
        String nameOfProjectToDelete = createSoftwareProjectFromFields().projectName;
        databaseHelper.deleteProject(nameOfProjectToDelete);
        changeScene("../res/page_home.fxml",deleteProjectButton);
    }
}


