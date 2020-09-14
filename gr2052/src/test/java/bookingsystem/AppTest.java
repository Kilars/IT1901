package bookingsystem;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import bookingsystem.core.User;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testreadFromFile()
    {
        //readFromFile returns void,to test we need them to return the values not println them
    }

    @Test
    public void testUser()
    {
        User user = new User();
        user.setPhone("12345678");
        assertEquals("12345678", user.getPhone());
        //Throw exception instead of print or both?
/*         try {
            user.setSurname("lars34");
            fail();
        } catch (Exception e) {
            
        } */
        user.setEmail("larsski@gmail.com");
        assertEquals("larsski@gmail.com", user.getEmail());
    }

}
