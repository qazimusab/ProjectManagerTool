package main;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Qazi Ahmed on 11/10/15.
 */
public class DatabaseHelper {

    private ArrayList<SoftwareProject> allSoftwareProjects;

    public SoftwareProject getSoftwareProject(String softwareProjectName) throws IOException {
        File database = new File("database.txt");
        if(!database.exists()) {
            return null;
        }
        initializeProjectsList();
        for(SoftwareProject softwareProject: allSoftwareProjects){
            if(softwareProject.projectName.equals(softwareProjectName)){
                return softwareProject;
            }
        }
        return null;
    }

    public int getIndexOfProject(String projectName){
        for(int i = 0; i < allSoftwareProjects.size(); i++){
            if(projectName.equals(allSoftwareProjects.get(i).projectName)){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<SoftwareProject> getAllProjects() throws IOException {
        File database = new File("database.txt");
        if(!database.exists()) {
            return new ArrayList<>();
        }
        initializeProjectsList();
        return allSoftwareProjects;
    }

    public void saveOrUpdateSoftwareProject(SoftwareProject softwareProject) throws IOException {
        initializeProjectsList();
        if(getIndexOfProject(softwareProject.projectName) != -1) {
            int indexOfCounterPart = getIndexOfProject(softwareProject.projectName);
            allSoftwareProjects.remove(indexOfCounterPart);
            allSoftwareProjects.add(indexOfCounterPart, softwareProject);
        }
        else {
            allSoftwareProjects.add(softwareProject);
        }
        writeArraylistToDatabase();
    }

    public void initializeProjectsList() throws IOException {
        allSoftwareProjects = new ArrayList<>();
        String textInDb = readFile("database.txt");
        String [] allProjects = textInDb.split("%");
        for (String project : allProjects) {
            String[] projectDetails = project.split("@");
            SoftwareProject softwareProject = null;
            if (projectDetails.length > 1) {
                softwareProject = new SoftwareProject(projectDetails[0], projectDetails[1]);
                for (int j = 2; j < projectDetails.length; j++) {
                    if (projectDetails[j].contains("projectDescription")) {
                        softwareProject.setProjectDescription(projectDetails[j].substring(18));
                    }
                    if (projectDetails[j].contains("projectTeamMemberNames")) {
                        softwareProject.setProjectTeamMemberNames(projectDetails[j].substring(22));
                    }
                    if (projectDetails[j].contains("projectRisk")) {
                        softwareProject.setProjectRisk(projectDetails[j].substring(11));
                    }
                    if (projectDetails[j].contains("projectRequirements")) {
                        softwareProject.setProjectRequirements(projectDetails[j].substring(19));
                    }
                    if (projectDetails[j].contains("projectCurrentStatus")) {
                        softwareProject.setProjectCurrentStatus(projectDetails[j].substring(20));
                    }
                    if (projectDetails[j].contains("projectRequirementHours")) {
                        softwareProject.setProjectRequirementHours(projectDetails[j].substring(23));
                    }
                    if (projectDetails[j].contains("projectDesignHours")) {
                        softwareProject.setProjectDesignHours(projectDetails[j].substring(18));
                    }
                    if (projectDetails[j].contains("projectCodingHours")) {
                        softwareProject.setProjectCodingHours(projectDetails[j].substring(18));
                    }
                    if (projectDetails[j].contains("projectTestingHours")) {
                        softwareProject.setProjectTestingHours(projectDetails[j].substring(19));
                    }
                    if (projectDetails[j].contains("projectManagementHours")) {
                        softwareProject.setProjectManagementHours(projectDetails[j].substring(22));
                    }
                    if (projectDetails[j].contains("startDate")) {
                        softwareProject.setStartDate(projectDetails[j].substring(9));
                    }
                    if (projectDetails[j].contains("expectedDate")) {
                        softwareProject.setExpectedDate(projectDetails[j].substring(12));
                    }
                    if (projectDetails[j].contains("actualDate")) {
                        softwareProject.setActualDate(projectDetails[j].substring(10));
                    }
                }
            }
            if (softwareProject != null)
                allSoftwareProjects.add(softwareProject);
        }
    }

    private String readFile(String filename) throws IOException {
        String content = null;
        File file = new File(filename); //for ex foo.txt
        if(file.exists()) {
            FileReader reader = null;
            try {
                reader = new FileReader(file);
                char[] chars = new char[(int) file.length()];
                reader.read(chars);
                content = new String(chars);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
            return content;
        }
        else {
            return "";
        }
    }

    public void deleteProject(String projectName) throws IOException {
        initializeProjectsList();
        allSoftwareProjects.remove(getIndexOfProject(projectName));
        writeArraylistToDatabase();
    }

    private void writeArraylistToDatabase() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("database.txt", "UTF-8");
        for(SoftwareProject project: allSoftwareProjects){
            writer.print(project.toString());
        }
        writer.close();
    }
}
