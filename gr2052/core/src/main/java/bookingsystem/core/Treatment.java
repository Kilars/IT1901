package bookingsystem.core;

/**
 * Class for treatments. Each treatment has a treatment name and a price
 * The class has to constructors, one with no parameters, and one with parameters.
 */
public class Treatment {

public String treatment;
public double price;

/**
 * Constructor with one string parameter and one double parameter.
 * @param treatment     String representing the treatment name
 * @param price         Double representing the treatment price
 */
public Treatment(String treatment, double price) {
    this.price = price;
    this.treatment = treatment;
}

/**
 * Constructor with no parameters.
 */
public Treatment() {
    
}

/**
 * Method to set the treatment price
 * @param price     the price to set
 */
public void setPrice(double price) {
    this.price = price;
}

/**
 * Method to return the treatment price
 * @return the price
 */
public double getPrice() {
    return price;
}

/**
 * Method to set the treatment name
 * @param treatment     the treatment to set
 */
public void setTreatment(String treatment) {
    this.treatment = treatment;
}

/**
 * Method to return the treatment name.
 * @return the treatment
 */
public String getTreatment() {
    return treatment;
}

}