package main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Qazi Ahmed on 11/10/15.
 */
public class DatabaseHelper {

    ArrayList<SoftwareProject> allSoftwareProjects;

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

    public ArrayList<SoftwareProject> getAllProjects() throws IOException {
        File database = new File("database.txt");
        if(!database.exists()) {
            return new ArrayList<>();
        }
        initializeProjectsList();
        return allSoftwareProjects;
    }

    public void saveSoftwareProject(SoftwareProject softwareProject) throws IOException {
        String file = readFile("database.txt");
        PrintWriter writer = new PrintWriter("database.txt", "UTF-8");
        writer.print(file);
        writer.print(softwareProject.toString());
        writer.close();
    }

    public void initializeProjectsList() throws IOException {
        allSoftwareProjects = new ArrayList<>();
        String textInDb = readFile("database.txt");
        String [] allProjects = textInDb.split(";");
        for (String project : allProjects) {
            String[] projectDetails = project.split(",");
            SoftwareProject softwareProject = null;
            if (projectDetails.length > 1) {
                softwareProject = new SoftwareProject(projectDetails[0], projectDetails[1]);
                for (int j = 2; j < projectDetails.length; j++) {
                    if (projectDetails[j].contains("hoursWorked")) {
                        softwareProject.setHoursWorked(projectDetails[j].substring(11));
                    }
                    if (projectDetails[j].contains("numberOfTeamMembers")) {
                        softwareProject.setNumberOfTeamMembers(projectDetails[j].substring(19));
                    }
                    if (projectDetails[j].contains("currentStatus")) {
                        softwareProject.setCurrentStatus(projectDetails[j].substring(13));
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

    public String readFile(String filename) throws IOException {
        String content = null;
        File file = new File(filename); //for ex foo.txt
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
            if(reader !=null){reader.close();}
        }
        return content;
    }

}
