package bookingsystem.fillagring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import bookingsystem.core.User;
import bookingsystem.fillagring.FilesHandle;

public class FilesHandleTest {
    private String path;
    FilesHandle filehandler = new FilesHandle();

    @Test
    public void testreadFromFile()
    {
        
        this.path = "./src/test/resources/bookingsystem/fillagring/";
        this.filehandler.setPath(this.path);

        List<String> users = new ArrayList<>(Arrays.asList("Magnus;Holta;12345678","Lars Skifjeld;Skien;hallo.du@tulla.bare"));
        filehandler.writeToFile("test.txt", users, false);
        assertEquals(users, filehandler.readFromFile("test.txt"));
    }
}