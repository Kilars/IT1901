import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.api.FxRobot;

import bookingsystem.core.Users;
import bookingsystem.ui.RegisterUserController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class RegisterUserControllerTest extends ApplicationTest {

    /**
    * Set up for testing RegisterUserController.java
    */
    private RegisterUserController controller;
    private Users userList;
    private String saveSuccess = "Vellykket registrering av bruker";
    private String saveUnsuccess = "The passwords does not match";
    //private FxRobot robot = new FxRobot;

    @Override
    public void start(final Stage stage) throws Exception {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterUser.fxml"));
        final Parent root = loader.load();
        this.controller = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
        this.userList = this.controller.getRegisteredUsers();
    }

    /**
     * Set up for the tests, clicking on the TextField and filling them with information
     */
    @BeforeEach
    public void setupUsers(FxRobot robot) {
        robot.clickOn("#nameField").write("Ole");
        robot.clickOn("#surnameField").write("Olsen");
        robot.clickOn("#emailField").write("ole@hotmail.com");
        robot.clickOn("#phoneNumberField").write("12312398");
        robot.clickOn("#passwordField").write("informatikk");
        robot.clickOn("#confirmPasswordField").write("informatikk");
    }

    /**
     * Check if the label prints correct message for a succsessfull register of an User
     */
    @Test
    public void checkSuccessfullRegisterUser(FxRobot robot){
        robot.clickOn("#saveUserButton");
        //assertEquals(feedbackLabel.getText(),saveSuccess);
        verifyThat("#feedbackLabel", hasText(saveSuccess));
    }


    /**
     * Check if the label prints correct message for an unsuccsessfull register of an User
     */
    @Test
    public void  checkUnsuccsessfullRegisterUser(FxRobot robot){
        robot.clickOn("#confirmPasswordField").
        robot.clickOn("#confirmPasswordField").write("informatikk1234");
        robot.clickOn("#saveUserButton");
        verifyThat("#feedbackLabel", hasText(saveUnsuccess));
    }

    /**
     * Check if the User gets saved to Users when clicking save-button
     */
    @Test
    public void checkSavingOfUser(FxRobot robot){
        robot.clickOn("#saveUserButton");
        assertTrue(iterateUserList("ole@hotmail.com"));
    }

    /**
     * help method for checkSavingOfUser()
     * @param email
     * @return True if email is saved with a User in Users
     */
    private boolean iterateUserList(String email){
        for (User user in userList){
            if (user.getEmail().equals(email)){
                return True;
            }
        }
        else{
            return False;
        }
    }




}