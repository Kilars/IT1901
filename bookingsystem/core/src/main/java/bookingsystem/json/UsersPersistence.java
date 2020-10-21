package bookingsystem.json;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import com.fasterxml.jackson.databind.ObjectMapper;

import bookingsystem.core.Users;

/**
 * UsersPersistence
 */
public class UsersPersistence {

    private ObjectMapper mapper;

    public UsersPersistence() {
        mapper = new ObjectMapper();
        mapper.registerModule(new UsersModule());
    }

    public Users readUsers(Reader reader) throws IOException {
        return mapper.readValue(reader, Users.class);
    }

    public void writeUsers(Users users, Writer writer) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(writer, users);
    }
}