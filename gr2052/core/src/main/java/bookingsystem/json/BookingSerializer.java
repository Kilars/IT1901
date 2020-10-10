package bookingsystem.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import bookingsystem.core.Booking;
import bookingsystem.core.User;

class BookingSerializer extends JsonSerializer<Booking> {
    /*
     * 
     * { "firstName" : "...", "surname" : "...", "email" : "...", "phone" : "...",
     * "password" : "..." }
     */

    @Override
    public void serialize(Booking booking, JsonGenerator jGen, SerializerProvider serializerProvider) throws IOException {
        jGen.writeStartObject();
        jGen.writeObjectField("treatment", booking.getTreatment());
        jGen.writeObjectField("hairDresser", booking.getHairdresser());
        jGen.writeEndObject();
    }
}