package bookingsystem.ui;

import bookingsystem.core.User;
import bookingsystem.core.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    public boolean checkPassword(){
        if (passwordField.getText().equals(confirmPasswordField.getText())){
            return true;
        }
        else {
            throw new IllegalArgumentException("The passwords does not match");
        }
    }

    




}