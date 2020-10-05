package bookingsystem.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import bookingsystem.core.User;
import bookingsystem.core.Users;

public class UserDeserializer extends JsonDeserializer<User> {

    @Override
    public User deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final JsonNode node = p.getCodec().readTree(p);
        return deserialize(node);
    }

    private User deserialize(JsonNode node) {
        final String firstName = node.get("firstName").asText();
        final String surname = node.get("surname").asText();
        final String email = node.get("email").asText();
        final String phone = node.get("phone").asText();
        final String password = node.get("password").asText();
        User user = new User(firstName, surname, email, phone, password);
        return user;
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