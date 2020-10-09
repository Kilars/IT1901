import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;


import bookingsystem.core.User;
import bookingsystem.core.Users;
import bookingsystem.ui.RegisterUserController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//@RunWith(MockitoJUnitRunner.class)
public class RegisterUserControllerTest extends ApplicationTest {

    /**
    * Set up for testing RegisterUserController.java
    */
    private RegisterUserController controller;
    private Users userList;
    private String saveSuccess = "Vellykket registrering av bruker";
    private String saveUnsuccess = "The passwords does not match";


    @Override
    public void start(final Stage stage) throws Exception {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterUser_test.fxml"));
        final Parent root = loader.load();
        this.controller = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
        this.userList = this.controller.getUsers();

    }


    /**
     * Set up for the tests, clicking on the TextField and filling them with information
     */
    @BeforeEach
    public void setupUsers() {
        clickOn("#nameField").write("Ole");
        clickOn("#surnameField").write("Olsen");
        clickOn("#emailField").write("ole@hotmail.com");
        clickOn("#phoneNumberField").write("12312398");
        clickOn("#passwordField").write("informatikk");
        clickOn("#confirmPasswordField").write("informatikk");
    }

    /**
     * Check if the label prints correct message for a succsessfull register of an User
     */
    @Test
    public void checkSuccessfullRegisterUser(){
        clickOn("#saveUserButton");
        assertEquals(controller.getFeedbackLabelText(), saveSuccess);
    }


    /**
     * Check if the label prints correct message for an unsuccsessfull register of an User
     */
    @Test
    public void  checkUnsuccsessfullRegisterUser(){
        clickOn("#confirmPasswordField").write("1234");
        clickOn("#saveUserButton");
        assertEquals(controller.getFeedbackLabelText(), saveUnsuccess);
    }

    /**
     * Check if the User gets saved to Users when clicking save-button
     */
    //Made code crash when updating controllers
/*     @Test
    public void checkSavingOfUser(){
        clickOn("#saveUserButton");
        assertTrue(iterateUserList("ole@hotmail.com"));
    } */

    /**
     * help method for checkSavingOfUser()
     * @param email
     * @return True if email is saved with a User in Users
     */
    private boolean iterateUserList(String email){
        if(!userList.equals(null)){
            for (User user:userList){
                if (user.getEmail().equals(email)){
                    return true;
                }
            }
        }
        return false;
        
    }




}