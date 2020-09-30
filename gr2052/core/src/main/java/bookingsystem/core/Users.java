package bookingsystem.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import bookingsystem.fillagring.FilesHandle;

/**
 * Class to handle the user database. The users are saved in an ArrayList as
 * User-objects. The class has methods to delete, save, add and get users.
 */
public class Users implements Iterable<User> {
    private List<User> usersList = new ArrayList<>();
    private FilesHandle fileHandler = new FilesHandle();
    private String fileName = "users.txt";

    /**
     * Constructor to initialize the instance. Automaticly loads users from file.
     * File name is stored as a private variable and is used to load from file.
     */
    public Users() {
        loadUsersFromFile(this.fileName);
    }

    /**
     * Loads users from file. Makes a stream if readFromFile() does not return null.
     * Maps from strings to User object. Using stream with map() and collect().
     * 
     * @param fileName specifies the file to load from
     */
    public void loadUsersFromFile(String fileName) {
        this.usersList = (fileHandler.readFromFile(fileName) == null) ? new ArrayList<>()
                : fileHandler.readFromFile(fileName).stream().map(user -> new User(user)).collect(Collectors.toList());
    }

    /**
     * Saves users to file. Utilizing stream with map() and collect() to get a
     * String object.
     * 
     * @param fileName specifies the file to save to
     */
    public void saveUsersToFile(String fileName) {
        fileHandler.writeToFile(fileName, usersList.stream().map(user -> user.toString()).collect(Collectors.toList()),
                false);
    }

    /**
     * Adds user to list and saves to file
     * 
     * @param user User to be added, of type User
     */
    public void addUser(User user) {
        if (checkIfUserExists(user.getEmail()))
            throw new IllegalArgumentException("Emailen er allerede registrert"); // TODO: Implement
        this.usersList.add(user);
        saveUsersToFile(this.fileName);
    }

    /**
     * Searches for a user with email. If it exists, return the user object. Else
     * return null
     * 
     * @param email The email of the user to get
     * @return returns the user as a User-object or null
     */
    private User getUser(String email) {
        for (User user : this.usersList) {
            if (user.getEmail() == email) {
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
    private boolean checkIfUserExists(String email) {
        return (getUser(email) == null) ? false : true;
    }

    /**
     * Removes user with email if present.
     */
    public void removeUser(User user) {
        this.usersList.remove(user);
    }

    @Override
    public Iterator<User> iterator() {
        return this.usersList.iterator();
    }


}