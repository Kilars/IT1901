package bookingsystem.core;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * This class tests the User class
 */

public class UserTest {

    /**
     * Tests the setPhone and getPhone methods
     * Tests that setSurname cant take numbers
     * Tests the setEmail and getEmail methods
     */
    @Test
    public void testUser() {
        User user = new User();
        user.setPhone("12345678");
        assertEquals("12345678", user.getPhone());

        // Checks for illegalargumentexception
        try {
            user.setSurname("lars34");
            fail();
        } catch (IllegalArgumentException e) {

        }
        user.setEmail("larsski@gmail.com");
        assertEquals("larsski@gmail.com", user.getEmail());
    }

}
