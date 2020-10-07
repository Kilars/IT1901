package bookingsystem.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * Controller connected to FXApp.fxml
 */

public class AppController {
	
	@FXML
    Button registerButton, logInButton;
    private boolean checkScene = false;

/**
 * Changes the scene in the App from welcome-view to the register-user-view
 * @param event
 * @throws IOException
 */
    public void registerButtonPushed(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterUser.fxml"));
        Parent registerUserParent = fxmlLoader.load();
        
        Scene registerUserScene = new Scene(registerUserParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(registerUserScene);
        window.show();
        this.checkScene = true;



    }

    /**
     * Help method for testing successfull change of scene
     * @return boolean which is True if scene change was successfull
     */
	public boolean getCheckscene(){
        return this.checkScene;
    }
	
	
	
	

}
