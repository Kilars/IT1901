package bookingsystem.ui;

import bookingsystem.core.Booking;
import bookingsystem.core.User;
import bookingsystem.core.Users;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.ListView;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/* Controller connected to UserProfile.fxml. */
public class UserProfileController {
    
    private User user;
    private Users users;
    private int choosedBooking;

    @FXML
    Button logInButton, bookingButton, avbestilleButton, endreTimeButton, logOutButton;

    @FXML
    ListView bookingList;

    @FXML
    Label firstName, surname, email, phone;

    /**
     * Method for when bookingButton is hit ("Gå til timebestilling"), for changing scene to Booking.fxml.
     */
    public void handleBookingButton(ActionEvent event) throws IOException {
        try{
            changeScene(event);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    /**
     * Changes the scene to Log In, used in handleBookingButton.
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
     * The return button lets you go back to the logIn-view.
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
    @FXML
    private void setUIvalues() {
        firstName.setText(this.user.getFirstName());
        surname.setText(this.user.getSurname());
        email.setText(this.user.getEmail());
        phone.setText(this.user.getPhone());
    }

    /**
     * Iterates through the currently logged in User object's bookings and adds each to the ListView under "Mine avtaler:" in the ui.
     * Catches NullPointerException.
     */
    @FXML
    private void setBookings(){
      try{
        List<Booking> UserBookingList = this.user.getBookings();
        for (Booking booking : UserBookingList){
          this.bookingList.getItems().add(booking.toString());
        }
      }
      catch(NullPointerException e){}
    }

    /**
     * If a booking in ListView in ui is clicked on, the "Avbestille time"-button will become available, and the currently choosed 
     * booking's index in the list is saved in choosedBooking, for further use.
     * @param event
     */
    @FXML
    private void handleChoosedBooking(ActionEvent event){
      this.choosedBooking = this.bookingList.getSelectionModel().getSelectedIndex();
      avbestilleButton.setDisable(false);
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
        setBookings();
        return this.user;
    }
}