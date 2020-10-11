package bookingsystem.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import bookingsystem.core.Booking;
import bookingsystem.core.Treatment;


class BookingDeserializer extends JsonDeserializer<Booking> {

    @Override
    public Booking deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final JsonNode node = p.getCodec().readTree(p);
        return deserialize(node);
    }

    Booking deserialize(JsonNode node) {
        /* if (node instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode) node;
            Booking booking = new Booking();
            JsonNode treatmentNode = objectNode.get("treatment");
            if (treatmentNode instanceof TextNode) {
                booking.setTreatment(treatmentNode.asText());
            }
            JsonNode priceNode = objectNode.get("price");
            if (priceNode instanceof TextNode) {
                booking.setPrice(priceNode.asDouble());
            }
            return booking;
        } */
        return null;
    }
}
