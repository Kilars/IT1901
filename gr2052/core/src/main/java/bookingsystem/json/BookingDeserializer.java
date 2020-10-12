package bookingsystem.json;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import bookingsystem.core.Booking;
import bookingsystem.core.HairDresser;
import bookingsystem.core.Treatment;


class BookingDeserializer extends JsonDeserializer<Booking> {

    private HairDresserDeserializer hairDresserDeserializer = new HairDresserDeserializer();
    private TreatmentDeserializer treatmenDeserializer = new TreatmentDeserializer();

    /**
     * Used in deserialize, takes in a JsonParser and calls on deserialize
     * @param JsonParser
     * @param DeserializationContext
     */
    @Override
    public Booking deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final JsonNode node = p.getCodec().readTree(p);
        return deserialize(node);
    }

    /**
     * Takes in a JsonNode, converts it and returns a booking object
     * Returns null if JsonNode is not an instance of booking
     * @param JsonNode
     * @return booking
     */
    Booking deserialize(JsonNode node) {
        if (node instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode) node;
            Booking booking = new Booking();

            JsonNode hairDresserNode = objectNode.get("hairDresser");
            if (hairDresserNode instanceof ObjectNode) {
                HairDresser hairDresser = hairDresserDeserializer.deserialize(hairDresserNode);
                booking.setHairdresser(hairDresser);
            }

            JsonNode treatmentNode = objectNode.get("treatment");
            if (treatmentNode instanceof ObjectNode) {
                Treatment treatment = treatmenDeserializer.deserialize(treatmentNode);
                booking.setTreatment(treatment);
            }
        
            JsonNode dateNode = objectNode.get("date");
            if (dateNode instanceof TextNode && !dateNode.asText().equals("")) {
                booking.setDate(LocalDate.parse(dateNode.asText()));
            }

            JsonNode timeNode = objectNode.get("time");
            if (timeNode instanceof TextNode) {
                booking.setTime(timeNode.asText());
            }

            return booking;
        } 
        return null;
    }
}
