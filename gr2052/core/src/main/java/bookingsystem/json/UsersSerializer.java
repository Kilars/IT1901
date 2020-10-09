package bookingsystem.json;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import bookingsystem.core.User;
import bookingsystem.core.Users;

class UsersSerializer extends JsonSerializer<Users> {
    /*
     * 
     * format: { "users" : [ ... ] }
     */

    @Override
    public void serialize(Users users, JsonGenerator jGen, SerializerProvider serializerProvider) throws IOException {
        jGen.writeStartObject();
        jGen.writeArrayFieldStart("users");
        for (User user : users) {
            jGen.writeObject(user);
        }
        jGen.writeEndArray();
        jGen.writeEndObject();
    }
}