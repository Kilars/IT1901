package bookingsystem.ui;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import bookingsystem.core.Booking;
import bookingsystem.core.HairDresser;
import bookingsystem.core.Treatment;
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

    /**
     * Method to return this controller's fxml-file
     * @return String name of fxml-file
     */
    public String returnFxmlFile(){
        return "FxApp.fxml";
    }

    /**
     * Method to return Users
     * @return users
     */
    public Users getUsers(){
        return this.users;
    }
	
	/**public static void main(String[] args) {
        AppController c = new AppController();
        Users us = c.getUsers();
        User u = us.getUser("magnus.holta@gmail.com");
        User u2 = us.getUser("haugenstua.097@ferdi.da");
        Booking b1 = u2.getBookings().get(0);
        b1.setCustomer(u);
        //new Booking(u, 
        //                    new HairDresser("Kari"),
        //                    new Treatment("Herreklipp", 200.1),
        //                    LocalDate.now(), "10:20");
        c.getUsers().fireUsersChange();
        u.getBookings().forEach(b -> System.out.println(b));
    }**/
	
	

}
