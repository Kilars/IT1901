package bookingsystem.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import bookingsystem.core.Booking;
import bookingsystem.core.HairDresser;
import bookingsystem.core.Treatment;
import bookingsystem.core.User;
import bookingsystem.core.Users;

/*
Format
{"users" : [
    (User) {
        "firstName" : "Ola",
        "surname" : "Nordmann",
        "email" : "ola.nordmann@mail.com",
        "phone" : "12345678",
        "password" : "passord01",
        "bookings" : [
            (Booking) {
                "treatment" : (Treatment) {
                    "treatment" : "herreklipp"
                    "price" : (Double) "100"
                },
                "hairDresser" : (HairDresser) {
                    "name" : "Kari Nordmann"
                },
                "date" : (String) "...",
                "time" : "10:30"
            }
        ]
    }
]} 
 */

/** Test for checking UserModule
 * Checking one case
 */
public class UsersModuleTest {

    private static ObjectMapper mapper;
    private final static String jsonSample = "{\"users\":[{\"firstName\":\"Ola\",\"surname\":\"Nordmann\",\"email\":\"ola.nordmann@mail.no\",\"phone\":\"12345678\",\"password\":\"Heiheih1832\",\"bookings\":[{\"hairDresser\":{\"name\":\"Kari\"},\"treatment\":{\"treatment\":\"Herreklipp\",\"price\":199.0},\"date\":\"2020-11-12\",\"time\":\"10:30\"}]},{\"firstName\":\"Kari\",\"surname\":\"Nordmann\",\"email\":\"kari.nordmann@mail.no\",\"phone\":\"12345678\",\"password\":\"Heiheih1832\",\"bookings\":[{\"hairDresser\":{\"name\":\"Ola\"},\"treatment\":{\"treatment\":\"Dameklipp\",\"price\":299.0},\"date\":\"2020-11-12\",\"time\":\"10:30\"}]}]}";
    private Users users;
    private User user1, user2;
    private Booking booking1, booking2;
    private HairDresser hairdresser1, hairdresser2;
    private Treatment treatment1, treatment2;
    private LocalDate date;
    private String time;


    @BeforeAll
    public static void init() {
        mapper = new ObjectMapper();
        mapper.registerModule(new UsersModule());
    }

    @BeforeEach
    public void setUp() {
        users = new Users();
        user1 = new User();
        user2 = new User();
        booking1 = new Booking();
        booking2 = new Booking();
        hairdresser1 = new HairDresser("Kari");
        hairdresser2 = new HairDresser("Ola");
        treatment1 = new Treatment("Herreklipp", 199);
        treatment2 = new Treatment("Dameklipp", 299);
        date = LocalDate.of(2020, 11, 12);
        time = "10:30";
        user1.setFirstName("Ola");
        user1.setSurname("Nordmann");
        user1.setEmail("ola.nordmann@mail.no");
        user1.setPhone("12345678");
        user1.setPassword("Heiheih1832");
    
        user2.setFirstName("Kari");
        user2.setSurname("Nordmann");
        user2.setEmail("kari.nordmann@mail.no");
        user2.setPhone("12345678");
        user2.setPassword("Heiheih1832");
    
        booking1 = new Booking(user1, hairdresser1, treatment1, date, time);
        booking2 = new Booking(user2, hairdresser2, treatment2, date, time);
    
        users.addUsers(user1, user2);
    }


    @Test
    public void testSerializers() {

        try {
            System.out.println(mapper.writeValueAsString(users));
            assertEquals(
                jsonSample,
                mapper.writeValueAsString(users)
            );
        } catch (JsonProcessingException e) {
            fail();
        }
    }

    private void checkUser(User user, String firstName, String surname, String email, String phone, String password) {
        assertEquals(firstName, user.getFirstName());
        assertEquals(surname, user.getSurname());
        assertEquals(email, user.getEmail());
        assertEquals(phone, user.getPhone());
        assertEquals(password, user.getPassword());
    }

    private void checkUser(User user1, User user2) {
        assertEquals(user1.getFirstName(), user2.getFirstName());
        assertEquals(user1.getSurname(), user2.getSurname());
        assertEquals(user1.getEmail(), user2.getEmail());
        assertEquals(user1.getPhone(), user2.getPhone());
        assertEquals(user1.getPassword(), user2.getPassword());
    }

    @Test
    public void testDeserializers() {
        try {
            Users users = mapper.readValue(jsonSample, Users.class);
            Iterator<User> it = users.iterator();
            assertTrue(it.hasNext());

            checkUser(it.next(), "Ola", "Nordmann", "ola.nordmann@mail.no", "12345678", "Heiheih1832");
            assertTrue(it.hasNext());
            checkUser(it.next(), "Kari", "Nordmann", "kari.nordmann@mail.no", "12345678", "Heiheih1832");
            assertFalse(it.hasNext());
        } catch (JsonProcessingException e) {
            fail();
        }
    }

    @Test
    public void testSerializersDeserializers() {
        try {
            String json = mapper.writeValueAsString(users);
            Users users_red = mapper.readValue(json, Users.class);
            Iterator<User> it = users_red.iterator();
            assertTrue(it.hasNext());
            checkUser(it.next(), user1);
            assertTrue(it.hasNext());
            checkUser(it.next(), user2);
            assertFalse(it.hasNext());
        } catch (JsonProcessingException e) {
            fail();
        }
    }


    
}