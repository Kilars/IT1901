package bookingsystem.core;

import java.util.*;

public class Booking {

    

    User customer;
    HairDresser hairdresser;
    Treatment treatment;
   
    public Booking(User customer, HairDresser hairdresser, Treatment treatment) {
        setHairdresser(hairdresser);
        setTreatment(treatment);
        setCustomer(customer);
    }
    /**
     * @param customer the customer to set
     */
    public void setCustomer(User customer) {
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
    
}