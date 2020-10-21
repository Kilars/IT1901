package bookingsystem.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import bookingsystem.core.Treatment;

class TreatmentSerializer extends JsonSerializer<Treatment> {
    /*
     * 
     * { "firstName" : "...", "surname" : "...", "email" : "...", "phone" : "...",
     * "password" : "..." }
     */

     /**
      * Writes a Json string to the JsonGenerator jGen
      *@param Treatment
      *@param JsonGenerator
      *@param SerializerProvider
      */
    @Override
    public void serialize(Treatment treatment, JsonGenerator jGen, SerializerProvider serializerProvider) throws IOException {
        jGen.writeStartObject();
        jGen.writeStringField("treatment", treatment.getTreatment());
        jGen.writeNumberField("price", treatment.getPrice());
        jGen.writeEndObject();
    }
}