package bookingsystem.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;


import bookingsystem.core.User;
import bookingsystem.core.Users;
import bookingsystem.json.UsersPersistence;


/**
 * Class to handle the user database. The users are saved in an ArrayList as
 * User-objects. The class has methods to save, add and get users.
 */
public class Users implements Iterable<User> {
    private List<User> users = new ArrayList<>();
    private String jsonFile = "users.json";
    private UsersPersistence usersPersistence = new UsersPersistence();


    /**
     * Constructor to initialize the instance. Automaticly loads users from file.
     * File name is stored as a private variable and is used to load from file.
     */

    public Users() {

    }

    public Users(String jsonFile) {
        setJsonFilename(jsonFile);
        this.users = getJsonUsers();
      //  loadUsersFromFile(this.fileName);
    }

    private void setJsonFilename(String jsonFile) {
        this.jsonFile = jsonFile;
    }

    /**
     * Method to add user
     * @param user
     */
    public void addUser(User user) {
        if (checkIfUserExists(user.getEmail()) == false) {
            User user_this;
            if (user instanceof User) {
                user_this = (User) user;
            } else {
                user_this = new User();
                user_this.setFirstName(user.getFirstName());
                user_this.setSurname(user.getSurname());
                user_this.setEmail(user.getEmail());
                user_this.setPhone(user.getPhone());
                user_this.setPassword(user.getPassword());
            }
            this.users.add(user_this);
        } else {
                throw new IllegalArgumentException("Emailen er allerede registrert");
        }
    }

    /**
     * Method to add Users
     * @param users
     */
    public void addUsers(User... users) {
        for (User user : users) {
            addUser(user);
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
            if (user.getEmail().equalsIgnoreCase(email)) {
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
        return (getUser(email) != null) ? true : false;
    }

    /**
     * Removes user object if present.
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

    public Users getJsonObject() {
        // setter opp data
        Reader reader = null;
            // try to read file from home folder first
        if (jsonFile != null) {
            try {
                reader = new FileReader(new File("/workspace/gr2052/bookingsystem/core/src/main/resources/bookingsystem/core/" + getJsonFilename()));
            } catch (IOException ioex) {
                System.err.println("Fant ingen " + jsonFile + " på hjemmeområdet");
            }
        }

        if (reader == null) {
            // use embedded String
            reader = new StringReader(getJsonFilename());
        }
        Users users = null;
        try {
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
            users = new Users();
        }
        return users;
    }

    public List<User> getUsers() {
        return this.users;
    }

    private String getJsonFilename() {
        return this.jsonFile;
    } 

    public List<User> getJsonUsers() {
        return getJsonObject().getUsers();
    }
    
    public void saveToJson() {
        try {            
            Writer writer = new PrintWriter(new File("/workspace/gr2052/bookingsystem/core/src/main/resources/bookingsystem/core/" + getJsonFilename()));
            usersPersistence.writeUsers(this, writer);
        } catch (Exception e) {
            System.err.println("Couldn't write to " + getJsonFilename());
            e.printStackTrace();
        }
    }

    public void fireUsersChange() {
        saveToJson();
        this.users = getJsonUsers();
    }

}
