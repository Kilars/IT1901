package bookingsystem.core;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

public class Booking {

    private User customer;
    private HairDresser hairdresser;
    private Treatment treatment;
    private LocalDate date;
    private String time;
   
    public Booking(User customer, HairDresser hairdresser, Treatment treatment, LocalDate date, String time) {
        setHairdresser(hairdresser);
        setTreatment(treatment);
        setCustomer(customer);
        setDate(date);
        setTime(time);
    }

    public Booking() {
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(User customer) {
        System.out.println("Cost " + this.customer + " " + customer);
        if (this.customer != null) {
            this.customer.removeBooking(this);
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer doesn't exist");
        }
        this.customer = customer;
        this.customer.addBooking(this);
    }

    

    /**
     * @param hairdresser the hairdresser to set
     */
    public void setHairdresser(HairDresser hairdresser) {
        this.hairdresser = hairdresser;
    }


    /**
     * @param treatment the treatment to set
     */
    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    /**
     * @return the customer
     */
    public User getCustomer() {
        return customer;
    }

    /**
     * @return the hairdresser
     */
    public HairDresser getHairdresser() {
        return hairdresser;
    }

    /**
     * @return the treatment
     */
    public Treatment getTreatment() {
        return treatment;
    }

    /**
     * @return date of treatment
     */
    public LocalDate getDate() {
        return date;
    }

    /**
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
     * @return time of the treatment
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time for treatment
     */
    public void setTime(String time) {    
        if (Pattern.matches("[0-9]{1,2}[:]{3}[0-9]{4,5}",time)) {
                this.time=time;
            }
        else{
            throw new IllegalArgumentException("Vennligst velg et tidspunkt");
        }
    }
    
}