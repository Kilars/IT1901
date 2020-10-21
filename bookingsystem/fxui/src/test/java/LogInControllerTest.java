import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import bookingsystem.core.User;
import bookingsystem.core.Users;
import bookingsystem.ui.LogInController;
import bookingsystem.ui.RegisterUserController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LogInControllerTest extends ApplicationTest {


    private LogInController controller;
    private String jsonFile = "users.json";
    private Users userList = new Users(jsonFile);

    /* 
    *Loads LogInController
     */
    @Override
    public void start(final Stage stage) throws Exception {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIn_test.fxml"));
        final Parent root = loader.load();
        this.controller = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
        this.controller.init_data(this.userList);
        

    }

    /*
    * Writes an existing users username and password into the textfields
    * So that login would be successfull 
     */
    @BeforeEach
    public void setupUsers() {
        clickOn("#emailField").write("ole@hotmail.com");
        clickOn("#passwordField").write("informatikk");
    }

    /* 
    * Presses logInButton and logs in the user that was set up in the
    * @BeforeEach
    */
    @Test
    public void succsessfullLogIn(){
        clickOn("#logInButton");
        assertEquals("Successfull log in", controller.getFeedBackLabelText());
    }

    /* 
    * Adds the string "skr" to the password field so the login will be
    * unsuccessfull and then verifies that the user gets the notification
    * "Feil passord!"
    */
    @Test
    public void checkUnusuccsessfullLogIn(){
        clickOn("#passwordField").write("skr");
        clickOn("#logInButton");
        assertEquals("Feil passord!", controller.getFeedBackLabelText());
    }
    @Test
    /* 
    * Adds the string "mmm" to the emailField so the login will be
    * unsuccessfull and then verifies that the user gets the notification
    * "Brukeren finnes ikke"
    */
    public void checkIfUserDoesNotExists(){
        clickOn("#emailField").write("mmm");
        clickOn("#logInButton");
        assertEquals("Brukeren eksisterer ikke", controller.getFeedBackLabelText());
    }
}