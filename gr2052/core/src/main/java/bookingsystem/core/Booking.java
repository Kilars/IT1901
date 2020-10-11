package bookingsystem.core;

import java.time.LocalDate;
import java.util.*;

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
        if (this.customer != null) {
            this.customer.removeBooking(this);
        }
        customer.addBooking(this);
        this.customer = customer;
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
        this.date = date;
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
        this.time = time;
    }
    
}