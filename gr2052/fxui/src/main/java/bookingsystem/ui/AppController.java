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

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import javafx.fxml.FXML;
/**
 * Controller connected to FxApp.fxml
 */

public class AppController {
	
	@FXML
    Button registerButton, logInButton;

    private boolean checkScene = false;
    private String json_path = "users.json";
    private Users users = getInitialUsers();

    private Users getInitialUsers() {
        // setter opp data
        Reader reader = null;
        URL url = getClass().getResource(json_path);
        if (url != null) {
            try {
            reader = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8);
            } catch (IOException e) {
            System.err.println("Kunne ikke lese innebygget " + json_path);
            }
        } else {
            
            System.err.println("Fant ikke innebygget " + json_path);
        }
        
        if (reader == null) {
        // use embedded String
        reader = new StringReader(json_path);
        }
        Users users = null;
        try {
        UsersPersistence usersPersistence = new UsersPersistence();
        users = usersPersistence.readUsers(reader);
        } catch (IOException e) {
        // ignore
        } finally {
            try {
                if (reader != null) {
                reader.close();
                }
            } catch (IOException e) {
                // ignore
            }
        }
        System.out.println("Users: " + users);
        if (users == null) {
            users = new Users(
                new User("Magnus", "Holta", "magnus.holta@gmail.com", "48052730", "Hallodu123"),
                new User("Lars", "Skifjeld", "hallo.du@lars.no", "12345678", "Neineineinei123")
            );
        }
        return users;
    }


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
