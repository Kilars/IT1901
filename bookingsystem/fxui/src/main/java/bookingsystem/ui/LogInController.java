package bookingsystem.ui;

import bookingsystem.core.Users;
import bookingsystem.core.User;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/* Controller for LogIn.fxml */
public class LogInController {
    
    private Users users;

    @FXML
    TextField emailField;

    @FXML
    PasswordField passwordField;

    @FXML
    Label feedbackLabel;

    @FXML
    Button logInButton;

    /**
     *Checks if user i an existing user and
     *"logs in" the user and changes scene to
     *userprofile.fxml
     * 
     * @param event
     */
    @FXML
    public void logInButtonPushed(ActionEvent event) throws IOException{
        try {
            if(this.users.logIn(emailField.getText(), passwordField.getText())){
                feedbackLabel.setText("Successfull log in");
                changeScene(event);
            }
        } catch (IllegalArgumentException e) {
            feedbackLabel.setText(e.getMessage());
        }

    }

    public Users init_data(Users users){
        return this.users = users;
    }

    /**
     * Changes the scene to UserProfile, used in logInButtonPushed
     * @param event
     * @throws IOException
     */
    private void changeScene(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("UserProfile.fxml"));
        Parent logInParent = fxmlLoader.load();
        
        Scene logInScene = new Scene(logInParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        UserProfileController controller = fxmlLoader.getController();
        controller.init_data(this.getUser(emailField.getText()), this.users);
        
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

    private User getUser(String email){
        return this.users.getUser(email);
    }
    public Users getUsers(){
        return this.users;
    }
    public String getFeedBackLabelText(){
        return this.feedbackLabel.getText();
    }

}