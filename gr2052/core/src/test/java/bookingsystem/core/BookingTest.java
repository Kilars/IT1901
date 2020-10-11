package bookingsystem.core;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BookingTest {

    @Test
    public void testBooking(){
        User customer = new User("Ingrid", "Hagen", "ingrid@hotmail.com","97103994", "passord");
        HairDresser hairdresser = new HairDresser("Frisør");
        Treatment treatment = new Treatment("Klipp", 299);
        Treatment treatment2 = new Treatment("Striping", 299);

    }

}