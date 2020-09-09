package bookingsystem.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;

public class SaveToFile {

    private String path = "./gr2052/src/main/java/bookingsystem/core/";
    public SaveToFile() {

    }
    
    public void write() {
        try {
            FileWriter wr = new FileWriter(this.path + "testfile.txt", true);
            wr.write("Hei");
            wr.close();
        } catch (IOException e) {
            System.err.println("Couldn't write to file");
        }
    }

    public static void main(String[] args) {
        SaveToFile file = new SaveToFile();
        file.write();

    }
}