package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddProjectController extends BaseController implements Initializable {

    @FXML public TextField projectNameTextField;
    @FXML public TextField projectManagerTextField;
    @FXML public TextField projectDescriptionTextField;
    @FXML public TextField projectTeamMemberNameTextField;
    @FXML public TextArea projectRiskAndStatusTextArea;
    @FXML public TextArea projectRequirementsTextArea;
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

    public SoftwareProject createSoftwareProjectFromFields()
    {
        return new SoftwareProject(projectNameTextField.getText(), projectManagerTextField.getText(),
                projectDescriptionTextField.getText(), projectTeamMemberNameTextField.getText(),
                projectRiskAndStatusTextArea.getText(), projectRequirementsTextArea.getText(),
                projectCurrentStatusTextField.getText(), projectRequirementsHoursTextField.getText(),
                projectDesigningHoursTextField.getText(), projectCodingHoursTextField.getText(),
                projectTestingHoursTextField.getText(), projectManagementHoursTextField.getText(),
                projectStartDateTextField.getText(), projectExpectedDateTextField.getText(),
                projectActualDateTextField.getText());
    }

    @FXML
    public void addProjectButtonAction(ActionEvent event) throws IOException
    {
        databaseHelper.saveOrUpdateSoftwareProject(createSoftwareProjectFromFields());
        changeScene("../res/page_home.fxml",addProjectButton);
    }
}


