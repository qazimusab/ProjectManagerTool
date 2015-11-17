package main;

public class SoftwareProject
{
    public String projectName;
    public String projectManager;
    public String projectDescription;
    public String projectTeamMemberNames;
    public String projectRisk;
    public String projectCurrentStatus;
    public String projectRequirementHours;
    public String projectDesignHours;
    public String projectCodingHours;
    public String projectTestingHours;
    public String projectManagementHours;
    public String startDate;
    public String expectedDate;
    public String actualDate;

    public SoftwareProject(String projectName, String projectManager) {
        this.projectName = projectName;
        this.projectManager = projectManager;
    }

    public SoftwareProject(String projectName, String projectManager,
                           String projectDescription, String projectTeamMemberNames,
                           String projectRisk, String projectCurrentStatus,
                           String projectRequirementHours,String projectDesignHours,
                           String projectCodingHours, String projectTestingHours,
                           String projectManagementHours, String startDate,
                           String expectedDate, String actualDate) {
        this.projectName = projectName;
        this.projectManager = projectManager;
        this.projectDescription = projectDescription;
        this.projectTeamMemberNames = projectTeamMemberNames;
        this.projectRisk = projectRisk;
        this.projectCurrentStatus = projectCurrentStatus;
        this.projectRequirementHours = projectRequirementHours;
        this.projectDesignHours = projectDesignHours;
        this.projectCodingHours = projectCodingHours;
        this.projectTestingHours = projectTestingHours;
        this.projectManagementHours = projectManagementHours;
        this.startDate = startDate;
        this.expectedDate = expectedDate;
        this.actualDate = actualDate;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(projectName)
                .append("@")
                .append(projectManager)
                .append("@")
                .append(projectDescription == null ? "" : "projectDescription" + projectDescription)
                .append("@")
                .append(projectTeamMemberNames == null ? "" : "projectTeamMemberNames" + projectTeamMemberNames)
                .append("@")
                .append(projectRisk == null ? "" : "projectRisk" + projectRisk)
                .append("@")
                .append(projectCurrentStatus == null ? "" : "projectCurrentStatus" + projectCurrentStatus)
                .append("@")
                .append(projectRequirementHours == null ? "" : "projectRequirementHours" + projectRequirementHours)
                .append("@")
                .append(projectDesignHours == null ? "" : "projectDesignHours" + projectDesignHours)
                .append("@")
                .append(projectCodingHours == null ? "" : "projectCodingHours" + projectCodingHours)
                .append("@")
                .append(projectTestingHours == null ? "" : "projectTestingHours" + projectTestingHours)
                .append("@")
                .append(projectManagementHours == null ? "" : "projectManagementHours" + projectManagementHours)
                .append("@")
                .append(startDate == null ? "" : "startDate" + startDate)
                .append("@")
                .append(expectedDate == null ? "" : "expectedDate" + expectedDate)
                .append("@")
                .append(actualDate == null ? "" : "actualDate" + actualDate)
                .append("%");
        return stringBuilder.toString();
    }

    void setProjectName(String name) {this.projectName = name;}
    void setProjectManager(String manager){this.projectManager = manager;}
    void setProjectDescription(String description){this.projectDescription = description;}
    void setProjectTeamMemberNames(String projectTeamMemberNames){this.projectTeamMemberNames = projectTeamMemberNames;}
    void setProjectRisk(String risk){this.projectRisk = risk;}
    void setProjectCurrentStatus(String projectCurrentStatus){this.projectCurrentStatus = projectCurrentStatus;}
    void setProjectRequirementHours(String hours){this.projectRequirementHours = hours;}
    void setProjectDesignHours(String hours){this.projectDesignHours = hours;}
    void setProjectCodingHours(String hours){this.projectCodingHours = hours;}
    void setProjectTestingHours(String hours){this.projectTestingHours = hours;}
    void setProjectManagementHours(String hours){this.projectManagementHours = hours;}
    void setStartDate(String startDate){this.startDate = startDate;}
    void setExpectedDate(String expectedDate){this.expectedDate = expectedDate;}
    void setActualDate(String actualDate){this.actualDate = actualDate;}

    public String getProjectName() {return projectName;}
    public String getProjectManager(){return projectManager;}
    public String getProjectDescription(){return projectDescription;}
    public String getProjectTeamMemberNames(){return projectTeamMemberNames;}
    public String getProjectRisk(){return projectRisk;}
    public String getProjectCurrentStatus(){return projectCurrentStatus;}
    public String getProjectRequirementHours(){return projectRequirementHours;}
    public String getProjectDesignHours(){return projectDesignHours;}
    public String getProjectCodingHours(){return projectCodingHours;}
    public String getProjectTestingHours(){return projectCodingHours;}
    public String getProjectManagementHours(){return projectManagementHours;}
    public String getStartDate(){return startDate;}
    public String getExpectedDate(){return expectedDate;}
    public String getActualDate(){return actualDate;}

}
