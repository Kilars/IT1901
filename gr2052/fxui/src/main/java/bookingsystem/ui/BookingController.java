package bookingsystem.ui;

import java.io.IOException;
import java.time.LocalDate;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class BookingController {
    @FXML
    DatePicker datePicker;
    @FXML
    SplitMenuButton hourMenu, treatmentMenu, hairdresserMenu;
    @FXML
    Label priceLabel,feedbackLabel;
    @FXML
    Button bestillButton, cancelButton;
    @FXML
    VBox dynamicVBox;

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
                // Do something updateCurrFromLabel
            }
        });

        treatmentsChoiceBox.valueProperty().addListener((obs, old, current) -> {
            if (current != null) {
                // Do something update CurrToLabels
            }
        });

        // Add to UI
        dynamicVBox.getChildren().add(treatmentsChoiceBox);
        dynamicVBox.getChildren().add(hairdressersChoiceBox);
    }

    /**
     * Read list of treatments from salon and add each treatment as a MenuItem to
     * the SplitMenuButton treatmentMenu.
     */
    public void updateTreatmentMenu() {
        int i = 1;
        for (Treatment treatment : salon.getTreatmentList()) {
            MenuItem x = new MenuItem(i + treatment.getTreatment());
            treatmentMenu.getItems().add(x);
            i++;
        }
    }


    /**
     * Preliminary solution for adding aviable hours-MenuItems to SplitMenuButton
     * hourMenu.
     */
    public void updateHourMenu() {
        for (int i = 9; i < 16; i++) {
            MenuItem x = new MenuItem("0" + i + ":00");
            hourMenu.getItems().add(x);
        }
    }

    /**
     * Read list of hairdressers from salon and add each as a MenuItem to
     * the SplitMenuButton hairdresserMenu.
     */
    public void updateHairdresserMenu() {
        int i = 1;
        for (HairDresser hairdresser : salon.getHairdresserList()) {
            MenuItem x = new MenuItem(i+hairdresser.getName());
            treatmentMenu.getItems().add(x);
            i++;
        }
    }
    
     /**
     * Changes the scene in the App from booking-view to the user-profile-view
     * @param event
     * @throws IOException
     */
    public void cancelButtonPushed(ActionEvent event) throws IOException{
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
        saveBooking();
        try{
        user.addBooking(this.booking);
        users.fireUsersChange();
        }
        catch (Exception e){
            this.feedbackLabel.setText("Booking ikke vellykket, prøv igjen");
        }
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
     * Updating price label when treatment is chosen by user and setting treatment for booking
     * @param event
     */
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
     */
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
        try{
            this.date = datePicker.getValue();
            this.hour = hourMenu.getText();
            this.booking = new Booking(this.user, this.hairdresser, this.treatment, this.date, this.hour);
        }
        catch (IllegalArgumentException e){
            feedbackLabel.setText(e.getMessage());
        }
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