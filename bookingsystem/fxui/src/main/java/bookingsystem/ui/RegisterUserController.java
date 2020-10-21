package bookingsystem.ui;

import java.io.IOException;

import bookingsystem.core.User;
import bookingsystem.core.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller connected to RegisterUser.fxml
 */

public class RegisterUserController {

    private Users users;

    @FXML
    TextField nameField, surnameField, emailField, phoneNumberField;

    @FXML
    PasswordField passwordField, confirmPasswordField;

    @FXML
    Button registerUserButton, saveUserButton, returnButton;

    @FXML
    Label feedbackLabel;

    /**
     * Creates and saves a user object if the information provided by the users
     * input is valid Throws exception with descriptive message if the input is
     * invalid
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    public void handleSaveUserButton(ActionEvent event) throws IOException {
        try{
            User user = new User();
            user.setFirstName(nameField.getText());
            user.setSurname(surnameField.getText());
            user.setEmail(emailField.getText());
            user.setPhone(phoneNumberField.getText());
            checkPassword();
            user.setPassword(passwordField.getText());
            this.users.addUser(user);
            this.users.fireUsersChange();
            feedbackLabel.setText("");
            feedbackLabel.setText("Vellykket registrering av bruker");
            
            changeScene(event);
        } catch (IllegalArgumentException e){
            feedbackLabel.setText(e.getMessage());
        }
        
        
    }

    /**
     * Changes the scene to Log In, used in handleSaveUserButton
     * @param event
     * @throws IOException
     */
    private void changeScene(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("LogIn.fxml"));
        Parent logInParent = fxmlLoader.load();

        LogInController controller = fxmlLoader.getController();
        controller.init_data(this.getUsers());
        
        
        Scene logInScene = new Scene(logInParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(logInScene);
        window.show();
    }

    /**
     * The return button lets you go back to the welcome-view
     * @param event
     * @throws IOException
     */
    @FXML
    public void handleReturnButton(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FxApp.fxml"));
        Parent Parent = fxmlLoader.load();

        Scene Scene = new Scene(Parent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(Scene);
        window.show();

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
    public Users getUsers() {
        return this.users;
    }

    /**
     * @return text from feedback label
     */
    public String getFeedbackLabelText() {
        return feedbackLabel.getText();
    }


    /**
     * Help method for the methods changing scenes. Setting Users in the new scene's controller.
     * @param users
     */
    public void init_data(Users users){
        this.users = users;
    }
}