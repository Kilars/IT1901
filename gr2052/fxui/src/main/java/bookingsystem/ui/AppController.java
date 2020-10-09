package bookingsystem.ui;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import bookingsystem.core.User;
import bookingsystem.core.Users;
import bookingsystem.json.UsersPersistence;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage; 

import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * Controller connected to FXApp.fxml
 */

public class AppController {
	
	@FXML
    Button registerButton, logInButton;
    private boolean checkScene = false;
    private Users users;
    private String jsonFile = "users.json";

    /**
     * Inializes the users object from the .json file.
     * @param jsonFile Filename as String
     */
    private void getInitialUsers(String jsonFile) {
        users.loadJSON(jsonFile);
    }


    /**
     * Changes the scene in the App from welcome-view to the register-user-view
     * @param event
     * @throws IOException
     */
    public void registerButtonPushed(ActionEvent event) throws IOException{
        this.checkScene = true;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterUser.fxml"));
        Parent registerUserParent = fxmlLoader.load();
        
        Scene registerUserScene = new Scene(registerUserParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(registerUserScene);
        window.show();

    }

    /**
     * Changes the scene from Welcome-view to Log-in-view
     * @param event
     * @throws IOException
     */

    public void logInButtonPushed(ActionEvent event) throws IOException{
        this.checkScene = true;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
        Parent logInParent = fxmlLoader.load();
        
        Scene logInScene = new Scene(logInParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(logInScene);
        window.show();
    }

    /**
     * Help method for testing successfull change of scene
     * @return boolean which is True if scene change was successfull
     */
	public boolean getCheckscene(){
        return this.checkScene;
    }
	
	public static void main(String[] args) {
        new AppController().getInitialUsers("users.json");
    }
	
	

}
