package bookingsystem.core;

public class Treatment {


public String treatment;
public double price;

public Treatment(String treatment, double price) {
    this.price = price;
    this.treatment = treatment;
}

public Treatment() {
    
}

/**
 * @param price the price to set
 */
public void setPrice(double price) {
    this.price = price;
}

/**
 * @return the price
 */
public double getPrice() {
    return price;
}

/**
 * @param treatment the treatment to set
 */
public void setTreatment(String treatment) {
    this.treatment = treatment;
}

/**
 * @return the treatment
 */
public String getTreatment() {
    return treatment;
}
}