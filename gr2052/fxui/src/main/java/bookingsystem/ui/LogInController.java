package bookingsystem.ui;
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

/* Kontroller for LogIn.fxml */
public class LogInController {
    
    private Users users;

    @FXML
    TextField emailField;

    @FXML
    TextField passwordField;

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
                changeScene(event);
            }
        } catch (Exception e) {
            feedbackLabel.setText(e.getMessage());
        }

    }

    public Users init_data(Users users){
        return this.users = users;
    }

    private void changeScene(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserProfile.fxml"));
        //fxmlLoader.setLocation(getClass().getResource("LogIn.fxml"));
        Parent logInParent = fxmlLoader.load();

        //LogInController controller = fxmlLoader.getController();
        //controller.init_data(this.getUsers());
        
        
        Scene logInScene = new Scene(logInParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(logInScene);
        window.show();
    }
}