package bookingsystem.fillagring;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FilesHandle {

    private String path = "/gr2052/src/main/resources/bookingsystem/fillagring/";
    public FilesHandle() {

    }
    
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

    public List<String> readFromFile(String fileName) {
        try {
            File f = new File(this.path + fileName);
            Scanner sc = new Scanner(f);
            List<String> users = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line != "") {
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

    // Started implementing solution to delete specific line
    public void deleteLine(String fileName, int lineNum) {
        try {
            File f = new File(this.path + fileName);
            Scanner sc = new Scanner(f);
            FileWriter fr = new FileWriter(f, false);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
                if (line.split(";")[0] == Integer.toString(lineNum)) {
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

    public void deleteFile(String fileName) {
        File f = new File(this.path + fileName);
        if (f.delete()) {
            System.out.println("File '" + fileName + "' was deleted successfully");
        } else {
            System.out.println("File wasn't deleted");
        }
    }
    public static void main(String[] args) {
        FilesHandle file = new FilesHandle();
    //    file.writeToFile("testfile.txt");
    //    file.readFromFile("testfile.txt");
        List<String> users = new ArrayList<>(Arrays.asList("Magnus;Holta;12345678","Lars Skifjeld;Skien;hallo.du@tulla.bare"));
        
        file.writeToFile("test.txt", users, false);
        file.readFromFile("test.txt").forEach(user -> System.out.println(user));
        System.out.println("Orig:\t" + users +"\n"+file.readFromFile("test.txt"));
        System.out.println("Res:\t" + users.equals(file.readFromFile("test.txt")));
    }
}