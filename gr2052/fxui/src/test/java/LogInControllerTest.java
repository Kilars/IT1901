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
    @BeforeEach
    public void setupUsers() {
        clickOn("#emailField").write("magnus.holta@gmail.com");
        clickOn("#passwordField").write("AAaaaa11");
    }

    @Test
    public void succsessfullLogIn(){
        clickOn("#logInButton");
        assertEquals("Successfull log in", controller.getFeedBackLabelText());
    }

    @Test
    public void checkUnusuccsessfullLogIn(){
        clickOn("#passwordField").write("skr");
        clickOn("#logInButton");
        assertEquals("Feil passord!", controller.getFeedBackLabelText());
    }*/
}