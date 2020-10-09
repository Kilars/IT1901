package bookingsystem.ui;

import bookingsystem.core.User;

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

    @FXML
    Button logInButton;


    public User init_data(User user){
        return this.user = user;
    }


}