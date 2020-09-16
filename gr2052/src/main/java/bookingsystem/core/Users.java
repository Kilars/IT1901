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
        this.usersList = fileHandler.readFromFile(fileName).stream().map(user -> new User(user)).collect(Collectors.toList());
    }

    public void saveUsersToFile(String fileName) {
        fileHandler.writeToFile(fileName, usersList.stream().map(user -> user.toString()).collect(Collectors.toList()), true);
    }

    public void addUser(User user) {
        this.usersList.add(user);
        saveUsersToFile(this.fileName);
    }

    public void removeUser(User user) {
        this.usersList.remove(user);   
    }

    public static void main(String[] args) {
        //User user = new User();
    }





}