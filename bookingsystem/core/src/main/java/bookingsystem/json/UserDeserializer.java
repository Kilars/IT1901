package bookingsystem.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import bookingsystem.core.Booking;
import bookingsystem.core.User;

class UserDeserializer extends JsonDeserializer<User> {

    private BookingDeserializer bookingDeserializer = new BookingDeserializer();

    /**
     * Used in deserialize, takes in a JsonParser and calls on deserialize
     * @param JsonParser
     * @param DeserializationContext
     */
    @Override
    public User deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final JsonNode node = p.getCodec().readTree(p);
        return deserialize(node);
    }

    /**
     * Takes in a JsonNode, converts it and returns a User object
     * Returns null if JsonNode is not an instance of User
     * @param JsonNode
     * @return User
     */
    User deserialize(JsonNode node) {
        if (node instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode) node;
            User user = new User();
            JsonNode firstNameNode = objectNode.get("firstName");
            if (firstNameNode instanceof TextNode) {
                user.setFirstName(firstNameNode.asText());
            }
            JsonNode surnameNode = objectNode.get("surname");
            if (surnameNode instanceof TextNode) {
                user.setSurname(surnameNode.asText());
            }
            JsonNode emailNode = objectNode.get("email");
            if (emailNode instanceof TextNode) {
                user.setEmail(emailNode.asText());
            }
            JsonNode phoneNode = objectNode.get("phone");
            if (phoneNode instanceof TextNode) {
                user.setPhone(phoneNode.asText());
            }
            JsonNode passwordNode = objectNode.get("password");
            if (passwordNode instanceof TextNode) {
                user.setPassword(passwordNode.asText());
            }
            JsonNode bookingsNode = objectNode.get("bookings");
            if (bookingsNode instanceof ArrayNode) {
                for (JsonNode bookingNode : ((ArrayNode) bookingsNode)) {
                    Booking booking = bookingDeserializer.deserialize(bookingNode);
                    if (user != null) {
                        booking.setCustomer(user);
                    }
                }
            }
            
            return user;
        }
        return null;
    }
}