package bookingsystem.json;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import bookingsystem.core.User;
import bookingsystem.core.Users;

class UsersDeserializer extends JsonDeserializer<Users> {

    /**
    {"users" : [
        {
            "firstName" : "Ola",
            "surname":"Nordmann",
            "email":"ola.nordmann@mail.no",
            "phone":"12345678",
            "password":"Heiheih1832"
        },
        {
            "firstName":"Kari",
            "surname":"Nordmann",
            "email":"kari.nordmann@mail.no",
            "phone":"12345678",
            "password":"Heiheih1832"
        }
        ]
    }
    */
    
    private UserDeserializer userDeserializer = new UserDeserializer();

    /**
     * Takes in a JsonParser and calls on deserialize
     * @param JsonParser
     * @param DeserializationContext
     */
    @Override
    public Users deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final JsonNode node = p.getCodec().readTree(p);
        return deserialize((JsonNode) node);
    }

    /**
     * Takes in a JsonNode, converts it and returns a user object
     * Returns null if JsonNode is not an instance of User
     * @param JsonNode
     * @return User
     */
    private Users deserialize(JsonNode node) {
        if (node instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode) node;
            Users users = new Users();
            JsonNode usersNode = objectNode.get("users");
            if (usersNode instanceof ArrayNode) {
                for (JsonNode userNode : ((ArrayNode) usersNode)) {
                    User user = userDeserializer.deserialize(userNode);
                    if (user != null) {
                        users.addUser(user);
                    }
                }
            }
            return users;
        }
        return null;
    }
}