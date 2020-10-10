package bookingsystem.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import bookingsystem.core.Booking;
import bookingsystem.core.User;

class UserSerializer extends JsonSerializer<User> {
    /*
     * 
     * { "firstName" : "...", "surname" : "...", "email" : "...", "phone" : "...",
     * "password" : "..." }
     */

    @Override
    public void serialize(User user, JsonGenerator jGen, SerializerProvider serializerProvider) throws IOException {
        jGen.writeStartObject();
        jGen.writeStringField("firstName", user.getFirstName());
        jGen.writeStringField("surname", user.getSurname());
        jGen.writeStringField("email", user.getEmail());
        jGen.writeStringField("phone", user.getPhone());
        jGen.writeStringField("password", user.getPassword());
        jGen.writeArrayFieldStart("bookings");
            for (Booking booking : user.getBookings()) {
                jGen.writeObject(booking);
            }
        jGen.writeEndArray();
        jGen.writeEndObject();
    }
}