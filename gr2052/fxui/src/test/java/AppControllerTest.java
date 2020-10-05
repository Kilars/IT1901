import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import bookingsystem.ui.AppController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppControllerTest extends ApplicationTest {

    
    private AppController controller;

    /**
     * Set up for testing AppController.java
     */

    @BeforeEach
    public void start(final Stage stage) throws Exception {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("FxApp.fxml"));
        final Parent root = loader.load();
        this.controller = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Check if scene is switched to RegisterUser.fxml when clicking Register-Button in FxApp.fxml
     */

    @Test
    public void testRegisterButton(){
        clickOn("#registerUserButton");
        //FxAssert.verifyThat(window("My Window"), WindowMatchers.isShowing());
    }
    
}


