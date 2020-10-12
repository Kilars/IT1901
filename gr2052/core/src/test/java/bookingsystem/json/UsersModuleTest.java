package bookingsystem.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

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
    }

    private final static String jsonSample = "{\"users\":[{\"firstName\":\"Ola\",\"surname\":\"Nordmann\",\"email\":\"ola.nordmann@mail.no\",\"phone\":\"12345678\",\"password\":\"Heiheih1832\"},{\"firstName\":\"Kari\",\"surname\":\"Nordmann\",\"email\":\"kari.nordmann@mail.no\",\"phone\":\"12345678\",\"password\":\"Heiheih1832\"}]}";

    @Test
    public void testSerializers() {
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

        try {
            assertEquals(
                jsonSample,
                mapper.writeValueAsString(users)
            );
        } catch (JsonProcessingException e) {
            fail();
        }
    }
}