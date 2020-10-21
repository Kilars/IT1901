package bookingsystem.json;

import com.fasterxml.jackson.core.util.VersionUtil;
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
}