package bookingsystem.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import bookingsystem.fillagring.FilesHandle;

public class Users {
    private List<User> usersList = new ArrayList<>();
    private FilesHandle fileHandler = new FilesHandle();
    private String fileName = "users.txt";
    public Users() {
        loadUsersFromFile(this.fileName);
    }

    public void loadUsersFromFile(String fileName) {
        this.usersList = (fileHandler.readFromFile(fileName) == null) ? new ArrayList<>() : fileHandler.readFromFile(fileName).stream().map(user -> new User(user)).collect(Collectors.toList());
    }

    public void saveUsersToFile(String fileName) {
        fileHandler.writeToFile(fileName, usersList.stream().map(user -> user.toString()).collect(Collectors.toList()), false);
    }

    public void addUser(User user) {
        if (checkIfUserExists(user.getEmail()))
            throw new IllegalArgumentException("Emailen er allerede registrert");
        this.usersList.add(user);
        saveUsersToFile(this.fileName);
    }

    private User getUser(String email) {
        for (User user : this.usersList) {
            if (user.getEmail() == email) {
                return user;
            }
        }
        return null;
    }

    private boolean checkIfUserExists(String email) {
        return (getUser(email) == null) ? false : true;
    }

    public void removeUser(User user) {
        this.usersList.remove(user);  
    }



}