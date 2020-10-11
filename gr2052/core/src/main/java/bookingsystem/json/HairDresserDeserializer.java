package bookingsystem.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import bookingsystem.core.HairDresser;


class HairDresserDeserializer extends JsonDeserializer<HairDresser> {

    @Override
    public HairDresser deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final JsonNode node = p.getCodec().readTree(p);
        return deserialize(node);
    }

    HairDresser deserialize(JsonNode node) {
        if (node instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode) node;
            HairDresser hairDresser = new HairDresser();
            JsonNode nameNode = objectNode.get("name");
            if (nameNode instanceof TextNode) {
                hairDresser.setName(nameNode.asText());
            }
            return hairDresser;
        }
        return null;
    }
}
