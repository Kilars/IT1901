import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import bookingsystem.core.HairDresser;
import bookingsystem.core.Salon;
import bookingsystem.core.Treatment;
import bookingsystem.core.User;
import bookingsystem.core.Users;
import bookingsystem.ui.BookingController;
import bookingsystem.ui.RegisterUserController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

//@RunWith(MockitoJUnitRunner.class)
public class BookingControllerTest extends ApplicationTest {


    /**
    * Set up for testing RegisterUserController.java
    */
    private String jsonFile = "users.json";
    private Users users = new Users(jsonFile);
    private BookingController controller;
    private Users userList;
    private String saveSuccess = "Vellykket registrering av bruker";
    private String saveUnsuccess = "The passwords does not match";
    private Salon salon = new Salon();


    @Override
    public void start(final Stage stage) throws Exception {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("Booking_test.fxml"));
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

    }

    /**
     * Check if the label prints correct message for a succsessfull register of an User
     *
    @Test
    public void checkSuccessfullRegisterUser(){
        clickOn("#saveUserButton");
        assertEquals(controller.getFeedbackLabelText(), saveSuccess);
    }
*/
    @Test
    public void checkChoiceBoxes() {
        try {
            ChoiceBox<HairDresser> hairdressersChoiceBox = controller.getHairDresserChoiceBox();
            List<HairDresser> hairdressersFromChoiceBox = hairdressersChoiceBox.getItems();
            List<HairDresser> hairdressersFromSalon = salon.getHairdresserList();
            for (int i = 0; i < hairdressersFromSalon.size(); i++) {
                assertEquals(hairdressersFromChoiceBox.get(i).getName(), 
                    hairdressersFromSalon.get(i).getName());
            }

            ChoiceBox<Treatment> treatmentsChoiceBox = controller.getTreatmentsChoiceBox();
            List<Treatment> treatmentsFromChoiceBox = treatmentsChoiceBox.getItems();
            List<Treatment> treatmentsFromSalon = salon.getTreatmentList();
            for (int i = 0; i < treatmentsFromSalon.size(); i++) {
                assertEquals(treatmentsFromChoiceBox.get(i).getTreatment(), 
                    treatmentsFromSalon.get(i).getTreatment());
            }

            ChoiceBox<String> hourChoiceBox = controller.getHourChoiceBox();
            List<String> hoursFromChoiceBox = hourChoiceBox.getItems();
            List<String> hoursFromController = controller.getTimeList();
            for (int i = 0; i < hoursFromController.size(); i++) {
                assertEquals(hoursFromChoiceBox.get(i), hoursFromController.get(i));
            }

        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }
    } 
    
    /**
     * Check if the label prints correct message for an unsuccsessfull register of an User
     *
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