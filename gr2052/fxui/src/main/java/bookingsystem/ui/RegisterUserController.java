package bookingsystem.ui;

import bookingsystem.core.User;
import bookingsystem.core.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller connected to RegisterUser.fxml
 */

public class RegisterUser{

    Users registeredUsers = new Users();

    @FXML
    TextField nameField, surnameField, emailField, phoneNumberField;

    @FXML
    PasswordField passwordField, confirmPasswordField;

    @FXML
    Button registerUserButton, saveUserButton;

    @FXML
    Label feedbackLabel;

    /**
     * Creates and saves a user object if the information provided by the users input is valid
     * Throws exception with descriptive message if the input is invalid 
     * @param event
     */
    @FXML
    public void handleSaveUserButton(ActionEvent event){
        try{
            User user = new User();
            user.setFirstName(nameField.getText());
            user.setSurname(surnameField.getText());
            user.setEmail(emailField.getText());
            user.setPhone(phoneNumberField.getText());
            checkPassword();
            user.setPassword(passwordField.getText());
            registeredUsers.addUser(user);
            feedbackLabel.setText("Vellykket registrering av bruker");
        }
        catch(IllegalArgumentException e){
            feedbackLabel.setText(e.getMessage());
        }

    }
    /**
     * Checks if the string from passwordField and confirmPasswordField are the same
     * Throws exception if they do not match
     * @throws IllegalArgumentException
     * @return True if they match
     */
    public boolean checkPassword(){
        if (passwordField.getText().equals(confirmPasswordField.getText())){
            return true;
        }
        else {
            throw new IllegalArgumentException("The passwords does not match");
        }
    }

    /**
     * @return the list of already registered users in the app
     */

    public Users getRegisteredUsers() {
        return registeredUsers;
    }

    




}