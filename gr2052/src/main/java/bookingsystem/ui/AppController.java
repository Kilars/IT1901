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

public class AppController {
	
	@FXML
    Button registerButton;
    

    @FXML
    Button logInButton;

    public void registerButtonPushed(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterUser.fxml"));
        Parent registerUserParent = fxmlLoader.load();
        
        Scene registerUserScene = new Scene(registerUserParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(registerUserScene);
        window.show();

    }
	
	
	
	
	

}
