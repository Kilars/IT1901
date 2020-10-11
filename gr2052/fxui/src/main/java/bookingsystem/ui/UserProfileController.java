package bookingsystem.ui;

import bookingsystem.core.Booking;
import bookingsystem.core.User;
import bookingsystem.core.Users;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/* Kontroller for UserProfile.fxml */
public class UserProfileController {
    
    private User user;
    private Users users;

    @FXML
    Button logInButton;

    public static void main(String[] args) {
        UserProfileController c = new UserProfileController();
        User u = c.getUser();
        Booking b = new Booking();
        // ...
        u.addBooking(b);
        Users us = c.getUsers();
        us.saveToJson();
    }

    private User getUser() {
        return this.user;
    }

    private Users getUsers() {
        return this.users;
    }

    public User init_data(User user, Users users) {
        this.users = users;
        return this.user = user;
    }
}