package bookingsystem.ui;

import java.io.IOException;
import bookingsystem.core.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller connected to FxApp.fxml
 */

public class AppController {
	
	@FXML
    Button registerButton, logInButton;

    private boolean checkScene = false;
    private String jsonFile = "users.json";
    private Users users = new Users(jsonFile);

   
    /**
     * Changes the scene in the App from welcome-view to the register-user-view
     * @param event
     * @throws IOException
     */
    public void registerButtonPushed(ActionEvent event) throws IOException{
        this.checkScene = true;

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("RegisterUser.fxml"));
        Parent registerUserParent = fxmlLoader.load();

        RegisterUserController controller = fxmlLoader.getController();
        controller.init_data(this.getUsers());
        
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
     * Help method for testing successfull change of scene
     * @return boolean which is True if scene change was successfull
     */
	public boolean getCheckscene(){
        return this.checkScene;
    }

    public String returnFxmlFile(){
        return "FxApp.fxml";
    }

    public Users getUsers(){
        return this.users;
    }
}
