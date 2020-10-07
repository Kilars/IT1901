package bookingsystem.core;

import java.util.*;

public class Booking {

    

    User customer;
    HairDresser hairdresser;
    String treatment;
   

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
    public void setTreatment(String treatment) {
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
    public String getTreatment() {
        return treatment;
    }
    
}