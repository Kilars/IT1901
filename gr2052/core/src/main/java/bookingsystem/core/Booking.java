package bookingsystem.core;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * Booking class
 * Each booking has a customer, hairdresser, treatment, date, and time
 */
public class Booking {

    private User customer;
    private HairDresser hairdresser;
    private Treatment treatment;
    private LocalDate date;
    private String time;
   
    /**
     * Constructor using parameters customer, hairdresser, treatment, date, and time
     * @param customer      User object
     * @param hairdresser   hairdresser object
     * @param treatment     treatment object
     * @param date          LocalDate object
     * @param time          String time
     */
    public Booking(User customer, HairDresser hairdresser, Treatment treatment, LocalDate date, String time) {
        setHairdresser(hairdresser);
        setTreatment(treatment);
        setCustomer(customer);
        setDate(date);
        setTime(time);
    }

    /**
     * Constructor with no parameters. 
     * All parameters are set to null
     */
    public Booking() {
    }

    /**
     * Method to set Customer
     * @param customer the customer to set
     */
    public void setCustomer(User customer) {
        System.out.println("Cost " + this.customer + " " + customer);
        if (this.customer != null) {
            this.customer.removeBooking(this);
        }

        this.customer = customer;
        
        if (customer != null) {
            this.customer.addBooking(this);
        }
    }

    /**
     * Method to set hairdresser
     * @param hairdresser the hairdresser to set
     */
    public void setHairdresser(HairDresser hairdresser) {
        this.hairdresser = hairdresser;
    }


    /**
     * Method to set treatment
     * @param treatment the treatment to set
     */
    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    /**
     * Method to return customer
     * @return the customer
     */
    public User getCustomer() {
        return customer;
    }

    /**
     * Method to return hairdresser
     * @return the hairdresser
     */
    public HairDresser getHairdresser() {
        return hairdresser;
    }

    /**
     * Method to return treatment
     * @return the treatment
     */
    public Treatment getTreatment() {
        return treatment;
    }

    /**
     * Method to return date
     * @return date of treatment
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Method to set date
     * @param date to set for the treatment
     */
    public void setDate(LocalDate date) {
        if (date.equals(null)){
            throw new IllegalArgumentException("Vennligst velg en dato");
        }
        if(date.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Dato må være i fremtid");
        }
        if(date.isAfter(LocalDate.now().plusDays(60))){
            throw new IllegalArgumentException("Kan ikke booke mer enn 60 dager i forveien");
        }
        if(date.getDayOfWeek().equals(DayOfWeek.SATURDAY)||date.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            throw new IllegalArgumentException("Vennligst velg en ukedag");
        }
        else{
            this.date = date;
        }
    }

    /**
     * Method to return time of treatment.
     * @return time of the treatment
     */
    public String getTime() {
        return time;
    }

    /**
     * Method to set time for treatment.
     * @param time for treatment
     */
    public void setTime(String time) {    
        if (Pattern.matches("[0-9][0-9]:[0-9][0-9]",time)) {
                this.time=time;
            }
        else{
            throw new IllegalArgumentException("Vennligst velg et tidspunkt");
        }
    }
    
}