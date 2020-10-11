package bookingsystem.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import bookingsystem.core.Treatment;


class TreatmentDeserializer extends JsonDeserializer<Treatment> {

    @Override
    public Treatment deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final JsonNode node = p.getCodec().readTree(p);
        return deserialize(node);
    }

    Treatment deserialize(JsonNode node) {
        if (node instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode) node;
            Treatment treatment = new Treatment();
            JsonNode treatmentNode = objectNode.get("treatment");
            if (treatmentNode instanceof TextNode) {
                treatment.setTreatment(treatmentNode.asText());
            }
            JsonNode priceNode = objectNode.get("price");
            if (priceNode instanceof TextNode) {
                treatment.setPrice(priceNode.asDouble());
            }
            return treatment;
        }
        return null;
    }
}
