package bookingsystem.core;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import bookingsystem.core.User;
import bookingsystem.fillagring.FilesHandle;

public class AppTest 
{

 
    @Test
    public void testUser()
    {
        User user = new User();
        user.setPhone("12345678");
        assertEquals("12345678", user.getPhone());

        //Checks for illegalargumentexception
        try {
            user.setSurname("lars34");
            fail();
        } catch (IllegalArgumentException e) {
            
        }
        user.setEmail("larsski@gmail.com");
        assertEquals("larsski@gmail.com", user.getEmail());
    }

}
