package bookingsystem.json;

import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import bookingsystem.core.Booking;
import bookingsystem.core.HairDresser;
import bookingsystem.core.Treatment;
import bookingsystem.core.User;
import bookingsystem.core.Users;

class UsersModule extends SimpleModule {

    private static final String NAME = "UsersModule";
    private static final VersionUtil VERSION_UTIL = new VersionUtil() {
    };

    public UsersModule() {
        super(NAME, VERSION_UTIL.version());
        addSerializer(HairDresser.class, new HairDresserSerializer());
        addSerializer(Treatment.class, new TreatmentSerializer());
        addSerializer(Booking.class, new BookingSerializer());
        addSerializer(User.class, new UserSerializer());
        addSerializer(Users.class, new UsersSerializer());
        addDeserializer(User.class, new UserDeserializer());
        addDeserializer(Users.class, new UsersDeserializer());
    }

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new UsersModule());
        Users users = new Users();
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
            System.out.println(mapper.writeValueAsString(users));
        } catch (Exception e) {
            System.err.println("UsersModule didn't work");
            e.printStackTrace();
        }
    }
}