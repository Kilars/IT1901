package bookingsystem.ui;

import bookingsystem.core.Booking;
import bookingsystem.core.User;
import bookingsystem.core.Users;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    @FXML
    Label firstName;

    @FXML
    Label surname;

    @FXML
    Label email;
    @FXML
    Label phone;

    @FXML
    Button bookingButton;


    public void handleBookingButton(ActionEvent event) throws IOException {
        try{
            changeScene(event);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    private void changeScene(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Booking.fxml"));
        Parent bookingParent = fxmlLoader.load();
        
        Scene bookingScene = new Scene(bookingParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        UserProfileController controller = fxmlLoader.getController();
        controller.init_data(this.user, this.users);

        window.setScene(bookingScene);
        window.show();
    }
    
    private void setUIvalues() {
        firstName.setText(user.getFirstName());
        surname.setText(user.getSurname());
        email.setText(user.getEmail());
        phone.setText(user.getPhone());
    }
    
    private User getUser() {
        return this.user;
    }
    
    private Users getUsers() {
        return this.users;
    }
    
    public User init_data(User user, Users users) {
        this.users = users;
        this.user = user;
        setUIvalues();
        return this.user;
    }
    
        public static void main(String[] args) {
            UserProfileController c = new UserProfileController();
            User u = c.getUser();
            Booking b = new Booking();
            // ...
            u.addBooking(b);
            Users us = c.getUsers();
            us.saveToJson();
        }
}