package bookingsystem.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import bookingsystem.core.Booking;

class BookingSerializer extends JsonSerializer<Booking> {
    /*
     * 
     * { "firstName" : "...", "surname" : "...", "email" : "...", "phone" : "...",
     * "password" : "..." }
     */

    @Override
    public void serialize(Booking booking, JsonGenerator jGen, SerializerProvider serializerProvider) throws IOException {
        jGen.writeStartObject();
        jGen.writeObjectField("hairDresser", booking.getHairdresser());
        jGen.writeObjectField("treatment", booking.getTreatment());
        if (booking.getDate() != null) {
            jGen.writeStringField("date", booking.getDate().toString());
        }
        jGen.writeStringField("time", booking.getTime());
        jGen.writeEndObject();
    }
}