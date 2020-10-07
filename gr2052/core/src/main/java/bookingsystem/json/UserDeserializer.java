package bookingsystem.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import bookingsystem.core.User;
import bookingsystem.core.Users;

class UserDeserializer extends JsonDeserializer<User> {

    @Override
    public User deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final JsonNode node = p.getCodec().readTree(p);
        return deserialize(node);
    }

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
            return user;
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
            String json = mapper.writeValueAsString(u2);
            mapper.readValue(json, User.class);

        } catch (Exception e) {
            System.err.println("UsersModule didn't work");
            e.printStackTrace();
        }
    }
}