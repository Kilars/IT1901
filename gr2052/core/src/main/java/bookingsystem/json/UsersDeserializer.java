package bookingsystem.json;

import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Override
    public Users deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final JsonNode node = p.getCodec().readTree(p);
        return deserialize((JsonNode) node);
    }

    private Users deserialize(JsonNode node) {
        if (node instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode) node;
            Users users = new Users();
            JsonNode usersNode = (ArrayNode) objectNode.get("users");
            if (usersNode instanceof ArrayNode) {
                for (JsonNode userNode : ((ArrayNode) usersNode)) {
                    User user = userDeserializer.deserialize(userNode);
                    if (user != null) {
                        users.addUser(user);
                    }
                }
            }
            System.out.println(users.toString());
            return users;
        }
        return null;
    }

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        
        mapper.registerModule(new UsersModule());
        
        Users users = new Users();
        User u1 = new User();
        User u2 = new User();
        u1.setFirstName("Ola");
        u2.setFirstName("Kari");
        u1.setSurname("Nordmann");
        u2.setSurname("Nordmann");
        u1.setEmail("ola.nordmann@mail.no");
        u2.setEmail("kari.nordmann@mail.no");
        u1.setPhone("12345678");
        u2.setPhone("12345678");
        u1.setPassword("Heiheih1832");
        u2.setPassword("Heiheih1832");
        users.addUser(u1);
        users.addUser(u2);
        try {
            String json = mapper.writeValueAsString(users);
            mapper.readValue(json, Users.class);
        } catch (Exception e) {
            System.err.println("UsersModule didn't work");
            e.printStackTrace();
        }
    }
}