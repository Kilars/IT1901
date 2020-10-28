package bookingsystem.ui;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;


public class BookingTreatmentController{

  @FXML
  ChoiceBox<Treatment> treatmentsChoiceBox = new ChoiceBox<>();

  private Salon salon = new Salon();
  private User user;
  private Users users;


  /**
     * Initialize SplitMenuButtons when the fxml-file is opened/showed to user
     */
    public void initialize() {
        addDynamicContent();
    }


   public void addDynamicContent() {
        // Fill elements
        treatmentsChoiceBox.setId("treatmentsChoiceBox");
        treatmentsChoiceBox.setItems(FXCollections.observableList(this.salon.getTreatmentList()));

        // Setting string converters to be able to view strings that are connected to an object
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
      }


}