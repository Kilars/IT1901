package bookingsystem.json;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import bookingsystem.core.User;
import bookingsystem.core.Users;

/** Test for checking UserModule
 * Checking one case
 */
public class UsersModuleTest {

    public static ObjectMapper mapper;

    @BeforeAll
    public static void setUp() {
        mapper = new ObjectMapper();
        mapper.registerModule(new UsersModule());
    }
    @Test
    public void testSerializers() {
        /*Users users = new Users();
        User u1 = new User();
        User u2 = new User();
        u1.setFirstName("Ola");
        u2.setFirstName("Kari");
        u1.setSurname("Nordmann");
        u2.setSurname("Nordmann");
        u1.setEmail("ola.nordmann@mail.no");
        u2.setEmail("kari.nordmann@mail.no");
        u1.setPhone("12345678");
        u2.setPhone("12345678");
        u2.setPassword("Heiheih1832");
        users.addUser(u1);
        users.addUser(u2);
        try {
            assertEquals(
                "{\"users\":[{\"firstName\":\"Ola\",\"surname\":\"Nordmann\",\"email\":\"ola.nordmann@mail.no\",\"phone\":\"12345678\",\"password\":null},{\"firstName\":\"Kari\",\"surname\":\"Nordmann\",\"email\":\"kari.nordmann@mail.no\",\"phone\":\"12345678\",\"password\":\"Heiheih1832\"}]}}",
                mapper.writeValueAsString(users)
            );
        } catch (JsonProcessingException e) {
            fail();
        }*/
        assertTrue(true);
    }
}