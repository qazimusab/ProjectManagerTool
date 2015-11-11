package main;

public class SoftwareProject
{
    public String projectName;
    public String projectManager;
    public String hoursWorked;
    public String numberOfTeamMembers;
    public String currentStatus;
    public String startDate;
    public String expectedDate;
    public String actualDate;

    public SoftwareProject(String projectName, String projectManager) {
        this.projectName = projectName;
        this.projectManager = projectManager;
    }

    public SoftwareProject(String projectName, String projectManager, String numberOfTeamMembers, String currentStatus,
                           String hoursWorked, String startDate, String expectedDate, String actualDate) {
        this.projectName = projectName;
        this.projectManager = projectManager;
        this.numberOfTeamMembers = numberOfTeamMembers;
        this.currentStatus = currentStatus;
        this.hoursWorked = hoursWorked;
        this.startDate = startDate;
        this.expectedDate = expectedDate;
        this.actualDate = actualDate;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(projectName)
                .append(",")
                .append(projectManager)
                .append(",")
                .append(hoursWorked == null ? "" : "hoursWorked" + hoursWorked)
                .append(",")
                .append(numberOfTeamMembers == null ? "" : "numberOfTeamMembers" + numberOfTeamMembers)
                .append(",")
                .append(currentStatus == null ? "" : "currentStatus" + currentStatus)
                .append(",")
                .append(startDate == null ? "" : "startDate" + startDate)
                .append(",")
                .append(expectedDate == null ? "" : "expectedDate" + expectedDate)
                .append(",")
                .append(actualDate == null ? "" : "actualDate" + actualDate)
                .append(";");
        return stringBuilder.toString();
    }

    void setProjectName(String name) {this.projectName = name;}
    void setProjectManager(String manager){this.projectManager = manager;}
    void setHoursWorked(String hoursWorked){this.hoursWorked = hoursWorked;}
    void setNumberOfTeamMembers(String numberOfTeamMembers){this.numberOfTeamMembers = numberOfTeamMembers;}
    void setCurrentStatus(String currentStatus){this.currentStatus = currentStatus;}
    void setStartDate(String startDate){this.startDate = startDate;}
    void setExpectedDate(String expectedDate){this.expectedDate = expectedDate;}
    void setActualDate(String actualDate){this.actualDate = actualDate;}

    public String getProjectName() {return projectName;}
    public String getProjectManager(){return projectManager;}
    public String getHoursWorked(){return hoursWorked;}
    public String getNumberOfTeamMembers(){return numberOfTeamMembers;}
    public String getCurrentStatus(){return currentStatus;}
    public String getStartDate(){return startDate;}
    public String getExpectedDate(){return expectedDate;}
    public String getActualDate(){return actualDate;}

}
