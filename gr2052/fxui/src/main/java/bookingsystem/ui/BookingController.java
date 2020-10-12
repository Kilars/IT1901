package bookingsystem.ui;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import bookingsystem.core.Booking;
import bookingsystem.core.HairDresser;
import bookingsystem.core.Salon;
import bookingsystem.core.Treatment;
import bookingsystem.core.User;
import bookingsystem.core.Users;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class BookingController {
    @FXML
    DatePicker datePicker;
    @FXML
    Label priceLabel,feedbackLabel;
    @FXML
    Button bestillButton, cancelButton;
    @FXML
    GridPane dynamicGrid;

    private Boolean checkScene = false;
    private Salon salon = new Salon();
    private User user;
    private Users users;
    private Booking booking;
    private LocalDate date;
    private String hour;
    private Treatment treatment;
    private HairDresser hairdresser;

    ChoiceBox<HairDresser> hairdressersChoiceBox = new ChoiceBox<>();
    ChoiceBox<Treatment> treatmentsChoiceBox = new ChoiceBox<>();
    ChoiceBox<String> hourChoiceBox = new ChoiceBox<>();

    /**
     * Initialize SplitMenuButtons when the fxml-file is opened/showed to user
     */
    public void initialize() {
        addDynamicContent();
      /*  updateTreatmentMenu();
        updateHourMenu();
        updateHairdresserMenu();*/
    }

    public Users init_data(Users users){
        return this.users = users;
    }

    public void addDynamicContent() {
        // Fill elements
        hairdressersChoiceBox.setItems(FXCollections.observableList(this.salon.getHairdresserList()));
        treatmentsChoiceBox.setItems(FXCollections.observableList(this.salon.getTreatmentList()));
        hourChoiceBox.setItems(FXCollections.observableList(getTimeList()));

        // Setting string converters to be able to view strings that are connected to an object
        hairdressersChoiceBox.setConverter(new StringConverter<HairDresser>() {
            @Override
            public String toString(HairDresser hairdresser) {
                if (hairdresser == null) {
                    return null;
                } else {
                    return hairdresser.getName();
                }
            }
            @Override
            public HairDresser fromString(String string) {
                return hairdressersChoiceBox.getItems().stream().filter(h -> h.getName().equals(string)).findFirst().orElse(null);
            }
        });

        treatmentsChoiceBox.setConverter(new StringConverter<Treatment>() {
            @Override
            public String toString(Treatment treatment) {
                if (treatment == null) {
                    return null;
                } else {
                    return treatment.getTreatment();
                }
            }
            @Override
            public Treatment fromString(String string) {
                return treatmentsChoiceBox.getItems().stream().filter(h -> h.getTreatment().equals(string)).findFirst().orElse(null);
            }
        });

        // EventHandlers
        hairdressersChoiceBox.valueProperty().addListener((obs, old, current) -> {
            if (current != null) {
                setHairdresser(current);
            }
        });

        treatmentsChoiceBox.valueProperty().addListener((obs, old, current) -> {
            if (current != null) {
                setTreatments(current);
            }
        });

        hourChoiceBox.valueProperty().addListener((obs, old, current) -> {
            if (current != null) {
                setHour(current);
            }
        });

        // Add to UI
        dynamicGrid.setHgap(20);
        dynamicGrid.setVgap(10);
        dynamicGrid.add(new Text("Velg klokkeslett"), 2, 1);
        dynamicGrid.add(hourChoiceBox, 2, 2);
        dynamicGrid.add(new Text("Velg behandling"), 1, 3);
        dynamicGrid.add(treatmentsChoiceBox, 1, 4, 2, 1);
        dynamicGrid.add(new Text("Velg frisør"), 1, 5);
        dynamicGrid.add(hairdressersChoiceBox, 1, 6, 2, 1);
        treatmentsChoiceBox.setPrefWidth(480);
        hairdressersChoiceBox.setPrefWidth(480);
    }

    private void setHour(String hour) {
        this.hour = hour;
    }

    private void setTreatments(Treatment treatment) {
        this.treatment = treatment;
    }

    private void setHairdresser(HairDresser hairDresser) {
        this.hairdresser = hairDresser;
    }

    /**
     * Preliminary solution for adding aviable hours-MenuItems to ChoiceBox
     * timeChoiceBox
     */
    public List<String> getTimeList() {
        List<String> list = new ArrayList<>();
        for (int i = 9; i < 16; i++) {
            String x = i + ":00";
            if (i < 10) {
                x = "0" + x;
            }
            list.add(x);
        }
        return list;
    }

    
     /**
     * Changes the scene in the App from booking-view to the user-profile-view
     * @param event
     * @throws IOException
     */
    public void cancelButtonPushed(ActionEvent event) throws IOException {
        this.checkScene=true;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserProfile.fxml"));
        Parent registerUserParent = fxmlLoader.load();
        
        UserProfileController controller = fxmlLoader.getController();
        controller.init_data(this.user, this.users);
        
        Scene userProfileScene = new Scene(registerUserParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(userProfileScene);
        window.show();

    }

    /**
     * Save booking with details from ui
     * Changes the scene in the App from booking-view to the user-profile-view
     * @param event
     * @throws IOException
     */
    public void bestillButtonPushed(ActionEvent event) throws IOException{
        try{
            saveBooking();

            users.saveToJson();
            // Change back to UserProfile
            cancelButtonPushed(event);
        }
        catch (Exception e){
            this.feedbackLabel.setText(e.getMessage());
        }
    }

    /**
     * Updating price label when treatment is chosen by user and setting treatment for booking
     * @param event
     *
    public void treatmentChosen(ActionEvent event){
        for (MenuItem treatmentItem : treatmentMenu.getItems()){
            if (treatmentMenu.getText().equals(treatmentItem.getText())){
                this.treatment = salon.getTreatmentList().get((Integer.parseInt(treatmentItem.getText().substring(0, 1))));
                this.priceLabel.setText(String.valueOf(this.treatment.getPrice()+" kr"));

            }
            else{
                this.feedbackLabel.setText("Vennligst velg en behandling");
            }
        }
    }

    /**
     * Setting hairdresser when it is choosed by user
     * @param event
     *
    public void hairdresserChosen(ActionEvent event){
        for (MenuItem hairdresserItem : hairdresserMenu.getItems()){
            if (hairdresserMenu.getText().equals(hairdresserItem.getText())){
                if (hairdresserItem.getText().matches("Tilfeldig")){
                    int randomNum = ThreadLocalRandom.current().nextInt(0, salon.getHairdresserList().size());
                    this.hairdresser=salon.getHairdresserList().get(randomNum);
                }
                else {
                    this.hairdresser=salon.getHairdresserList().get(Integer.parseInt(hairdresserItem.getText().substring(0, 1)));
                }
            }
            else{
                this.feedbackLabel.setText("Vennligst velg en frisør");
            }
        }
    }



    /**
     * Save booking and add to the User object. 
     * Prints error message in feedback-label if anything is missing.
     */
    private void saveBooking(){
        this.date = datePicker.getValue();
        if (this.hairdresser == null ||
            this.treatment == null ||
            this.date == null ||
            this.hour == "") {
                throw new IllegalArgumentException("Fyll ut alle feltene");
            }
        Booking book = new Booking();
        book.setDate(this.date);
        book.setTreatment(this.treatment);
        book.setTime(this.hour);
        book.setHairdresser(this.hairdresser);
        book.setCustomer(this.user);
    }

    /**
     * 
     * @return user object for this booking
     */
    private User getUser() {
        return this.user;
    }

    /**
     * Needed for saving to file
     * @return Users for the whole program
     */
    private Users getUsers() {
        return this.users;
    }

    /**
     * Help method for the methods changing scenes. Setting User and Users in the new scene's controller.
     * @param user
     * @param users
     * @return User
     */
    public User init_data(User user, Users users) {
        this.users = users;
        return this.user = user;
    }
}