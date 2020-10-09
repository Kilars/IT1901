package bookingsystem.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import bookingsystem.fillagring.FilesHandle;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import bookingsystem.core.User;
import bookingsystem.core.Users;
import bookingsystem.json.UsersPersistence;


/**
 * Class to handle the user database. The users are saved in an ArrayList as
 * User-objects. The class has methods to delete, save, add and get users.
 */

public class Users implements Iterable<User> {
    private List<User> users = new ArrayList<>();
    private FilesHandle fileHandler = new FilesHandle();
    private String fileName = "users.txt";
    private String jsonFile = "users.json";

    /**
     * Constructor to initialize the instance. Automaticly loads users from file.
     * File name is stored as a private variable and is used to load from file.
     */
    public Users() {
      //  loadUsersFromFile(this.fileName);
    }

    public Users(User... users) {
        addUsers(users);;
    }

    /**
     * Loads users from file. Makes a stream if readFromFile() does not return null.
     * Maps from strings to User object. Using stream with map() and collect().
     * 
     * @param fileName specifies the file to load from
     */
    public void loadUsersFromFile(String fileName) {
        this.users = (fileHandler.readFromFile(fileName) == null) ? new ArrayList<>()
                : fileHandler.readFromFile(fileName).stream()
                    .map(user -> new User(user))
                    .collect(Collectors.toList());
    }

    /**
     * Saves users to file. Utilizing stream with map() and collect() to get a
     * String object.
     * 
     * @param fileName specifies the file to save to
     */
    public void saveUsersToFile(String fileName) {
        fileHandler.writeToFile(fileName, users.stream().map(user -> user.toString()).collect(Collectors.toList()),
                false);
    }

    /**
     * Adds user to list and saves to file
     * 
     * @param user User to be added, of type User
     */
    public void addUser(User user) {
        /*if (checkIfUserExists(user.getEmail()))
            throw new IllegalArgumentException("Emailen er allerede registrert"); // TODO: Implement*/
        this.users.add(user);
       // saveUsersToFile(this.fileName);
    }

    public void addUsers(User... users) {
        /*if (checkIfUserExists(user.getEmail()))
            throw new IllegalArgumentException("Emailen er allerede registrert"); // TODO: Implement*/
        for (User u : users) {
            User user;
            if (u instanceof User) {
                user = (User) u;
            } else {
                user = new User();
                user.setFirstName(u.getFirstName());
                user.setSurname(u.getSurname());
                user.setEmail(u.getEmail());
                user.setPhone(u.getPhone());
                user.setPassword(u.getPassword());
            }
            this.users.add(user);
        }
       // saveUsersToFile(this.fileName);
    }

    /**
     * Searches for a user with email. If it exists, return the user object. Else
     * return null
     * 
     * @param email The email of the user to get
     * @return returns the user as a User-object or null
     */
    public User getUser(String email) {
        for (User user : this.users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Uses getUser to return is the user exists.
     * 
     * @param email email of the user to check
     * @return if the user exists, true or false
     */
    public boolean checkIfUserExists(String email) {
        return (getUser(email) == null) ? false : true;
    }

    /**
     * Removes user with email if present.
     */
    public void removeUser(User user) {
        this.users.remove(user);
    }

    /**
     * Returns this object as an iterator. Enables use of 'for (user : users)'
     */
    @Override
    public Iterator<User> iterator() {
        return this.users.iterator();
    }
    

    public Boolean logIn(String email, String password) {
        Boolean logInSuccess = false;
        if (checkIfUserExists(email)) {
            if(getUser(email).getPassword().equals(password)) {
                logInSuccess = true;
            }
            else {
                throw new IllegalArgumentException("Feil passord!");
            }
        }
        else {
            throw new IllegalArgumentException("Brukeren eksisterer ikke");
        }
        return logInSuccess;
    }
    

    @Override
    public String toString() {
        return "" + users.stream().map(user -> user.toString()).collect(Collectors.toList());
    }

    public Users loadJSON(String jsonFile) {
        // setter opp data
        Reader reader = null;
        URL path = getClass().getResource(jsonFile);
        System.out.println(path);
        if (path != null) {
            try {
            reader = new InputStreamReader(path.openStream(), StandardCharsets.UTF_8);
            } catch (IOException e) {
            System.err.println("Couldn't read " + jsonFile);
            }
        } else {
            System.err.println("Couldn't find " + jsonFile);
        }
        
        if (reader == null) {
            // use embedded String
            reader = new StringReader(jsonFile);
        }
        Users users = null;
        try {
            UsersPersistence usersPersistence = new UsersPersistence();
            users = usersPersistence.readUsers(reader);
        } catch (IOException e) {
            // ignore
        } finally {
            try {
                if (reader != null) {
                reader.close();
                }
            } catch (IOException e) {
                // ignore
            }
        }
        if (users == null) {
            users = new Users(
                new User("Magnus", "Holta", "magnus.holta@gmail.com", "48052730", "Hallodu123"),
                new User("Lars", "Skifjeld", "hallo.du@lars.no", "12345678", "Neineineinei123")
            );
        }
        return users;
    }

    public static void main(String[] args) {
        new Users().loadJSON("users.json").forEach(x -> System.out.println(x));
    }
}
