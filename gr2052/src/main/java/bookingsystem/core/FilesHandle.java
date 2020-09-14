package bookingsystem.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FilesHandle {

    private String path = "./gr2052/src/main/java/bookingsystem/core/";
    public FilesHandle() {

    }
    
    public void writeToFile(String fileName) {
        // Check if file is empty. If not, append content
        String content = "Hei\nJada;Hmmm\nJa" + "\n"; // Do something
        try {
            FileWriter wr = new FileWriter(this.path + fileName, true); // Last parameter 'true' is wether to append or overwrite
            wr.write(content);
            wr.close();
        } catch (IOException e) {
            System.err.println("Couldn't write to file");
        }
    }

    public void readFromFile(String fileName) {
        try {
            File f = new File(this.path + fileName);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
                // Do something
            }
            sc.close();

        } catch (IOException e) {
            System.err.println("Couldn't read from file");
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
        file.deleteFile("testfile.txt");
    }
}