package bookingsystem.core;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * This class tests the Users class
 */

public class UsersTest {

    @Test
    public void testUsers() {
        String fileName = "users.txt";
        List<User> usersList = new ArrayList<>();

        Users users = new Users();
        User ingrid = new User("Ingrid","Hagen", "ingrid@hotmail.com","97103994", "Passord123");
        User julie = new User ("Julie", "Kongsten", "Julie@gmail.com","12345678", "Passord123");
        
        //Checks if user is added to usersList
        users.addUser(ingrid);
        users.addUser(julie);
        usersList.contains(ingrid);

        //Checks if getUser returns the correct object using email.
        assertEquals(users.getUser(ingrid.getEmail()), ingrid);

        //Checks if checkIfUserExists works
        users.checkIfUserExists(ingrid.getEmail());
        assertFalse(users.checkIfUserExists("Karen@gmail.com"));
        
        //Checks if removeUser removes a user.
        users.removeUser(julie);
        assertFalse(usersList.contains(julie));

       
        users.logIn("ingrid@hotmail.com", "Passord123");
        boolean thrown = false;
        try {
            users.logIn("ingrid@hotmail.com", "passord123");
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}