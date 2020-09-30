package bookingsystem.fillagring;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is for file operations. 
 * Inputs and outputs are strings.
 */

public class FilesHandle {

    /**
     * Relative path to where files will be located.
     */
    private String path = ""; // TODO: Create path, e.g. ./gr2052/src/main/resources/bookingsystem/fillagring/
    
    /**
     * Empty constructor to make a new instance of FilesHandle
     */
    public FilesHandle() {

    }
    
    /**
     * Writes string to file. If the file already exists, a new file will be created.
     * Each string in the list from the parameter is saved on a uniqe new line.
     * @param fileName  specifies the name of the file that is to be saved
     * @param users     is a list with strings containing the information that is to be saved
     * @param append    specifies wether we want to append to the file or overwrite the file
     */
    public void writeToFile(String fileName, List<String> users, boolean append) {
        // Check if file is empty. If not, append content
        try {
            FileWriter wr = new FileWriter(this.path + fileName, append); // Last parameter 'true' is wether to append or overwrite
            BufferedWriter br = new BufferedWriter(wr);
            for (String user : users) {
                br.write(user);
                br.newLine();
            }
            br.close();
            wr.close();
        } catch (IOException e) {
            System.err.println("Couldn't write to file");
        }
    }

    /**
     * This method reads from file and returns the content as a List<String>.
     * @param fileName  specifies which file to read from
     * @return          List<String>-object where each element in the list is a line in the file.
     */
    public List<String> readFromFile(String fileName) {
        try {
            File f = new File(this.path + fileName);
            Scanner sc = new Scanner(f);
            List<String> users = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (!line.equals("")) {
                    users.add(line);
                }
            }
            sc.close();
            return users;

        } catch (IOException e) {
            System.err.println("Couldn't read from file");
            return null;
        }
    }

    /**
     * Method deletes user by userId, which is specified to be equal to the email adress.
     * If the line is formatted correctly, the email will be at index 2.
     * @param fileName  specifies the file name
     * @param userId    email-adress of the user that is to be deleted
     */
    public void deleteUserById(String fileName, String userId) {
        try {
            File f = new File(this.path + fileName);
            Scanner sc = new Scanner(f);
            FileWriter fr = new FileWriter(f, false);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
                if (line.split(";")[2].equals(userId)) {
                    fr.write(""); // Removes line 
                } else {
                    fr.write(line + "\n");
                }
            }
            sc.close();
            fr.close();

        } catch (IOException e) {
            System.err.println("Couldn't read from file");
        }
    }

    /**
     * Deletes file by fileName
     * @param fileName  specifies the file name of the file that is to be deleted
     */
    public void deleteFile(String fileName) {
        File f = new File(this.path + fileName);
        if (f.delete()) {
            System.out.println("File '" + fileName + "' was deleted successfully");
        } else {
            System.out.println("File wasn't deleted");
        }
    }

    /**
     * Sets the path of the object
     * @param path  specifies relative or absolute path
     */
    public void setPath(String path){
        this.path=path;
    }

    /**
     * Returns the path of the object
     * @return  current path of the object
     */
    public String getPath(){
       return this.path;
    }
}