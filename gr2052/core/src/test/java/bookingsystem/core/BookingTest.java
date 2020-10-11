package bookingsystem.core;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BookingTest {

    private User customer1;
    private User customer2;
    private HairDresser hairDresser;
    private Treatment treatment1;
    private Treatment treatment2;
    private Booking booking;
    private LocalDate date;
    private String time;

    @BeforeEach
    public void setUp() {
        customer1 = new User("Ola", "Nordmann", "ola.nordmann@mail.no", "12345678", "Passord123");
        customer2 = new User("Kari", "Nordmann", "kari.nordmann@mail.no", "12345678", "Passord123");
        hairDresser = new HairDresser("Kari");
        treatment1 = new Treatment("Klipp", 199);
        treatment2 = new Treatment("Striping", 299);
        booking = new Booking();
        date = LocalDate.of(2020, 12, 15);
        time = "10:30";
    }
    @Test
    public void testBooking(){
        User customer = new User("Ingrid", "Hagen", "ingrid@hotmail.com","97103994", "passord");
        HairDresser hairdresser = new HairDresser("Frisør");
        Treatment treatment = new Treatment("Klipp", 299);
        Treatment treatment2 = new Treatment("Striping", 299);
        
    }

    @Test 
    public void testSetNewCustormer() {
        booking.setCustomer(customer1);
        booking.setCustomer(customer2);
        assertEquals(customer2.getBookings().get(0), booking);
        assertTrue(customer1.getBookings().isEmpty());
    }

    @Test
    public void testConstructor() {
        booking = new Booking(customer1, hairDresser, treatment1, date, time);
        assertEquals(booking.getCustomer(), customer1);
        assertEquals(booking.getHairdresser(), hairDresser);
        assertEquals(booking.getTreatment(), treatment1);
        assertEquals(booking.getDate(), date);
        assertEquals(booking.getTime(), time);
    }

    @Test
    public void testRemoveUser() {
        booking.setCustomer(customer1);
        booking.setCustomer(null);
        assertNull(booking.getCustomer());
    }
}