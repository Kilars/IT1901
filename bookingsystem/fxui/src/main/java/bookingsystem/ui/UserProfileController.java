package bookingsystem.ui;

import bookingsystem.core.User;
import bookingsystem.core.Users;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/* Controller connected to UserProfile.fxml */
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

    /**
     * Method for when bookingButton is hit ("Gå til timebestilling"), for changing scene to Booking.fxml
     */
    public void handleBookingButton(ActionEvent event) throws IOException {
        try{
            changeScene(event);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    /**
     * Changes the scene to Log In, used in handleBookingButton
     * @param event
     * @throws IOException
     */
    private void changeScene(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Booking.fxml"));
        Parent bookingParent = fxmlLoader.load();
        
        Scene bookingScene = new Scene(bookingParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        BookingController controller = fxmlLoader.getController();
        controller.init_data(this.user, this.users);

        window.setScene(bookingScene);
        window.show();
    }

    /**
     * The return button lets you go back to the logIn-view
     * @param event
     * @throws IOException
     */
    @FXML
    public void handleReturnButton(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("LogIn.fxml"));
        Parent Parent = fxmlLoader.load();

        Scene Scene = new Scene(Parent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(Scene);
        window.show();

    }
    
    /**
     * Set the user information to the labels in the ui. The information is collected from the currently logged in User object.
     */
    private void setUIvalues() {
        firstName.setText(user.getFirstName());
        surname.setText(user.getSurname());
        email.setText(user.getEmail());
        phone.setText(user.getPhone());
    }

    /**
     * @return the currently logged in User object
     */
    private User getUser() {
        return this.user;
    }
    
    /**
     * 
     * @return the list of already registered users in the app
     */
    private Users getUsers() {
        return this.users;
    }
    
    /**
     * Help method for the methods changing scenes. Setting User and Users in the new scene's controller.
     * @param user
     * @param users
     * @return User
     */
    public User init_data(User user, Users users) {
        this.users = users;
        this.user = user;
        setUIvalues();
        return this.user;
    }
}