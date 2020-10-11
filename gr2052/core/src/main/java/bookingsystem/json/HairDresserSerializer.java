package bookingsystem.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import bookingsystem.core.Booking;
import bookingsystem.core.HairDresser;
import bookingsystem.core.User;

class HairDresserSerializer extends JsonSerializer<HairDresser> {
    /*
     * 
     * { "firstName" : "...", "surname" : "...", "email" : "...", "phone" : "...",
     * "password" : "..." }
     */

    @Override
    public void serialize(HairDresser hairDresser, JsonGenerator jGen, SerializerProvider serializerProvider) throws IOException {
        jGen.writeStartObject();
        jGen.writeStringField("name", hairDresser.getName());
        jGen.writeEndObject();
    }
}