package bookingsystem.fillagring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * This class tests the FileHandles class 
 * */

public class FilesHandleTest {
    /**
     * path Relative path to where files will be located.
     * filehandler is an instance of the FilesHandle class.
     */
    private String path;
    FilesHandle filehandler = new FilesHandle();

    /**
     * Tests that fileshandle reads and writes til file
     * Registers a list of users and writes them to file
     * Then reads from the same file and checks that the content is the same
     */
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